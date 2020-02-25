package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:46
 */
@Data
public class OrderListOutDTO {
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Byte status;
    private Double totalPrice;
    private Long createTimestamp;
}
