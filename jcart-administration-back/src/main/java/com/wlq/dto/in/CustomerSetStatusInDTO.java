package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-19:41
 */
@Data
@ToString
public class CustomerSetStatusInDTO {

    private Integer customerId;
    private Byte status;
}
