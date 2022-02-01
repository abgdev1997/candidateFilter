package com.abgdev1997.candidateFilter.models;

import javax.persistence.*;

@Entity
@Table(name = "app_users_admin")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;
    private String enterpriseEmail;
    private String password;

    public User() {
    }



    public User(String enterpriseEmail, String password) {
        this.enterpriseEmail = enterpriseEmail;
        this.password = password;
    }

    public User(Long id, String userName, String name, String enterpriseEmail, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.enterpriseEmail = enterpriseEmail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
