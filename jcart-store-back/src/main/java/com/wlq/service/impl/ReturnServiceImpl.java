package com.wlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.dao.ReturnMapper;
import com.wlq.po.Return;
import com.wlq.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-11-15:54
 */
@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }

    @Override
    public Page<Return> getPageByCustomerId(Integer customerId,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.selectPageByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }
}
