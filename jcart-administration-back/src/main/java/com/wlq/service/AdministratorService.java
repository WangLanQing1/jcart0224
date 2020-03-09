package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.in.AdministratorRegisterInDTO;
import com.wlq.po.Administrator;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-04-15:52
 */
public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    Administrator getByEmail(String email);

    Integer create(Administrator administrator);

    void update(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);
}
