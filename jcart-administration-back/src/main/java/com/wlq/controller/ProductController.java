package com.wlq.controller;

import com.wlq.dto.in.ProductCreateInDTO;
import com.wlq.dto.in.ProductSearchInDTO;
import com.wlq.dto.in.ProductUpdateInDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.dto.out.ProductListOutDTO;
import com.wlq.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-18:02
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){return null;}

    @PostMapping("create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){return null;}

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){

    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){

    }
}
