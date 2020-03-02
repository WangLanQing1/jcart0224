package com.wlq.dto.in;

import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:06
 */
@Data
public class ProductSearchInDTO {
    private String keyword;
    private Byte sortBy;
}
