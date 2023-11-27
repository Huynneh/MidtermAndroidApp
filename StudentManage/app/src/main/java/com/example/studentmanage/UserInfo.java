package com.example.studentmanage;


public class UserInfo {
    private String position, name, age, phone, status, userName, passWord;

    public UserInfo(String position, String name, String age, String phone, String status, String userName, String passWord) {
        this.position = position;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.status = status;
        this.userName = name + "@gmail.com";
        this.passWord = "pass" + phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
