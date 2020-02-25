package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:43
 */
@Data
public class AddressListOutDTO {
    private Integer addressId;
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tag;
}
