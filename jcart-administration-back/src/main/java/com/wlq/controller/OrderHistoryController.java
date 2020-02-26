package com.wlq.controller;

import com.wlq.dto.in.OrderHistoryCreateInDTO;
import com.wlq.dto.out.OrderHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:14
 */
@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        return null;
    }
    @PostMapping("/create")
    public Integer create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        return null;
    }
}
