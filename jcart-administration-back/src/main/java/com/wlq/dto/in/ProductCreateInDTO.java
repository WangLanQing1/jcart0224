package com.wlq.dto.in;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:13
 */
@Data
public class ProductCreateInDTO {
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
    private String ProductAbstract;
    private List<String> otherPicUrls;
}
