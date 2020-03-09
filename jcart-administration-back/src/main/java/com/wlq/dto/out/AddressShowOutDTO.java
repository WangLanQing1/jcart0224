package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-20:24
 */
@Data
@ToString
public class AddressShowOutDTO {
    private String ReceiverName;
    private Integer AddressId;
    private String ReceiverMobile;
    private String content;
    private String tag;
}
