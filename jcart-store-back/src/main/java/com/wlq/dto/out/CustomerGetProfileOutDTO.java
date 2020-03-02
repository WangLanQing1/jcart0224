package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:12
 */
@Data
@ToString
public class CustomerGetProfileOutDTO {
    private Integer customerId;
    private String username;
    private String realName;
    private String mobile;
    private Boolean mobileVerified;
    private String email;
    private Boolean emailVerified;
}
