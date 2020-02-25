package com.wlq.controller;

import com.wlq.dto.in.CustomerSearchInDTO;
import com.wlq.dto.out.CustomerListOutDTO;
import com.wlq.dto.out.CustomerShowOutDTO;
import com.wlq.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:31
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     * 对客户进行查询并分页
     * @param customerSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam Integer pageNum){
        return null;
    }

    /**
     * 根据customerId进行查询用户
     * @param customerId
     * @return
     */
    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    /**
     *
     * @param customerId
     */
    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){

    }
}
