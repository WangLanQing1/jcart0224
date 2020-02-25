package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:34
 */
@Data
public class CustomerSearchInDTO {
    private String username;
    private String realName;
    private String mobile;
    private String email;
    private Byte status;
}
