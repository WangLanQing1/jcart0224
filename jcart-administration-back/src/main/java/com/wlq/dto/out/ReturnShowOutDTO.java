package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:28
 */
@Data
public class ReturnShowOutDTO {
    private Integer returnId;
    private Long orderId;
    private Long orderTimestamp;
    private Integer customerId;
    private String customerName;
    private String mobile;
    private String email;
    private Byte status;
    private Byte action;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
    private Long createTimestamp;
    private Long updateTimestamp;
}
