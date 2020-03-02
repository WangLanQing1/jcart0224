package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:31
 */
@Data
@ToString
public class OrderProductInDTO {
    private Integer productId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Integer unitRewordPoints;
}
