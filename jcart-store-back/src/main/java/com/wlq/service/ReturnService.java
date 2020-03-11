package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.po.Return;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-11-15:50
 */
public interface ReturnService {

    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId,Integer pageNum);

    Return getById(Integer returnId);
}
