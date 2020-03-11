package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-11-16:30
 */
@Data
@ToString
public class ReturnHistoryListOutDTO {
    private Long timestamp;
    private Byte returnStatus;
    private String comment;
}
