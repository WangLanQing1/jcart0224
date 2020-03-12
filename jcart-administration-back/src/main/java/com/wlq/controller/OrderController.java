package com.wlq.controller;

import com.github.pagehelper.Page;
import com.wlq.dto.in.OrderSearchInDTO;
import com.wlq.dto.out.*;
import com.wlq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:45
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 查询订单列表并分页
     * @param orderSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam Integer pageNum){
        Page<OrderListOutDTO> page = orderService.search(orderSearchInDTO,pageNum);

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    /**
     * 根据订单id进行查询
     * @param orderId
     * @return
     */
    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO order = orderService.getById(orderId);
        return  order;
    }

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
