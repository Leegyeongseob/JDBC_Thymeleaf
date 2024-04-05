package com.kh.Olumgollum_Project.LoveRoom;

public class LoveRoomVo{
    private String user_id ;
    private int Shouse_num ;

    public LoveRoomVo(String user_id, int shouse_num) {
        this.user_id = user_id;
        this.Shouse_num = shouse_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getShouse_num() {
        return Shouse_num;
    }

    public void setShouse_num(int shouse_num) {
        this.Shouse_num = shouse_num;
    }
}

