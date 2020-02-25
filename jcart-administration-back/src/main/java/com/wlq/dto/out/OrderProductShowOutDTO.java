package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:54
 */
@Data
public class OrderProductShowOutDTO {
    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Integer unitRewirdPoints;
}
