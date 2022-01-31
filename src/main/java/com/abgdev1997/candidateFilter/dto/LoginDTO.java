package com.abgdev1997.candidateFilter.dto;

public class LoginDTO {

    String enterpriseEmail;
    String password;

    public LoginDTO() {
    }

    public LoginDTO(String enterpriseEmail, String password) {
        this.enterpriseEmail = enterpriseEmail;
        this.password = password;
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
