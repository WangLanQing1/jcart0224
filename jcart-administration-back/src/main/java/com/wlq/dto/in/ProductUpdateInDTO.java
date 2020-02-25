package com.wlq.dto.in;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:17
 */
@Data
public class ProductUpdateInDTO {
    private Integer productId;
    private String productName;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private Byte status;
    private String mainPicUrl;
    private Integer rewordPoints;
    private Integer sortOrder;
    private String description;
    private List<String> otherPicUrls;
}
