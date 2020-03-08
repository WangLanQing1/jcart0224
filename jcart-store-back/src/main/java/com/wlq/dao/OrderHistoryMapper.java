package com.wlq.dao;

import com.github.pagehelper.Page;
import com.wlq.po.Order;
import com.wlq.po.OrderHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderHistoryMapper {
    int deleteByPrimaryKey(Long orderHistoryId);

    int insert(OrderHistory record);

    int insertSelective(OrderHistory record);

    OrderHistory selectByPrimaryKey(Long orderHistoryId);

    int updateByPrimaryKeySelective(OrderHistory record);

    int updateByPrimaryKey(OrderHistory record);

    //custom
    List<OrderHistory> selectByOrderId(@Param("orderId")Long orderId);
}