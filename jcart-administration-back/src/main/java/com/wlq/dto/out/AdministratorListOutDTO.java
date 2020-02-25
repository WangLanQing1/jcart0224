package com.wlq.dto.out;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:15
 */
@Data
public class AdministratorListOutDTO {

    private Integer administratorId;
    private String username;
    private Byte status;
    private Long createTimestamp;

}
