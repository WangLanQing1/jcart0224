package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:16
 */
@Data
public class OrderHistoryListOutDTO {
    private Long orderHistoryId;
    private Long timestamp;
    private Byte orderStatus;
    private String comment;
    private Boolean customerNotified;
}
