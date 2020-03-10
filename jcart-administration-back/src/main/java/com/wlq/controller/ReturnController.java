package com.wlq.controller;

import com.github.pagehelper.Page;
import com.wlq.dto.in.ReturnSearchInDTO;
import com.wlq.dto.in.ReturnUpdateActionInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ReturnListOutDTO;
import com.wlq.dto.out.ReturnShowOutDTO;
import com.wlq.po.Return;
import com.wlq.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:21
 */
@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        Page<Return> page = returnService.search(pageNum);

        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(p -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setUpdateTimestamp(p.getUpdateTime().getTime());
            returnListOutDTO.setCreateTimestamp(p.getCreateTime().getTime());
            returnListOutDTO.setStatus(p.getStatus());
            returnListOutDTO.setReturnId(p.getReturnId());
            returnListOutDTO.setProductName(p.getProductName());
            returnListOutDTO.setProductCode(p.getProductCode());
            returnListOutDTO.setOrderId(p.getOrderId());
            returnListOutDTO.setCustomerName(p.getCustomerName());
            returnListOutDTO.setCustomerId(p.getCustomerId());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(returnListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setCustomerId(aReturn.getCustomerId());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setComment(aReturn.getComment());

        return returnShowOutDTO;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){
        Return aReturn = new Return();
        aReturn.setReturnId(returnUpdateActionInDTO.getReturnId());
        aReturn.setAction(returnUpdateActionInDTO.getAction());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);
    }
}