package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dc
 */
public class GoodDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String title;
    //
    private String type;
    //
    private String number;
    //
    private Double price;
    //
    private Double weight;
    //
    private String place;
    //
    private String img;
    //
    private String imgmore;
    //
    private Long createBy;
    //
    private Date createDate;
    //
    private String remark;
    //
    private Integer delFlag;

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
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取：
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置：
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取：
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置：
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取：
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置：
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获取：
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置：
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取：
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置：
     */
    public void setImgmore(String imgmore) {
        this.imgmore = imgmore;
    }

    /**
     * 获取：
     */
    public String getImgmore() {
        return imgmore;
    }

    /**
     * 设置：
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取：
     */
    public Long getCreateBy() {
        return createBy;
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
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取：
     */
    public Integer getDelFlag() {
        return delFlag;
    }
}
