package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dc
 */
public class LogisticsManageDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String logisticsNo;
    //
    private String drivierName;
    //
    private String carNo;
    //
    private Date createDate;
    //
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
    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    /**
     * 获取：
     */
    public String getLogisticsNo() {
        return logisticsNo;
    }

    /**
     * 设置：
     */
    public void setDrivierName(String drivierName) {
        this.drivierName = drivierName;
    }

    /**
     * 获取：
     */
    public String getDrivierName() {
        return drivierName;
    }

    /**
     * 设置：
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    /**
     * 获取：
     */
    public String getCarNo() {
        return carNo;
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
}
