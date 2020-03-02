package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:36
 */
@Data
@ToString
public class OrderListOutDTO {
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Integer totalProducts;
    private Byte status;
    private Double totalPrice;
    private Long createTimestamp;
}
