package com.wlq.dto.in;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:19
 */
@Data
@ToString
public class CustomerChangePwdInDTO {
    private String originPwd;
    private String newPwd;
}
