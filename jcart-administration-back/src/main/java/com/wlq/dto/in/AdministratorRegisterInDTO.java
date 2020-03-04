package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-04-15:54
 */
@Data
@ToString
public class AdministratorRegisterInDTO {
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private Boolean newSubscribed;
}
