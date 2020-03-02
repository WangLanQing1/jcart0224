package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:23
 */
@Data
@ToString
public class CustomerResetPwdInDTO {
    private String email;
    private String resetCode;
    private String newPwd;
}
