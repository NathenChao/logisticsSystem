package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dc
 */
public class LogisticsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String no;
    //
    private String goodNumber;
    //
    private String goodName;
    //
    private String sendName;
    //
    private String sendAddress;
    //
    private String sendTelephone;
    //
    private String sendProvince;
    //
    private String sendCity;
    //
    private Date sendDate;
    //
    private String consigneeName;
    //
    private String consigneeAddress;
    //
    private String consigneeTelephone;
    //
    private String arriveProvince;
    //
    private String arriveCity;
    //
    private Date arriveDate;
    private String orderSn;

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
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取：
     */
    public String getNo() {
        return no;
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

    /**
     * 设置：
     */
    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /**
     * 获取：
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * 设置：
     */
    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    /**
     * 获取：
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * 设置：
     */
    public void setSendTelephone(String sendTelephone) {
        this.sendTelephone = sendTelephone;
    }

    /**
     * 获取：
     */
    public String getSendTelephone() {
        return sendTelephone;
    }

    /**
     * 设置：
     */
    public void setSendProvince(String sendProvince) {
        this.sendProvince = sendProvince;
    }

    /**
     * 获取：
     */
    public String getSendProvince() {
        return sendProvince;
    }

    /**
     * 设置：
     */
    public void setSendCity(String sendCity) {
        this.sendCity = sendCity;
    }

    /**
     * 获取：
     */
    public String getSendCity() {
        return sendCity;
    }

    /**
     * 设置：
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 获取：
     */
    public Date getSendDate() {
        return sendDate;
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
    public void setArriveProvince(String arriveProvince) {
        this.arriveProvince = arriveProvince;
    }

    /**
     * 获取：
     */
    public String getArriveProvince() {
        return arriveProvince;
    }

    /**
     * 设置：
     */
    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    /**
     * 获取：
     */
    public String getArriveCity() {
        return arriveCity;
    }

    /**
     * 设置：
     */
    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    /**
     * 获取：
     */
    public Date getArriveDate() {
        return arriveDate;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }


}
