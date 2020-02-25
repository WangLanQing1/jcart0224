package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:37
 */
@Data
public class CustomerShowOutDTO {
    private Integer customerId;
    private String username;
    private String realName;
    private String avatarUrl;
    private String mobile;
    private String email;
    private Byte status;
    private Long createTimestamp;
    private Boolean newsSubscribed;
    private Integer rewordPoints;
}
