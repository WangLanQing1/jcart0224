package com.wlq.dto.out;

import com.wlq.vo.OrderProductVO;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-17:54
 */
@Data
public class OrderShowOutDTO {
    private Long orderId;
    private Integer customerId;
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
    private List<OrderProductVO> orderProducts;
    private String customerName;
}
