package com.kh.Olumgollum_Project.RoomInfo;



import com.kh.Olumgollum_Project.COMMON.Common;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;
public class RoomInfoDao {
    Connection conn = null;
    Statement stmt = null; // create Statement 방식
    PreparedStatement psmt = null; // Prepared Statement 방식
    ResultSet rs = null; // database 부터 결과를 받는 변수
    Scanner sc = new Scanner(System.in);

    public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36;m" ;
    public static final String white     = "\u001B[37m" ;
    public static final String exit     = "\u001B[0m" ;

    public RoomInfoVo RoomInputFunc() throws ParseException {
        //초기값 설정
        RoomInfoVo rvo = new RoomInfoVo(11, "can3487@naver.com", null, null, 0, 0, 0, 0, null, null, null, null, 0, null, null);
        //날짜 입력받기 위한 SimpleDateFormat 생성.
        // RoomOlum_Page 화면
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(blue+"|"+exit+"                 "+red+"/$$$$$$  /$$       /$$   /$$ /$$      /$$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"                "+red+"/$$__  $$| $$      | $$  | $$| $$$    /$$$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"               "+red+"| $$  \\ $$| $$      | $$  | $$| $$$$  /$$$$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"               "+red+"| $$  | $$| $$      | $$  | $$| $$ $$/$$ $$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"               "+red+"| $$  | $$| $$      | $$  | $$| $$  $$$| $$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"               "+red+"| $$  | $$| $$      | $$  | $$| $$\\  $ | $$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"               "+red+"|  $$$$$$/| $$$$$$$$|  $$$$$$/| $$ \\/  | $$"+exit+"             "+blue+"|"+exit+"\n" +
                blue+"|"+exit+"                "+red+"\\______/ |________/ \\______/ |__/     |__/"+exit+"             "+blue+"|"+exit);
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(blue+"|"+exit+"                             RoomOlum_Page                             "+blue+"|"+exit);
        System.out.println(blue+"/-------------------\\                                                   |"+exit);
        System.out.println(blue+"|                   |                                                   |"+exit);
        System.out.println(blue+"|                   |                                                   |"+exit);
        System.out.println(blue+"|"+exit+"       사  진       |                                                   "+blue+"|"+exit);
        System.out.println(blue+"|                   |                                                   |"+exit);
        System.out.println(blue+"|                   |                                                   |"+exit);
        System.out.println(blue+"\\-------------------/                                                   |"+exit);
        System.out.print(blue+"|"+exit+" url: ");
        rvo.setPhoto_url(sc.nextLine());
        System.out.println(blue+"|                                                                       |"+exit);
        while (true) {
            System.out.print(blue+"|"+exit+" 거래 방식(매매,전세,월세): ");
            rvo.setTrade_method(sc.nextLine());
            System.out.println(blue+"|                                                                       |"+exit);
            switch (rvo.getTrade_method()) {
                case "매매":
                    System.out.print(blue+"|"+exit+" 매매가(만원): ");
                    rvo.setSale_price(sc.nextInt());
                    sc.nextLine();
                    System.out.println(blue+"|                                                                       |"+exit);
                    break;
                case "전세":
                    System.out.print(blue+"|"+exit+" 전세금(만원): ");
                    rvo.setJeonsegeum(sc.nextInt());
                    sc.nextLine();
                    System.out.println(blue+"|                                                                       |"+exit);
                    break;
                case "월세":
                    System.out.print(blue+"|"+exit+" 보증금(만원): ");
                    rvo.setDeposit(sc.nextInt());
                    sc.nextLine();
                    System.out.println(blue+"|                                                                       |"+exit);
                    System.out.print(blue+"|"+exit+" 월세(만원): ");
                    rvo.setMonthly(sc.nextInt());
                    sc.nextLine();
                    System.out.println(blue+"|                                                                       |"+exit);
                    break;
                default:
                    System.out.print("다시 입력해주세요.");
                    continue;
            }
            break;
        }
        System.out.print(blue+"|"+exit+" 평수: ");
        rvo.setArea(sc.nextLine());
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 사용 승인일(YYYY-MM-DD): ");
        rvo.setAccept_date(java.sql.Date.valueOf(sc.nextLine()));
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 주소: ");
        rvo.setAddress(sc.nextLine());
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 층수: ");
        rvo.setFloor1(sc.nextLine());
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 집주인 전화번호(-빼고): ");
        rvo.setPhonenumber(sc.nextInt());
        sc.nextLine();
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 등록일(YYYY-MM-DD): ");
        rvo.setRegit_date(java.sql.Date.valueOf(sc.nextLine()));
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.print(blue+"|"+exit+" 비고(옵션): ");
        rvo.setRemark(sc.nextLine());
        System.out.println(blue+"|                                                                       |"+exit);
        System.out.println(blue + "========================================================================" + exit);

        return rvo;
    }

    public void RoomInputPrF(RoomInfoVo rvo) {
        System.out.println(blue + "========================================================================" + exit);
        System.out.print(rvo.getHouse_num() + " ");
        System.out.print(rvo.getUser_id()+ " ");
        System.out.print(rvo.getPhoto_url() + " ");
        System.out.print(rvo.getTrade_method() + " ");
        System.out.print(rvo.getDeposit() + " ");
        System.out.print(rvo.getMonthly() + " ");
        System.out.print(rvo.getJeonsegeum() + " ");
        System.out.print(rvo.getSale_price()+ " ");
        System.out.print(rvo.getArea() + " ");
        System.out.print(rvo.getAccept_date() + " ");
        System.out.print(rvo.getAddress() + " ");
        System.out.print(rvo.getFloor1() + " ");
        System.out.print(rvo.getPhonenumber() + " ");
        System.out.print(rvo.getRegit_date() + " ");
        System.out.println(rvo.getRemark() + " ");
        System.out.println(blue + "========================================================================" + exit);
    }
    public void RoomInsert(RoomInfoVo rvo) {
        String query = "INSERT INTO RoomInfo VALUES(SEQ_ROOM.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = Common.getConnection();
            psmt = conn.prepareStatement(query);
            psmt.setString(1, rvo.getUser_id());
            psmt.setString(2, rvo.getPhoto_url());
            psmt.setString(3, rvo.getTrade_method());
            psmt.setInt(4, rvo.getDeposit());
            psmt.setInt(5, rvo.getMonthly());
            psmt.setInt(6, rvo.getJeonsegeum());
            psmt.setInt(7, rvo.getSale_price());
            psmt.setString(8, rvo.getArea());
            psmt.setDate(9, rvo.getAccept_date());
            psmt.setString(10, rvo.getAddress());
            psmt.setString(11, rvo.getFloor1());
            psmt.setInt(12, rvo.getPhonenumber());
            psmt.setDate(13, rvo.getRegit_date());
            psmt.setString(14, rvo.getRemark());
            psmt.executeUpdate();
            System.out.println(purple+"                          DB에 저장되었습니다!"+exit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(psmt);
        Common.close(conn);
    }
}
