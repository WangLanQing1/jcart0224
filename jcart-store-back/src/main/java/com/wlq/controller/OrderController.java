package com.wlq.controller;

import com.wlq.dto.out.OrderListOutDTO;
import com.wlq.dto.out.OrderShowOutDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.in.OrderCheckoutInDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:28
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
