package com.wlq.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlq.dao.ProductDetailMapper;
import com.wlq.dao.ProductMapper;
import com.wlq.dto.in.ProductCreateInDTO;
import com.wlq.dto.in.ProductUpdateInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ProductListOutDTO;
import com.wlq.dto.out.ProductShowOutDTO;
import com.wlq.po.Product;
import com.wlq.po.ProductDetail;
import com.wlq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Target;
import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-17:38
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {
        Product product = new Product();
        System.out.println(productCreateInDTO);
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        String description = productCreateInDTO.getDescription();
        product.setProductAbstract(productCreateInDTO.getProductAbstract());
        productMapper.insertSelective(product);

        Integer productId = product.getProductId();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.insertSelective(productDetail);

        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {
        Product product = new Product();
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStockQuantity(productUpdateInDTO.getStockQuantity());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setMainPicUrl(productUpdateInDTO.getMainPicUrl());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        String description = productUpdateInDTO.getDescription();
        String productAbstract=description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(productAbstract);
        productMapper.updateByPrimaryKeySelective(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        List<String> otherPicUrls = productUpdateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void batchDelete(List<Integer> productIds) {
        productMapper.batchDelete(productIds);
        productDetailMapper.batchDelete(productIds);
    }

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOutDTO> page = productMapper.search();
        return page;
    }

    @Override
    public ProductShowOutDTO getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);
        //设置展示商品信息部分
        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(productId);
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setStatus(product.getStatus());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setSortOrder(product.getSortOrder());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());
        //设置展示商品详情页面
        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrls = JSON.parseArray(otherPicUrlsJson,String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrls);

        return productShowOutDTO;
    }
}
