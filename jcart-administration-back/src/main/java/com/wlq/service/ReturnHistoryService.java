package com.wlq.service;

import com.wlq.po.ReturnHistory;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-10-15:36
 */
public interface ReturnHistoryService {

    List<ReturnHistory> getListByReturnId(Integer returnId);

    Long create(ReturnHistory returnHistory);
}
