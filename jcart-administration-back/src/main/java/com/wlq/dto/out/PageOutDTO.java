package com.wlq.dto.out;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:16
 */
@Data
public class PageOutDTO<T> {
    private Long total;
    private Integer pageSize;
    private Integer pageNum;
    private List<T> list;
}
