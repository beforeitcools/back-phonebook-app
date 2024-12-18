package com.ohgiraffers.phonebookbackend.dto;

public class PhoneBookDTO {

    private String name;
    private String phoneNumber;
    private String profileImg;
    private int status;

    public PhoneBookDTO() {
    }

    public PhoneBookDTO(String name, String phoneNumber, String profileImg, int status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.profileImg = profileImg;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "PhoneBookDTO{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", status=" + status +
                '}';
    }
}
