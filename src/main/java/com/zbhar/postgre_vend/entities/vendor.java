package com.zbhar.postgre_vend.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "VENDOR_PG")
public class vendor {
    @Id
    @Column(nullable = false, name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String code;
    @Column(nullable = false, name = "COMPANY_NAME")
    private String companyName;
    @Column(nullable = false, name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, name = "WEBSITE")
    private String website;
    @Column(nullable = false, name = "EMAIL")
    private String email;
    @Column(nullable = false, name = "STATUS")
    private String status;
    @Column(nullable = true, name = "REG_DATE")
    private Date regDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor", referencedColumnName = "ID")
    private List<address> addresses = new ArrayList<>();

    public vendor() {

    }

    // public vendor(String code, String companyName, String contactPerson, String firstName, String lastName) {

    //     this.code = "101";
    //     this.companyName = "Company 1";
    //     this.contactPerson = "contact Person 1";
    //     this.firstName = "firstName 1";
    //     this.lastName = "lastName 1";
    //     this.status = "0";
    //     this.website = companyName + ".com";
    //     this.email = this.firstName + this.lastName + "@" + this.companyName +
    //             ".com";
    //     this.regDate = new Date();
    // }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<address> addresses) {
        this.addresses = addresses;
    }
}
