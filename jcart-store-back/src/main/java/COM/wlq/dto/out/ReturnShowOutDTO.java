package com.wlq.dto.out;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import lombok.Data;
import org.omg.CORBA.INTERNAL;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-15:01
 */
@Data
public class ReturnShowOutDTO {
    private Integer returnId;
    private Integer orderId;
    private Long orderTimestamp;
    private String customerName;
    private String mobile;
    private String email;
    private Byte status;
    private Byte action;
    private String productCode;
    private String priductName;
    private Integer quantity;
    private Byte reason;
    private String comment;
    private Long createTimestamp;
    private Long updateTimestamp;
}
