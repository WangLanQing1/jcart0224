package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.out.ProductListOutDTO;
import com.wlq.dto.out.ProductShowOutDTO;
import com.wlq.po.Product;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-15:18
 */
public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);
}
