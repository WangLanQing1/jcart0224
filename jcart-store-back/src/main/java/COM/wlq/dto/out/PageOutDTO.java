package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:35
 */
@Data
@ToString
public class PageOutDTO<T> {
    private Long total;
    private Integer pageSize;
    private Integer pageNum;
    private List<T> list;
}
