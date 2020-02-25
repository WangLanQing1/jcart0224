package com.wlq.controller;

import com.wlq.dto.in.*;
import com.wlq.dto.out.AdministratorGetProfileOutDTO;
import com.wlq.dto.out.AdministratorListOutDTO;
import com.wlq.dto.out.AdministratorShowOutDTO;
import com.wlq.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-16:43
 */

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false)Integer adminstratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

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
        return null;
    }

    /**
     * 根据id查询管理员，进行展示
     * @param administratorId
     * @return
     */
    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        return null;
    }

    /**
     * 创建管理员用户
     * @param administratorCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        return null;
    }

    /**
     * 管理员修改
     * @param administratorUpdateInDTO
     */
    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){}

    /**
     * 管理员删除
     * @param administratorId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){

    }

    /**
     * 批量删除管理员
     * @param administratorIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){

    }
}
