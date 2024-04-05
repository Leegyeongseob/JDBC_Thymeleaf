package com.kh.Olumgollum_Project.RoomSearch;


import com.kh.Olumgollum_Project.COMMON.Common;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ROOMINFO 테이블 검색 후 리스트 리턴 함수
public class RoomSearchDao {
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m";
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";
    Connection conn = null;
    Statement stmt = null; // create Statement 방식
    PreparedStatement pStmt = null; // Prepared Statement 방식
    ResultSet rs = null; // database로 부터 결과를 받는 변수
    Scanner sc = new Scanner(System.in);

    // ROOMINFO 테이블 검색 후 리스트 리턴 함수
    public List<RoomInfoVo> roomSelect() {
        List<RoomInfoVo> list = new ArrayList<>();
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(purple+"                         모든 검색을 시작합니다."+exit);
        System.out.println(blue + "========================================================================" + exit);
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM ROOMINFO";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int house_num = rs.getInt("HOUSE_NUM");
                String user_id = rs.getString("USER_ID");
                String photo_url = rs.getString("PHOTO_URL");
                String trade_method = rs.getString("TRADE_METHOD");
                int deposit = rs.getInt("DEPOSIT");
                int monthly = rs.getInt("MONTHLY");
                int jeonsegeum = rs.getInt("JEONSEGEUM");
                int Sale_price = rs.getInt("SALE_PRICE");
                String area = rs.getString("AREA");
                String address = rs.getString("ADDRESS");
                String floor1 = rs.getString("FLOOR1");
                int phonenumber = rs.getInt("PHONENUMBER");
                String remark = rs.getString("REMARK");


                list.add(new RoomInfoVo(house_num, user_id, photo_url, trade_method, deposit, monthly, jeonsegeum,
                        Sale_price, area, rs.getDate("ACCEPT_DATE"), address, floor1, phonenumber, rs.getDate("REGIT_DATE"), remark));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 지역별 검색 함수
    public List<RoomInfoVo> adressSearchSelect() {
        List<RoomInfoVo> list = new ArrayList<>();
        System.out.print(green+"    조회 할 지역을 입력하세요 : "+exit);
        String add = sc.next();
        String sql = "SELECT * FROM ROOMINFO WHERE address like ?";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, "%" + add + "%");
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                int house_num = rs.getInt("HOUSE_NUM");
                String user_id = rs.getString("USER_ID");
                String photo_url = rs.getString("PHOTO_URL");
                String trade_method = rs.getString("TRADE_METHOD");
                int deposit = rs.getInt("DEPOSIT");
                int monthly = rs.getInt("MONTHLY");
                int jeonsegeum = rs.getInt("JEONSEGEUM");
                int Sale_price = rs.getInt("SALE_PRICE");
                String area = rs.getString("AREA");
                String address = rs.getString("ADDRESS");
                String floor1 = rs.getString("FLOOR1");
                int phonenumber = rs.getInt("PHONENUMBER");
                String remark = rs.getString("REMARK");


                list.add(new RoomInfoVo(house_num, user_id, photo_url, trade_method, deposit, monthly, jeonsegeum,
                        Sale_price, area, rs.getDate("ACCEPT_DATE"), address, floor1, phonenumber, rs.getDate("REGIT_DATE"), remark));
            }
            Common.close(pStmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //거래방식 검색함수
    public List<RoomInfoVo> tradeSelect(List<RoomInfoVo> list) {
        List<RoomInfoVo> tradeList = new ArrayList<>();
        try {
            while (true) {
                System.out.print(green+"    거래방식을 입력하세요 : "+exit);
                String trade = sc.next();
                for (RoomInfoVo e : list) {
                    if (e.getTrade_method().equals(trade)) {
                        tradeList.add(e);
                    }
                }
                if (tradeList.size() == 0) {
                    System.out.println(green+"    다시 입력해주세요."+exit);
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tradeList;
    }

    //평수 검색 함수
    public List<RoomInfoVo> areaTradeSelect(List<RoomInfoVo> tradeList) {
        List<RoomInfoVo> areaTradeList = new ArrayList<>();
        try {
            while (true) {
                System.out.print(green+"    평수를 입력하세요 : "+exit);
                int area = sc.nextInt();
                for (RoomInfoVo e : tradeList) {
                    if (Integer.parseInt(e.getArea()) >= area) {
                        areaTradeList.add(e);
                    }
                }
                if (areaTradeList.size() <= 0) {
                    System.out.println(green+"    다시 입력해주세요."+exit);
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return areaTradeList;
    }


    //층 수 검색 함수
    public List<RoomInfoVo> floorTradeSelect(List<RoomInfoVo> tradeList) {
        List<RoomInfoVo> floorTradeList = new ArrayList<>();
        try {
            while (true) {
                System.out.print(green+"    층을 입력하세요 : "+exit);
                String flo = sc.next();
                for (RoomInfoVo e : tradeList) {
                    int index = flo.indexOf("층");
                    if (index != -1) {
                        String extract = flo.substring(0, index);
                        int index2 = e.getFloor1().indexOf("층");
                        if (index2 != -1) {
                            String extract2 = e.getFloor1().substring(0, index2);
                            if (flo.equals("루프탑") || flo.equals("반지층") || Integer.parseInt(extract) <= Integer.parseInt(extract2)) {
                                floorTradeList.add(e);
                            }
                        }
                    }
                }
                if (floorTradeList.size() <= 0) {
                    System.out.println(green+"    다시 입력해주세요."+exit);
                    continue;
                }
                break;
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return floorTradeList;
    }

    // 리스트 출력 함수
    public void roomSelectPrn(List<RoomInfoVo> list) {
        for (RoomInfoVo e : list) {
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "        사진 URL : " + exit + e.getPhoto_url() + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(blue + "|       매물번호     : " + e.getHouse_num());
            System.out.println(blue + "|       거래방식     : " + e.getTrade_method());
            System.out.println(blue + "|       보증금      : " + e.getDeposit());
            System.out.println(blue + "|       월세        : " + e.getMonthly());
            System.out.println(blue + "|       전세금      : " + e.getJeonsegeum());
            System.out.println(blue + "|       매매가      : " + e.getSale_price());
            System.out.println(blue + "|       평수        : " + e.getArea());
            System.out.println(blue + "|       사용승인날짜 : " + e.getAccept_date());
            System.out.println(blue + "|       주소        : " + e.getAddress());
            System.out.println(blue + "|       층          : " + e.getFloor1());
            System.out.println(blue + "|       전화번호     : " + e.getPhonenumber());
            System.out.println(blue + "|       등록날짜     : " + e.getRegit_date());
            System.out.println(blue + "|       비고        : " + e.getRemark());
            System.out.println(blue + "========================================================================" + exit);

        }
    }
}
