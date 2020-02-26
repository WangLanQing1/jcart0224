package com.wlq.dto.in;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:42
 */
@Data
public class ReturnHistoryCreateInDTO {
    private Integer returnId;
    private Byte returnStatus;
    private Boolean customerNotified;
    private String comment;
}
