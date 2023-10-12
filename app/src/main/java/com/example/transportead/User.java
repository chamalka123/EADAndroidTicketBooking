package com.example.transportead;

public class User {

    private String name;
    private String email;
    private String mobileNum;
    private String password;
    private String nic;

    private String isActive;

    public User() {
    }

    public User(String name, String email, String mobileNum, String password, String nic, String isActive) {
        this.name = name;
        this.email = email;
        this.mobileNum = mobileNum;
        this.password = password;
        this.nic = nic;
        this.isActive = isActive;
    }


    //getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getPassword() {
        return password;
    }

    public String getNic() {
        return nic;
    }

    public  String getIsActive ()  {return  isActive;}


    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setIsActive(String isActive) {this.isActive = isActive; }

}