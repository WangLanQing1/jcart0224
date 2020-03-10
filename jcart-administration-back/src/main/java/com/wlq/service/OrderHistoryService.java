package com.wlq.service;

import com.wlq.po.OrderHistory;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-10-10:54
 */
public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
