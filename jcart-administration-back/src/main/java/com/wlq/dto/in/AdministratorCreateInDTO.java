package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:23
 */
@Data
public class AdministratorCreateInDTO {
    private String username;
    private String password;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;
}
