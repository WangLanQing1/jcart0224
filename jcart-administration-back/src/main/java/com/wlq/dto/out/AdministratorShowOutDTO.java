package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:18
 */
@Data
public class AdministratorShowOutDTO {
    private Integer administratorId;
    private String username;
    private String email;
    private String avatarUrl;
    private Byte status;
}
