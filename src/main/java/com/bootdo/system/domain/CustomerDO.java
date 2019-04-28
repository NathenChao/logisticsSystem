package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dc
 */
public class CustomerDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String name;
    //
    private String number;
    //
    private String telephone;
    //
    private String email;
    //
    private String address;
    //
    private String company;

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
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取：
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置：
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取：
     */
    public String getCompany() {
        return company;
    }
}
