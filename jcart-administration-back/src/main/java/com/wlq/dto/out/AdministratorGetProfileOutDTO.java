package com.wlq.dto.out;

import lombok.Data;
import org.omg.CORBA.INTERNAL;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:02
 */
@Data
public class AdministratorGetProfileOutDTO {

    private Integer administratorId;
    private String username;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;
    private Long createTimestamp;
}
