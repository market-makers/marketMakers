package com.marketMakers.model;

import javax.persistence.*;

@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private Boolean partner;
    private String name;
    private String companyName;
    private String cnpj;
    private String email;
    private String type;
    private String categories;
    @OneToOne
    private Address address;

    public Company() {
    }

    public Company(String password, Boolean partner, String name, String companyName, String cnpj, String email, String type, String categories, Address address) {
        this.password = password;
        this.partner = partner;
        this.name = name;
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.email = email;
        this.type = type;
        this.categories = categories;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPartner() {
        return partner;
    }

    public void setPartner(Boolean partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}