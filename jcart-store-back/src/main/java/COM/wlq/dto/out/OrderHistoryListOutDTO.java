package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:43
 */
@Data
@ToString
public class OrderHistoryListOutDTO {
    private Long timestamp;
    private Byte orderStatus;
    private String comment;
}
