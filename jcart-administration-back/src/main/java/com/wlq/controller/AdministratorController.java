package com.wlq.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.auth0.jwt.JWT;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.constant.ClientExceptionConstant;
import com.wlq.dto.in.*;
import com.wlq.dto.out.*;
import com.wlq.enumeration.AdministratorStatus;
import com.wlq.exception.ClientException;
import com.wlq.po.Administrator;
import com.wlq.service.AdministratorService;
import com.wlq.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-16:43
 */

@RestController
@RequestMapping("/administrator")
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/login")
    public AdministratorLoginOutDTO login( AdministratorLoginInDTO administratorLoginInDTO) throws ClientException {
        Administrator administrator = administratorService.getByUsername(administratorLoginInDTO.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(administratorLoginInDTO.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministratorLoginOutDTO administratorLoginOutDTO = jwtUtil.issueToken(administrator);
            return administratorLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false)Integer adminstratorId){
        Administrator administrator = administratorService.getById(adminstratorId);
        AdministratorGetProfileOutDTO administratorGetProfileOutDTO = new AdministratorGetProfileOutDTO();
        administratorGetProfileOutDTO.setAdministratorId(adminstratorId);
        administratorGetProfileOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
        administratorGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorGetProfileOutDTO.setEmail(administrator.getEmail());
        administratorGetProfileOutDTO.setRealName(administrator.getRealName());
        administratorGetProfileOutDTO.setStatus(administrator.getStatus());
        administratorGetProfileOutDTO.setUsername(administrator.getUsername());

        return administratorGetProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO,
                              @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setEmail(administratorUpdateProfileInDTO.getEmail());
        administrator.setRealName(administratorUpdateProfileInDTO.getRealName());
        administrator.setAvatarUrl(administratorUpdateProfileInDTO.getAvatarUrl());
        administratorService.update(administrator);
    }

    /**
     * 获取密码重置码
     * @param email
     * @return
     */
    @GetMapping("/getPwdResetCode")
    public String getPwdResetCode(@RequestParam String email){
        return null;
    }

    /**
     *  重置密码
     * @param administratorResetPwdInDTO
     */
    @PostMapping("resetPwd")
    public void resetPwd(@RequestBody AdministratorResetPwdInDTO administratorResetPwdInDTO){

    }

    /**
     * 分页查询管理员信息
     * @param pageNum
     * @return
     */
    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        Page<Administrator> page = administratorService.getList(pageNum);
        List<AdministratorListOutDTO> administratorListOutDTOS = page.stream().map(administrator -> {
            AdministratorListOutDTO administratorListOutDTO = new AdministratorListOutDTO();
            administratorListOutDTO.setAdministratorId(administrator.getAdministratorId());
            administratorListOutDTO.setUsername(administrator.getUsername());
            administratorListOutDTO.setStatus(administrator.getStatus());
            administratorListOutDTO.setRealName(administrator.getRealName());
            administratorListOutDTO.setStatus(administrator.getStatus());
            administratorListOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
            return administratorListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<AdministratorListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(administratorListOutDTOS);

        return pageOutDTO;
    }

    /**
     * 根据id查询管理员，进行展示
     * @param administratorId
     * @return
     */
    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);

        AdministratorShowOutDTO administratorShowOutDTO = new AdministratorShowOutDTO();
        administratorShowOutDTO.setUsername(administrator.getUsername());
        administratorShowOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorShowOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorShowOutDTO.setEmail(administrator.getEmail());
        administratorShowOutDTO.setStatus(administrator.getStatus());

        return administratorShowOutDTO;
    }

    /**
     * 创建管理员用户
     * @param administratorCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        Administrator administrator = new Administrator();
        administrator.setUsername(administratorCreateInDTO.getUsername());
        administrator.setRealName(administratorCreateInDTO.getRealName());
        administrator.setAvatarUrl(administratorCreateInDTO.getAvatarUrl());
        administrator.setEmail(administratorCreateInDTO.getEmail());
        administrator.setStatus((byte)AdministratorStatus.Enable.ordinal());
        administrator.setCreateTime(new Date());
        //bcrypt加密密码
        String password = BCrypt.withDefaults().hashToString(12, administratorCreateInDTO.getPassword().toCharArray());
        administrator.setEncryptedPassword(password);

        Integer administratorId = administratorService.create(administrator);

        return administratorId;
    }

    /**
     * 管理员修改
     * @param administratorUpdateInDTO
     */
    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorUpdateInDTO.getAdministratorId());
        administrator.setRealName(administratorUpdateInDTO.getRealName());
        administrator.setAvatarUrl(administratorUpdateInDTO.getAvatarUrl());
        administrator.setEmail(administratorUpdateInDTO.getEmail());
        administrator.setStatus(administratorUpdateInDTO.getStatus());
        String password = administratorUpdateInDTO.getPassword();
        if (password != null && !password.isEmpty()){
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            administrator.setEncryptedPassword(bcryptHashString);
        }
        administratorService.update(administrator);
    }

    /**
     * 管理员删除
     * @param administratorId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){
        administratorService.delete(administratorId);
    }

    /**
     * 批量删除管理员
     * @param administratorIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){
        administratorService.batchDelete(administratorIds);
    }
}
