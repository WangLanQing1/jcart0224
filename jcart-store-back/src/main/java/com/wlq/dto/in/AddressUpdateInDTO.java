package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:02
 */
@Data
@ToString
public class AddressUpdateInDTO {
    private Integer addressId;
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
