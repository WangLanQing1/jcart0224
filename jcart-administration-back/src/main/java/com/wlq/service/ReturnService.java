package com.wlq.service;

import com.github.pagehelper.Page;
import com.wlq.dto.in.ReturnSearchInDTO;
import com.wlq.po.Return;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-10-11:21
 */
public interface ReturnService {

    Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum);

    Return getById(Integer returnId);

    void update(Return areturn);
}
