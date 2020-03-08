package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.in.OrderCheckoutInDTO;
import com.wlq.dto.out.OrderShowOutDTO;
import com.wlq.po.Order;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-08-17:05
 */
public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum,Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
