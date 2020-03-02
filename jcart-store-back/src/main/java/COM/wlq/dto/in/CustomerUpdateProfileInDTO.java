package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:17
 */
@Data
@ToString
public class CustomerUpdateProfileInDTO {
    private String realName;
    private String mobile;
    private String email;
}
