package com.wlq.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.dao.OrderDetailMapper;
import com.wlq.dao.OrderMapper;
import com.wlq.dto.out.*;
import com.wlq.po.Customer;
import com.wlq.po.Order;
import com.wlq.po.OrderDetail;
import com.wlq.service.CustomerService;
import com.wlq.service.OrderService;
import com.wlq.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-17:46
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private CustomerService customerService;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOutDTO> orderListOutDTOPageOutDTO = orderMapper.selectList();
        return orderListOutDTOPageOutDTO;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();

        Order order = orderMapper.selectByPrimaryKey(orderId);
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setInvoicePrice(order.getTotalPrice());
        Customer customer = customerService.getById(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getUsername());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());

        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
        orderShowOutDTO.setComment(orderDetail.getComment());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        return orderShowOutDTO;
    }

    @Override
    public OrderInvoiceShowOutDTO getInvoiceInfo(Long orderId) {
        return null;
    }

    @Override
    public OrderShipShowOutDTO getShipInfo(Long orderId) {
        return null;
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
