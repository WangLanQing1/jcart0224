package com.wlq.controller;

import com.github.pagehelper.Page;
import com.wlq.dto.in.CustomerSearchInDTO;
import com.wlq.dto.in.CustomerSetStatusInDTO;
import com.wlq.dto.out.CustomerListOutDTO;
import com.wlq.dto.out.CustomerShowOutDTO;
import com.wlq.dto.out.OrderListOutDTO;
import com.wlq.dto.out.PageOutDTO;
import com.wlq.po.Address;
import com.wlq.po.Customer;
import com.wlq.service.AddressService;
import com.wlq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:31
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    /**
     * 对客户进行查询并分页
     * @param customerSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam Integer pageNum){
        Page<Customer> page = customerService.search(pageNum);

        List<CustomerListOutDTO> customerListOutDTOS = page.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return customerListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(customerListOutDTOS);

        return pageOutDTO;
    }

    /**
     * 根据customerId进行查询用户
     * @param customerId
     * @return
     */
    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        Customer customer = customerService.getById(customerId);

        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customerId);
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());

        Address defaultAddress = addressService.getById(customer.getDefaultAddressId());
        if (defaultAddress != null){
            customerShowOutDTO.setDefaultAddress(defaultAddress.getContent());
        }

        return customerShowOutDTO;
    }

    /**
     *
     * @param CustomerSetStatusInDTO
     */
    @PostMapping("/disable")
    public void disable(@RequestParam CustomerSetStatusInDTO CustomerSetStatusInDTO){
        customerService.setStatus(CustomerSetStatusInDTO);
    }
}
