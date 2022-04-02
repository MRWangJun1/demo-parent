package com.example.demo.dao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author wangjun
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Integer orderDetailId;

    /**
     * 订单号
     */
    private String flowId;

    /**
     * 通用名
     */
    private String shortName;

    /**
     * 品名
     */
    private String productName;

    /**
     * 供应商ID
     */
    private Integer sellerCode;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 购买单品数量
     */
    private Integer productCount;

    /**
     * SPU编码(一号药城商品编码)
     */
    private String spuCode;

    /**
     * 商品总金额
     */
    private BigDecimal productTotal;


}
