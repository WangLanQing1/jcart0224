package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:32
 */
@Data
public class CustomerListOutDTO {
    private Integer customerId;
    private String username;
    private String realName;
    private String mobile;
    private String email;
    private Byte status;
    private Long createTimestamp;
}
