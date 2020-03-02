package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:10
 */
@Data
@ToString
public class CustomerLoginOutDTO {
    private String token;
    private Long expireTimestamp;
}
