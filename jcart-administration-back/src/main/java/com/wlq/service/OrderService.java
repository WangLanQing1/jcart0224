package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.in.OrderSearchInDTO;
import com.wlq.dto.out.*;
import com.wlq.po.Order;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-17:36
 */
public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    OrderInvoiceShowOutDTO getInvoiceInfo(Long orderId);

    OrderShipShowOutDTO getShipInfo(Long orderId);

    void update(Order order);
}
