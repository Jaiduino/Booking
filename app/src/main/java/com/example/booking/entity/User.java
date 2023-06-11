package com.example.booking.entity;

public class User {
    private String Name;
    private String Mobile;
    private String email;


    public User() {
    }

    public User(String name, String mobile, String emailId) {
        Name = name;
        Mobile = mobile;
        email = emailId;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmailId() {
        return email;
    }

    public void setEmailId(String emailId) {
        email = emailId;
    }




    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", EmailId='" + email + '\'' +

                '}';
    }
}
