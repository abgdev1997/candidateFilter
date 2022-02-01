package com.abgdev1997.candidateFilter.dto;

import java.util.ArrayList;

public class ApplicantDTO {

    private Long id;
    private String name;
    private String country;
    private String city;
    private String phone;
    private String email;
    private String presence;
    private Boolean relocation;
    private ArrayList<String> technologies;

    public ApplicantDTO() {
    }

    public ApplicantDTO(Long id, String name, String country, String city, String phone, String email, String presence, Boolean relocation, ArrayList<String> technologies) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.presence = presence;
        this.relocation = relocation;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Boolean getRelocation() {
        return relocation;
    }

    public void setRelocation(Boolean relocation) {
        this.relocation = relocation;
    }

    public ArrayList<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(ArrayList<String> technologies) {
        this.technologies = technologies;
    }
}
