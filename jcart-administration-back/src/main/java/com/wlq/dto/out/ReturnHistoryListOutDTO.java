package com.wlq.dto.out;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:37
 */
@Data
public class ReturnHistoryListOutDTO {
    private Long returnHistoryId;
    private Long timestamp;
    private Byte returnStatus;
    private String comment;
    private Boolean customerNotified;
}
