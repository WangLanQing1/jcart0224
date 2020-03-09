package com.wlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.dao.CustomerMapper;
import com.wlq.dto.in.CustomerSetStatusInDTO;
import com.wlq.po.Customer;
import com.wlq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-19:42
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Customer> page = customerMapper.search();
        return page;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO) {
        Customer customer = new Customer();
        customer.setStatus(customerSetStatusInDTO.getStatus());
        customer.setCustomerId(customerSetStatusInDTO.getCustomerId());
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
