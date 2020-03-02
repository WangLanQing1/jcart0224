package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:11
 */
@Data
@ToString
public class CustomerLoginInDTO {
    private String username;
    private String password;
}
