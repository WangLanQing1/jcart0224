package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:19
 */
@Data
public class OrderHistoryCreateInDTO {
    private Long orderId;
    private Byte orderStatus;
    private String comment;
    private Boolean customerNotified;
}
