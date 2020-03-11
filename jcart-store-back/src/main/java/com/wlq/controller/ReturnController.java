package com.wlq.controller;

import com.github.pagehelper.Page;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ReturnHistoryListOutDTO;
import com.wlq.dto.out.ReturnShowOutDTO;
import com.wlq.dto.in.ReturnApplyInDTO;
import com.wlq.dto.out.ReturnListOutDTO;
import com.wlq.enumeration.ReturnStatus;
import com.wlq.po.Return;
import com.wlq.po.ReturnHistory;
import com.wlq.service.ReturnHistoryService;
import com.wlq.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:54
 */
@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        Return aReturn = new Return();
        aReturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        aReturn.setReason(returnApplyInDTO.getReason());
        aReturn.setQuantity(returnApplyInDTO.getQuantity());
        aReturn.setProductName(returnApplyInDTO.getProductName());
        aReturn.setProductCode(returnApplyInDTO.getProductCode());
        aReturn.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        aReturn.setOrderId(returnApplyInDTO.getOrderId());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setCustomerId(customerId);
        Date now = new Date();
        aReturn.setCreateTime(now);
        aReturn.setUpdateTime(now);
        aReturn.setComment(returnApplyInDTO.getComment());
        returnService.create(aReturn);

        Integer returnId = aReturn.getReturnId();
        return returnId;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam Integer pageNum){
        Page<Return> page = returnService.getPageByCustomerId(customerId, pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> PageOutDTO = new PageOutDTO<>();
        PageOutDTO.setTotal(page.getTotal());
        PageOutDTO.setPageNum(page.getPageNum());
        PageOutDTO.setPageSize(page.getPageSize());
        PageOutDTO.setList(returnListOutDTOS);

        return PageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());

        List<ReturnHistory> returnHistories = returnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);

        return returnShowOutDTO;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }
}
