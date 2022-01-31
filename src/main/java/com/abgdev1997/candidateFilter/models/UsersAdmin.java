package com.abgdev1997.candidateFilter.models;

public class UsersAdmin {

    Long id;
    String userName;
    String name;
    String enterpriseEmail;
    String password;

    public UsersAdmin() {
    }

    public UsersAdmin(String enterpriseEmail, String password) {
        this.enterpriseEmail = enterpriseEmail;
        this.password = password;
    }

    public UsersAdmin(Long id, String userName, String name, String enterpriseEmail, String password) {
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
