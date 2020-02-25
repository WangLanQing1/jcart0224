package com.wlq.dto.out;

import sun.awt.image.IntegerInterleavedRaster;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:08
 */
public class ProductShowOutDTO {
    private Integer productId;
    private String productCode;
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
