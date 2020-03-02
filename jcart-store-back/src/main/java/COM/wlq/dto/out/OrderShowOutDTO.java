package com.wlq.dto.out;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.ShortTypeHandler;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-03-02-14:38
 */
@Data
@ToString
public class OrderShowOutDTO {
    private Long orderId;
    private Byte status;
    private Double totalPrice;
    private Integer rewordPoints;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Short shipMethod;
    private String shipAddress;
    private Double shipPrice;
    private Short payMethod;
    private String invoiceAddress;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductOutDTO> orderProducts;
    private List<OrderHistoryListOutDTO> orderHistories;
}
