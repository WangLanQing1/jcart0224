package com.wlq.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class OrderHistory {
    private Long orderHistoryId;

    private Long orderId;

    private Date time;

    private Byte orderStatus;

    private String comment;

    private Boolean customerNotified;
}