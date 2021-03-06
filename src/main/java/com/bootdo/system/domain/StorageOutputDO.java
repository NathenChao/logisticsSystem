package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dc
 */
public class StorageOutputDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String goodName;
    //
    private String goodNumber;
    //
    private Double goodPrice;
    //
    private Integer goodCount;
    //
    private Date createDate;

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
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * 获取：
     */
    public Double getGoodPrice() {
        return goodPrice;
    }

    /**
     * 设置：
     */
    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    /**
     * 获取：
     */
    public Integer getGoodCount() {
        return goodCount;
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
}
