package com.wlq.dto.in;

import javafx.beans.NamedArg;
import lombok.Data;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:06
 */
@Data
public class ProductSearchInDTO {
    private String productCode;
    private String productName;
    private Double price;
    private Integer stockQuantity;
    private Byte status;
}
