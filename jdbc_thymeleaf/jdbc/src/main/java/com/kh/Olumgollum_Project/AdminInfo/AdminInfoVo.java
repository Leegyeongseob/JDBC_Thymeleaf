package com.kh.Olumgollum_Project.AdminInfo;

public class AdminInfoVo {
    private String ADM_ID;
    private String ADM_PW;

    public AdminInfoVo(String ADM_ID, String ADM_PW) {
        this.ADM_ID = ADM_ID;
        this.ADM_PW = ADM_PW;
    }

    public String getADM_ID() {
        return ADM_ID;
    }

    public void setADM_ID(String ADM_ID) {
        this.ADM_ID = ADM_ID;
    }

    public String getADM_PW() {
        return ADM_PW;
    }

    public void setADM_PW(String ADM_PW) {
        this.ADM_PW = ADM_PW;
    }
}
