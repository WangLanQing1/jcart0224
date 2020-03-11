package com.wlq.service;

import com.wlq.po.ReturnHistory;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-11-16:05
 */
public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);
}
