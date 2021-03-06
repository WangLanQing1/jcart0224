package com.wlq.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.dao.OrderDetailMapper;
import com.wlq.dao.OrderMapper;
import com.wlq.dao.ProductMapper;
import com.wlq.dto.in.OrderCheckoutInDTO;
import com.wlq.dto.in.OrderProductInDTO;
import com.wlq.dto.out.OrderHistoryListOutDTO;
import com.wlq.dto.out.OrderShowOutDTO;
import com.wlq.enumeration.OrderStatus;
import com.wlq.po.*;
import com.wlq.service.AddressService;
import com.wlq.service.OrderHistoryService;
import com.wlq.service.OrderService;
import com.wlq.service.ProductService;
import com.wlq.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-08-17:08
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId) {
        List<OrderProductInDTO> orderProducts =orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS = orderProducts.stream().map(orderProductInDTO -> {
            Product orderProduct = productService.getById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();

            orderProductVO.setProductId(orderProduct.getProductId());
            orderProductVO.setProductCode(orderProduct.getProductCode());
            orderProductVO.setProductName(orderProduct.getProductName());
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVO.setQuantity(quantity);
            Double unitPrice = orderProduct.getPrice() * orderProduct.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);
            Double totalPrice = unitPrice * quantity;
            orderProductVO.setTotalPrice(totalPrice);
            Integer unitRewordPoints = orderProduct.getRewordPoints();
            orderProductVO.setUnitRewordPoints(unitRewordPoints);
            Integer totalRewordPoints = unitRewordPoints * quantity;
            orderProductVO.setTotalRewordPoints(totalRewordPoints);
            return orderProductVO;
        }).collect(Collectors.toList());

        //总价
        double allTotalPrice = orderProductVOS.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        //总积分
        int allTotalRewordPoints = orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(allTotalPrice);
        order.setRewordPoints(allTotalRewordPoints);
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        
        orderMapper.insertSelective(order);
        Long orderId = order.getOrderId();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        orderDetail.setShipPrice(5.0);

        Address address = addressService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddress(address.getContent());
        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(allTotalPrice);

        Address invoiceAddress = addressService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());
        orderDetail.setComment(orderCheckoutInDTO.getComment());
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));

        orderDetailMapper.insert(orderDetail);

        return orderId;
    }

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Order> page = orderMapper.selectByCustomerId(customerId);
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        List<OrderHistory> orderHistories = orderHistoryService.getByOrderId(orderId);

        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        orderShowOutDTO.setOrderHistories(orderHistoryListOutDTOS);

        return orderShowOutDTO;
    }
}
