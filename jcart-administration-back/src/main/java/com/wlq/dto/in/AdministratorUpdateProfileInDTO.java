package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:09
 */
@Data
public class AdministratorUpdateProfileInDTO {

    private String realName;
    private String email;
    private String avatarUrl;
    private String password;
    private Byte status;
}
