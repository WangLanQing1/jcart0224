package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-08-16:50
 */
@Data
public class AddressShowOutDTO {
    private Integer addressId;
    private String tag;
    private String receiverName;
    private String receiverMobile;
    private String content;
}
