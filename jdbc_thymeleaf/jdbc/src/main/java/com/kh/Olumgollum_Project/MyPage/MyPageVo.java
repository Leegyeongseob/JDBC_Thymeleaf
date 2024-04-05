package com.kh.Olumgollum_Project.MyPage;

public class MyPageVo{
    private String USER_MAIL;
    private boolean LOVE_ROOM;
    private String profile_photo;

    public MyPageVo(String USER_MAIL, boolean LOVE_ROOM, String profile_photo) {
        this.USER_MAIL = USER_MAIL;
        this.LOVE_ROOM = LOVE_ROOM;
        this.profile_photo = profile_photo;
    }

    public String getUSER_MAIL() {
        return USER_MAIL;
    }

    public boolean isLOVE_ROOM() {
        return LOVE_ROOM;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setUSER_MAIL(String USER_MAIL) {
        this.USER_MAIL = USER_MAIL;
    }

    public void setLOVE_ROOM(boolean LOVE_ROOM) {
        this.LOVE_ROOM = LOVE_ROOM;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
