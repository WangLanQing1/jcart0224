package com.wlq.controller;

import com.wlq.dto.in.ReturnHistoryCreateInDTO;
import com.wlq.dto.out.ReturnHistoryListOutDTO;
import com.wlq.po.ReturnHistory;
import com.wlq.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:35
 */
@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        List<ReturnHistory> ReturnHistories = returnHistoryService.getListByReturnId(returnId);

        List<ReturnHistoryListOutDTO> ReturnHistoryListOutDTOS = ReturnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setReturnHistoryId(returnHistory.getReturnHistoryId());
            returnHistoryListOutDTO.setCustomerNotified(returnHistory.getCustomerNotified());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());

        return ReturnHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Long create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        ReturnHistory returnHistory = new ReturnHistory();

        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        Boolean customerNotified = returnHistoryCreateInDTO.getCustomerNotified();
        returnHistory.setCustomerNotified(customerNotified);
        Long returnHistoryId = returnHistoryService.create(returnHistory);

        if (customerNotified != null && customerNotified){

        }

        return returnHistoryId;
    }
}
