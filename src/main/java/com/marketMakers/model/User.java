package com.marketMakers.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;
    @Column(unique = true)
    private String userApp;
    private String name;
    private String email;
    private Integer dots;

    public User() {
    }

    public User(String userApp, String name, String email, Integer dots) {
        this.userApp = userApp;
        this.name = name;
        this.email = email;
        this.dots = dots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserApp() {
        return userApp;
    }

    public void setUserApp(String userApp) {
        this.userApp = userApp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDots() {
        return dots;
    }

    public void setDots(Integer dots) {
        this.dots = dots;
    }
}