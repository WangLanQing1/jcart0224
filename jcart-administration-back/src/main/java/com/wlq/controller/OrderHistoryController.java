package com.wlq.controller;

import com.wlq.dto.in.OrderHistoryCreateInDTO;
import com.wlq.dto.out.OrderHistoryListOutDTO;
import com.wlq.po.OrderHistory;
import com.wlq.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:14
 */
@RestController
@RequestMapping("/orderhistory")
@CrossOrigin
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        List<OrderHistory> orderHistories = orderHistoryService.getByOrderId(orderId);

        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            orderHistoryListOutDTO.setOrderHistoryId(orderHistory.getOrderHistoryId());
            orderHistoryListOutDTO.setCustomerNotified(orderHistory.getCustomerNotified());
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        return orderHistoryListOutDTOS;
    }

    @PostMapping("/create")
    public Long create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setTime(new Date());
        orderHistory.setOrderStatus(orderHistoryCreateInDTO.getOrderStatus());
        orderHistory.setOrderId(orderHistoryCreateInDTO.getOrderId());
        orderHistory.setCustomerNotified(orderHistoryCreateInDTO.getCustomerNotified());
        orderHistory.setComment(orderHistoryCreateInDTO.getComment());

        Long orderHistoryId = orderHistoryService.create(orderHistory);
        return orderHistoryId;
    }
}
