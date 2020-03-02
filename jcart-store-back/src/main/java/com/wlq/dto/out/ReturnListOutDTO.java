package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:58
 */
@Data
@ToString
public class ReturnListOutDTO {
    private Integer returnId;
    private Byte status;
    private Long createTimestamp;
    private Long orderId;
    private Integer customerId;
    private String customerName;
}
