package com.wlq.service;

import com.wlq.dto.in.CustomerLoginInDTO;
import com.wlq.dto.in.CustomerRegisterInDTO;
import com.wlq.dto.out.CustomerGetProfileOutDTO;
import com.wlq.dto.out.CustomerLoginOutDTO;
import com.wlq.po.Customer;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-17:43
 */
public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);
}
