package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-13:54
 */
@Data
@ToString
public class AddressListOutDTO {
    private Integer addressId;
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
