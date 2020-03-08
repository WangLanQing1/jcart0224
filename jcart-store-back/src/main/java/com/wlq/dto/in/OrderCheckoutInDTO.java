package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:29
 */
@Data
@ToString
public class OrderCheckoutInDTO {
    private Short shipMethod;
    private Integer shipAddressId;
    private Double shipPrice;
    private short payMethod;
    private Integer invoiceAddressId;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductInDTO> orderProducts;
}
