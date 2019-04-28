package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dc
 */
public class CarDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String type;
    //
    private String name;
    //
    private String no;
    //
    private String driverName;
    //
    private String driverTelephone;
    //
    private Integer driverAge;
    //
    private Integer carAge;
    //
    private Double weight;

    private Integer status;

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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
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
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * 获取：
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置：
     */
    public void setDriverTelephone(String driverTelephone) {
        this.driverTelephone = driverTelephone;
    }

    /**
     * 获取：
     */
    public String getDriverTelephone() {
        return driverTelephone;
    }

    /**
     * 设置：
     */
    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    /**
     * 获取：
     */
    public Integer getDriverAge() {
        return driverAge;
    }

    /**
     * 设置：
     */
    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    /**
     * 获取：
     */
    public Integer getCarAge() {
        return carAge;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
