package com.abgdev1997.candidateFilter.dto;

import java.util.ArrayList;

public class FilterDTO {

    ArrayList<String> technologies = new ArrayList<>();
    String country;
    String city;
    String presence;
    Boolean relocation;

    public FilterDTO() {
    }

    public FilterDTO(ArrayList<String> technologies, String country, String city, String presence, Boolean relocation) {
        this.technologies = technologies;
        this.country = country;
        this.city = city;
        this.presence = presence;
        this.relocation = relocation;
    }

    public ArrayList<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(ArrayList<String> technologies) {
        this.technologies = technologies;
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
}
