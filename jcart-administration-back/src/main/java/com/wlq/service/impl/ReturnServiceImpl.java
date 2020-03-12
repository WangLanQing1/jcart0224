package com.wlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlq.dao.ReturnMapper;
import com.wlq.dto.in.ReturnSearchInDTO;
import com.wlq.po.Return;
import com.wlq.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-10-11:26
 */
@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> returns = returnMapper.selectList(
                returnSearchInDTO.getReturnId(),
                returnSearchInDTO.getOrderId(),
                returnSearchInDTO.getStartTimestamp() == null ? null : new Date(returnSearchInDTO.getStartTimestamp()),
                returnSearchInDTO.getEndTimestamp() == null ? null : new Date(returnSearchInDTO.getEndTimestamp()),
                returnSearchInDTO.getStatus(),
                returnSearchInDTO.getProductCode(),
                returnSearchInDTO.getCustomerName(),
                returnSearchInDTO.getProductName()
        );
        return returns;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }

    @Override
    public void update(Return areturn) {
        returnMapper.updateByPrimaryKeySelective(areturn);
    }
}
