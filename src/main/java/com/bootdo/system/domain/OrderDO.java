package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dc
 */
public class OrderDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String orderSn;
    //
    private String customerName;
    //
    private Double totalPrice;
    //
    private Integer totalCount;
    //
    private Date payDate;
    //
    private String consigneeName;
    //
    private String consigneeAddress;
    //
    private String consigneeTelephone;
    //
    private Long userId;
    //
    private Date createDate;
    //
    private Integer status;
    //
    private String description;
    //
    private String goodNumber;
    //
    private String goodName;

    private String customerNumber;

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
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取：
     */
    public String getCustomerName() {
        return customerName;
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
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取：
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置：
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取：
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置：
     */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    /**
     * 获取：
     */
    public String getConsigneeName() {
        return consigneeName;
    }

    /**
     * 设置：
     */
    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    /**
     * 获取：
     */
    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    /**
     * 设置：
     */
    public void setConsigneeTelephone(String consigneeTelephone) {
        this.consigneeTelephone = consigneeTelephone;
    }

    /**
     * 获取：
     */
    public String getConsigneeTelephone() {
        return consigneeTelephone;
    }

    /**
     * 设置：
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     */
    public Long getUserId() {
        return userId;
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
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置：
     */
    public void setGoodNumber(String goodNumber) {
        this.goodNumber = goodNumber;
    }

    /**
     * 获取：
     */
    public String getGoodNumber() {
        return goodNumber;
    }

    /**
     * 设置：
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    /**
     * 获取：
     */
    public String getGoodName() {
        return goodName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }


}
