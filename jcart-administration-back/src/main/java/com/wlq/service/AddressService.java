package com.wlq.service;

import com.wlq.po.Address;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-09-20:17
 */
public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);
}
