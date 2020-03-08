package com.wlq.service;

import com.wlq.po.Address;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-08-16:26
 */
public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

    Integer create(Address address);

    void update(Address address);

    void delete(Integer addressId);
}
