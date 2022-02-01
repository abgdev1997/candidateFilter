package com.abgdev1997.candidateFilter.dto;

public class RegisterDTO {

    String userName;
    String name;
    String enterpriseEmail;
    String password;

    public RegisterDTO() {
    }

    public RegisterDTO(String userName, String name, String enterpriseEmail, String password) {
        this.userName = userName;
        this.name = name;
        this.enterpriseEmail = enterpriseEmail;
        this.password = password;
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
