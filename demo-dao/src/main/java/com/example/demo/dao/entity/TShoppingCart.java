package com.example.demo.dao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * saas进货单
 * </p>
 *
 * @author wangjun
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "shopping_cart_id", type = IdType.AUTO)
    private Integer shoppingCartId;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 企业ID
     */
    private Integer enterpriseId;

    /**
     * 商品规格
     */
    private String spec;

    /**
     * 供应商ID
     */
    private Integer sellerCode;

    /**
     * SPU编码
     */
    private String spuCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 生产厂家
     */
    private String factoryName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 实际结算价，正常情况下与销售单价一致
     */
    private BigDecimal settlementPrice;

    /**
     * 购买单品数量
     */
    private Integer productCount;

    /**
     * 勾选状态1,0否
     */
    private Integer checkStatus;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 记录生成时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;


}
