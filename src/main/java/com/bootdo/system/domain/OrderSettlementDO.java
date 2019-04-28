package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dc
 */
public class OrderSettlementDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String orderSn;
    //
    private Double totalPrice;
    //
    private Date createDate;
    //
    private Integer state;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置：
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取：
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置：
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取：
     */
    public Integer getState() {
        return state;
    }
}
