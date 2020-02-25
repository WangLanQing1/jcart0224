package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:27
 */
@Data
public class AdministratorUpdateInDTO {
    private Integer administratorId;
    private String realName;
    private String password;
    private String email;
    private Byte status;
}
