package com.wlq.controller;

import com.wlq.dto.in.ProductSearchInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ProductListOutDTO;
import com.wlq.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:46
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false ,defaultValue = "1")Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }
}
