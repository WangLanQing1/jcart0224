package com.wlq.service;

import com.wlq.dto.in.ProductCreateInDTO;
import com.wlq.dto.in.ProductSearchInDTO;
import com.wlq.dto.in.ProductUpdateInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ProductListOutDTO;
import com.wlq.dto.out.ProductShowOutDTO;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-17:39
 */
public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);

    PageOutDTO<ProductListOutDTO> search(Integer pageNum);

    ProductShowOutDTO getById(Integer productId);
}
