package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-04-15:28
 */
@Data
@ToString
public class AdministratorLoginOutDTO {
    private String token;
    private Long exipreTimestamp;
}
