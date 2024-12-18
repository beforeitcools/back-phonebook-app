package com.ohgiraffers.phonebookbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class PhoneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "status")
    private int status;

    public PhoneBook() {
    }

    public PhoneBook(int id, String name, String phone, String profileImg, int status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.profileImg = profileImg;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", status=" + status +
                '}';
    }
}
