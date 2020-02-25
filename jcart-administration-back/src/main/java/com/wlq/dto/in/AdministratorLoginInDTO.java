package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-16:58
 */
@Data
@ToString
public class AdministratorLoginInDTO {

    private String username;
    private String password;
}
