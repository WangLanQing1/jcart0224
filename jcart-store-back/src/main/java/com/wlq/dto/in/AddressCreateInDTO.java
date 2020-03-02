package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-13:59
 */
@Data
@ToString
public class AddressCreateInDTO {
    private String receiverName;
    private String receiverMobile;
    private String content;
    private String tagl;
}
