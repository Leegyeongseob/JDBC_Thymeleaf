package com.kh.Olumgollum_Project.LoginInfo;

public class LoginInfoVo {
    private String user_mail; // 유저 이메일
    private String password; //비밀번호
    private String name; // 이름
    private int first_id_cardnum; //생년월일
    private int phone_number; //
    private String address; // float 급여 정보이고 소수점 이하가 존재
    private int gender; // 성과급
    private String nickname;

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFirst_id_cardnum() {
        return first_id_cardnum;
    }

    public void setFirst_id_cardnum(int first_id_cardnum) {
        this.first_id_cardnum = first_id_cardnum;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LoginInfoVo(String user_mail, String password, String name, int first_id_cardnum, int phone_number, String address, int gender, String nickname) {
        this.user_mail = user_mail;
        this.password = password;
        this.name = name;
        this.first_id_cardnum = first_id_cardnum;
        this.phone_number = phone_number;
        this.address = address;
        this.gender = gender;
        this.nickname = nickname;

    }
}
