package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:07
 */
@Data
@ToString
public class CustomerRegisterInDTO {
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private String password;
    private Boolean newSubscribed;
}
