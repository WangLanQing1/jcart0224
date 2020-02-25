package com.wlq.controller;

import com.wlq.dto.in.OrderSearchInDTO;
import com.wlq.dto.out.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 查询订单列表并分页
     * @param orderSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam Integer pageNum){
        return null;
    }

    /**
     * 根据订单id进行查询
     * @param orderId
     * @return
     */
    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){return  null;}

    /**
     *
     * @param orderId
     * @return
     */
    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){return null;}

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){return null;}
}
