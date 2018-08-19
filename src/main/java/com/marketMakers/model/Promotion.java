package com.marketMakers.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Double value;
    private Integer dots;
    private String title;
    private String description;
    private Long coupons;
    private Timestamp expiration;
    @ManyToOne
    private Company company;

    public Promotion() {
    }

    public Promotion(String description, Double value, String type, Company company, Long coupons, String title, Timestamp exDate, Integer dots) {
        this.description = description;
        this.value = value;
        this.type = type;
        this.company = company;
        this.coupons = coupons;
        this.title = title;
        this.expiration = exDate;
        this.dots = dots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCoupons() {
        return coupons;
    }

    public void setCoupons(Long coupons) {
        this.coupons = coupons;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getDots() {
        return dots;
    }

    public void setDots(Integer dots) {
        this.dots = dots;
    }
}