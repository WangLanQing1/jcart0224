package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:23
 */
@Data
public class ReturnListOutDTO {
    private Integer returnId;
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private String productCode;
    private String productName;
    private Byte status;
    private Long createTimestamp;
    private Long updateTimestamp;
}
