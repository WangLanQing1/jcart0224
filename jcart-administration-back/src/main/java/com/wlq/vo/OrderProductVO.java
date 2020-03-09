package com.wlq.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-20:01
 */
@Data
@ToString
public class OrderProductVO {
    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Integer unitRewordPoints;
    private Integer totalRewordPoints;
}
