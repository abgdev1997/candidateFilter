package com.abgdev1997.candidateFilter.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "app_applicants")
public class Applicants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String city;
    private String phone;
    private String email;
    private String presence;
    private Boolean relocation;
    private String image;
    private String imageId;
    private String pdf;
    private String pdfId;
    private ArrayList<String> technologies = new ArrayList<>();

    public Applicants() {
    }

    public Applicants(Long id, String name, String country, String city, String phone, String email, String presence, Boolean relocation, String image, String imageId, String pdf, String pdfId, ArrayList<String> technologies) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.presence = presence;
        this.relocation = relocation;
        this.image = image;
        this.imageId = imageId;
        this.pdf = pdf;
        this.pdfId = pdfId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public ArrayList<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(ArrayList<String> technologies) {
        this.technologies = technologies;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPdfId() {
        return pdfId;
    }

    public void setPdfId(String pdfId) {
        this.pdfId = pdfId;
    }
}
