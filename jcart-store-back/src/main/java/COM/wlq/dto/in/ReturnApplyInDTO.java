package com.wlq.dto.in;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:54
 */
@Data
@ToString
public class ReturnApplyInDTO {
    private Integer orderId;
    private Long orderTimestamp;
    private String customerName;
    private String mobile;
    private String email;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
}
