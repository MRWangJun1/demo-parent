package com.example.demo.dao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author wangjun
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String flowId;

    /**
     * 登录用户id
     */
    private Integer userId;

    /**
     * 采购商名称
     */
    private String custName;

    /**
     * 采购商ID-买家
     */
    private Integer custId;

    /**
     * 买家erp编码
     */
    private String erpCode;

    /**
     * 采购员名称
     */
    private String purchaseName;

    /**
     * 采购员手机号
     */
    private String purchasePhone;

    /**
     * 供应商ID
     */
    private Integer supplyId;

    /**
     * 取消原因类型
     */
    private Integer cancelReasonType;

    /**
     * 其他取消原因
     */
    private String otherCancelReason;

    /**
     * 订单总金额
     */
    private BigDecimal settlementMoney;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 支付状态  1支付  0未支付
     */
    private String payStatus;

    /**
     * 支付审核状态 0-待审核 1-审核通过 2-审核不通过
     */
    private Integer payAuditStatus;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行账号
     */
    private String bankCode;

    /**
     * 开户名
     */
    private String accountName;

    /**
     * 支付类型表ID
     */
    private Integer payTypeId;

    /**
     * 订单生成时间
     */
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliverTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 订单最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 收货人
     */
    private String receivePerson;

    /**
     * 收货人联系电话
     */
    private String receiveContactPhone;

    /**
     * 收货详细地址
     */
    private String receiveAddress;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String districtName;

    /**
     * 审核备注（审核凭证时传入）
     */
    private String sellerRemark;

    /**
     * 线下转账凭证（多个url用,分隔）
     */
    private String certificateUrl;


}
