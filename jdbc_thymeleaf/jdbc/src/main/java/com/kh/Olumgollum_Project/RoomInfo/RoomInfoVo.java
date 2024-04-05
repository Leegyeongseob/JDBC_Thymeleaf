package com.kh.Olumgollum_Project.RoomInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoomInfoVo {
    private int house_num;
    private String user_id;
    private String photo_url;
    private String trade_method;
    private int deposit;
    private int monthly;
    private int jeonsegeum;
    private int Sale_price;
    private String area;
    private Date accept_date;
    private String address;
    private String floor1;
    private int phonenumber;
    private Date regit_date;
    private String remark;
}
