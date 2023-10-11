package com.zbhar.postgre_vend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ADDRESS_PG")
public class address {
    @Id
    @Column(nullable = false, name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String code;
    @Column(nullable = false, name = "COMPANY_ADDRESS")
    private String companyAddress;
    @Column(nullable = false, name = "STREET_NAME")
    private String streetName;
    @Column(nullable = false, name = "CITY_NAME")
    private String cityName;
    @Column(nullable = false, name = "STATE")
    private String state;
    @Column(nullable = false, name = "COUNTRY")
    private String country;
    @Column(nullable = false, name = "MOBILE_NUMBER")
    private Integer mobileNumb;

    public address() {

    }

    public address(String code, String companyAddress, String streetName, String cityName, String state, String country,
            Integer mobileNumb) {
        this.code = code;
        this.companyAddress = companyAddress;
        this.streetName = streetName;
        this.cityName = cityName;
        this.state = state;
        this.country = country;
        this.mobileNumb = mobileNumb;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getMobileNumb() {
        return mobileNumb;
    }

    public void setMobileNumb(Integer mobileNumb) {
        this.mobileNumb = mobileNumb;
    }

}
