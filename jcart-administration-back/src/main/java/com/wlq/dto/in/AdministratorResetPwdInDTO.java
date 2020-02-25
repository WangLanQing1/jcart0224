package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:11
 */
@Data
public class AdministratorResetPwdInDTO {

    private String email;
    private String resetCode;
    private String newPwd;
}
