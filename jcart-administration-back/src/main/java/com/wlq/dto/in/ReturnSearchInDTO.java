package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:25
 */
@Data
public class ReturnSearchInDTO {
    private Integer returnId;
    private Long orderId;
    private String customerName;
    private String productCode;
    private String productName;
    private Byte status;
}
