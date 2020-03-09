package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.in.CustomerSetStatusInDTO;
import com.wlq.po.Customer;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-19:38
 */
public interface CustomerService {

    Page<Customer> search(Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
