package com.kh.Olumgollum_Project.AdminInfo;

import com.kh.Olumgollum_Project.COMMON.Common;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AdminInfoDao {
    Connection conn = null;
    Statement stmt = null; // create Statement 방식
    PreparedStatement pStmt = null; // Prepared Statment 방식
    ResultSet rs = null; // database 로 부터 결과를 받는 변수
    Scanner sc = new Scanner(System.in);
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m";
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";

    public List<String> Adminlogin() throws InterruptedException {
        List<String> adm_id_pw = new ArrayList<>();
        String AdId = null;
        String Adpwd = null;
        while (true) {
            System.out.println(blue + "========================================================================" + exit);
            System.out.print(red +
                    "⠀⠀⠀⠀⠀⠀⣀⠄⠒⠉⠉⠉⠉⠉⠉⠑⠂⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀ ⠀⠀⣀⠄⠒⠉⠉⠉⠉⠉⠉⠑⠂⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢠⠞⢁⠀⡀⠀⠀⠀⠀⣀⣠⣀⡀⢠⠺⠧⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⢀⠞⢁⠀⡀⠀⠀⠀⠀⣄⣠⣀⡀⢠⠺⠷⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢠⠃⡸⢚⠛⠇⠀⠀⠀⢰⠁⡀⠈⢣⡜⠀⠀⠀⠀⠈⠁⠐⠢⠤⢄⡀⠀⠀⠀ ⠀⠀⢠⠃⡸⢚⠛⠇⠀⠀⠀⢰⠋⡀⠈⢳⡜⠀⠀⠀⠀⠈⠁⠐⠂⠤⢄⡀⠀⠀\n" +
                    "⠀⠀⢀⠃⠀⣇⢀⣠⣧⣤⣦⣤⣜⣤⣀⡠⢮⠃⠀⠀         ⠀⠀⠈⢱⠀⠀⠀⠇⠀⣇⢀⣠⣧⣤⣦⣤⣼⣦⣀⡠⢮⠂⠀⠀       ⠀⠀⠈⢱\n" +
                    "⠀⠀⠸⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⡔⠀   [1]     ⠀⠀⠀⠆⠀⠀⠸⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⡔⠀    [2]    ⠀⠀⠀⠆\n" +
                    "⠀⠀⡄⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⢠   관리자 로그인 ⠰⠀⠀⠀⡄⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⢢⠁⠀⠀    종료    ⠀⠰⠀\n" +
                    "⠀⠀⡇⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⠟⠁⠈⠉⠓⠒⠦⠤⣀⡀⠀⠀  ⠀⠀⠆⠀⠀⠀⡇⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⠟⠁⠈⠉⠓⠒⠦⠤⣀⡀⠀⠀   ⠀⠀⠆⠀\n" +
                    "⠀⢀⠃⠀⠀⠀⠀⠀⠈⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⣠⠞⠓⠛⠿⣷⡶⢦⡤⠰⠀⠀⠀⢀⠇⠀⠀⠀⠀⠀⠈⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⢠⠖⠓⠛⠿⣷⡴⢦⡤⠰⠀⠀\n" +
                    "⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣦⣤⡄⠀⠀⠘⡄⠀⠈⠀⠀⡠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣦⣤⡄⠀⠀⠘⡄⠀⠉⠀⠀\n"+exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.print(purple + "   번호 입력 :  ");
            int lo = sc.nextInt();
            System.out.println(blue + "========================================================================" + exit);
            if (lo == 1) {
                System.out.println(green+"  참고"+exit+" : 테스트를 위한 예시 아이디 : dyddnr33@naver.com 패스워드 : admin1691");
                System.out.println(blue + "========================================================================" + exit);
                System.out.print("  아이디 입력 : ");
                AdId = sc.next();
                System.out.println(blue + "========================================================================" + exit);
                System.out.print("  비밀번호 입력 : ");
                String password = sc.next();
                System.out.println(blue + "========================================================================" + exit);
                System.out.println(yellow + "                     로그인 중입니다. 잠시만 기다려주세요..." + exit);
                System.out.println(blue + "========================================================================" + exit);
                Thread.sleep(2000);
                String sql = "SELECT ADM_PW FROM ADMIN_INFO WHERE ADM_ID= ? ";
                try {
                    conn = Common.getConnection();
                    pStmt = conn.prepareStatement(sql);
                    pStmt.setString(1, AdId);
                    rs = pStmt.executeQuery(); // rs 객체에 쿼리 결과를 할당

                    if (rs.next()) {
                        Adpwd = rs.getString("ADM_PW");
                        if (Adpwd.equals(password)) {
                            adm_id_pw.add(AdId);
                            adm_id_pw.add(Adpwd);
                            adm_id_pw.add("Admin");
                            System.out.println("\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⡿⠛⠛⠛⢛⣽⣿⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣦⠀⢼⣾⣿⣿⠏⢿⣿⣿⡆⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⢠⣾⣿⣿⡏⠙⢿⣿⡿⠛⠀⠻⠿⠋⠁⠴⡽⣻⡅⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⢰⣿⢿⣿⠏⠇⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣄⣈⣈⣧⣀⠀⠀⠀⠀\n" +
                                    "⠀⠀⢠⣿⡿⠧⠂⢡⣤⣤⣤⣴⣶⡆⠠⢾⣿⢿⠛⢛⣋⣫⠤⠬⠟⠂⠀⠀\n" +
                                    "⠀⠀⢸⣿⡗⣮⣶⠶⡟⠛⣛⣛⣙⡱⠤⠞⠚⠚⠉⠉⠀⠀⠀⠀⠀⠀⠸⡄\n" +
                                    "⢀⡾⢉⣿⣷⠤⠔⠒⠒⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇\n" +
                                    "⣸⠌⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣\n" +
                                    "⣿⠺⢟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾\n" +
                                    "⠸⡑⢠⣵⣀⠀⠀⠀⠀⠀⠀로그인 성공   ⠀⠀⠀⠘⣿\n" +
                                    "⠀⠈⣿⡿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⡰⠚⠉⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⡇⠀⢰⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠈⠛⠋⠀⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⢀⠤⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣤⠀⠐⠂\n" +
                                    "⠀⢀⣏⣀⣠⡇⠀⠀⠀⠀⣀⣀⢠⣤⣤⣴⣶⣾⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀\n");
                            System.out.println(blue + "========================================================================" + exit);
                            return adm_id_pw;
                        } else {
                            System.out.println(red + "    비밀번호가 틀렸습니다." + exit);
                        }
                    } else {
                        System.out.println(red + "    아이디를 잘못 입력했습니다." + exit);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(rs);
                    Common.close(pStmt);
                    Common.close(conn);
                }
            } else {
                System.out.println(red + "                           프로그램을 종료합니다." + exit);
                Thread.sleep(1000);
                System.exit(0);
            }

        }
    }

    public List<AdminInfoVo> admin_infoSelect() {
        List<AdminInfoVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM ADMIN_INFO";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String AdmId = rs.getString("ADM_ID");
                String AdmPw = rs.getString("ADM_PW");
                list.add(new AdminInfoVo(AdmId, AdmPw));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void AdminInsert() {
        System.out.println("아이디 입력");
        String ID = sc.next();
        System.out.println("비밀번호 입력");
        String pwd = sc.next();
        String sql = "INSERT INTO ADMIN_INFO(ADM_ID,ADM_PW) VALUES (?,?)";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, ID);
            pStmt.setString(2, pwd);
            int rst = pStmt.executeUpdate();
            System.out.println("rst : " + rst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
    }

    public void AdminDelete(){
        System.out.println("\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀⠀삭제하고자하는⠀⠀⠀⠘\n" +
                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀   아이디 입력⠀⠀⠀⢀⠇\n" +
                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
        String del=sc.next();
        String sql="DELETE FROM ADMIN_INFO WHERE ADM_ID=?";
        try{
            conn=Common.getConnection();
            pStmt=conn.prepareStatement(sql);
            pStmt.setString(1,del);
            int rst = pStmt.executeUpdate();
            System.out.println("rst : "+ rst);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Common.close(pStmt);
            Common.close(conn);
        }

    }

    public void LogDelete(){
        System.out.println("\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀⠀삭제하고자하는⠀⠀⠀⠘\n" +
                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀   아이디 입력⠀⠀⠀⢀⠇\n" +
                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
        String del=sc.next();
        String sql="DELETE FROM INFO WHERE USER_MAIL=?";
        try{
            conn= Common.getConnection();
            pStmt=conn.prepareStatement(sql);
            pStmt.setString(1,del);
            int rst = pStmt.executeUpdate();
            System.out.println("rst : "+ rst);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Common.close(pStmt);
            Common.close(conn);
        }
    }

    public List<RoomInfoVo> RoomSelect() {
        List<RoomInfoVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM RoomInfo";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int house_num = rs.getInt("HOUSE_NUM");
                String user_id = rs.getString("user_id");
                String photo_url = rs.getString("photo_url");
                String trade_method = rs.getString("trade_method");
                int deposit = rs.getInt("deposit");
                int monthly = rs.getInt("monthly");
                int jeonsegeum = rs.getInt("jeonsegeum");
                int Sale_price = rs.getInt("Sale_price");
                String area = rs.getString("area");
                Date accept_date = rs.getDate("accept_date");
                String address = rs.getString("address");
                String floor1 = rs.getString("floor1");
                int phonenumber = rs.getInt("phonenumber");
                Date regit_date = rs.getDate("regit_date");
                String remark = rs.getString("remark");
                list.add(new RoomInfoVo(house_num, user_id, photo_url, trade_method, deposit, monthly, jeonsegeum, Sale_price, area, accept_date, address, floor1, phonenumber, regit_date, remark));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void RoomUpdate(){
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(blue +
                "|   —̳͟͞͞ \uD83D\uDC97     _____ __ __    _____ _____ _____ _____      \uD83C\uDF38        |\n" +
                "|               |     |  |  |  |  _  |  _  |   __|   __|               |\n" +
                "|         \uD83C\uDF38    | | | |_   _|  |   __|     |  |  |   __|   —̳͟͞͞ \uD83D\uDC97    |\n" +
                "|               |_|_|_| |_|    |__|  |__|__|_____|_____|               |\n" +
                "|         —̳͟͞͞ \uD83D\uDC97                                 —̳͟͞͞ \uD83D\uDC97            |");
        System.out.println(blue + "|======================================================================|" + exit);
        System.out.println(blue + "| \uD83C\uDF26\uFE0F     ------------------              ------------------            |" + exit);
        System.out.println(blue + "|        |" + exit + purple+"[1]   방 사진     "+exit + blue + "|     \uD83C\uDF38     |" + exit + purple+"[2] 거래방식(가격) "+exit + blue + "|            |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "| \uD83C\uDF38     |" + exit + purple+"[3]   전화번호    "+exit + blue + "|   \uD83C\uDF26\uFE0F       |" + exit + purple+"[4]     비고      "+exit + blue + "| \uD83C\uDF38        |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "|        ------------------                                            |" + exit);
        System.out.println(blue + "|        |" + exit + purple+"[5]    나가기     "+exit + blue + "|         |￣￣￣￣￣￣￣|     " + red + "   ☁\uFE0F   ⭐  " + blue + "    |");
        System.out.println(blue + "|        ------------------         |  선택하쇼   |     " + green + "       \uD83C\uDF38\uD83C\uDF38 " + blue + "    |");
        System.out.println(blue + "|                   ☁\uFE0F              |＿＿＿＿＿＿＿|  " + green + "  ☁\uFE0F     \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38    " + blue + "|");
        System.out.println(blue + "|                                   (\\__/) || " + green + "             \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38   " + blue + "|");
        System.out.println(blue + "|                                   (•ㅅ•).||  " + green + "                \uD83C\uDF38      " + blue + "|");
        System.out.println(blue + "|       ☁\uFE0F          \uD83C\uDF26\uFE0F              / . . . .づ  " + green + "                      " + blue + "|");
        System.out.println(blue + "========================================================================" + exit);
        System.out.print(blue + "|" + exit + yellow + "    선택하쇼   " + exit  + blue + "|     " + exit);
        int up = sc.nextInt();
        System.out.println(blue + "|======================================================================|" + exit);
        String sql = null;
        int honum;
        switch (up) {
            case 1:
                System.out.println("바꾸고자 하는 매물번호");
                honum=sc.nextInt();
                System.out.println("수정 사진 등록");
                String url = sc.next();
                sql = "UPDATE ROOMINFO SET photo_url = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pStmt = conn.prepareStatement(sql);
                    pStmt.setString(1,url);
                    pStmt.setInt(2,honum);
                    int rst = pStmt.executeUpdate();
                    System.out.println("rst : " + rst);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pStmt);
                    Common.close(conn);
                }
                break;
            case 2:
                System.out.println("바꾸고자 하는 매물번호");
                honum=sc.nextInt();
                System.out.println(blue + "========================================================================" + exit);
                System.out.println(blue + "|" + exit + "                       " + purple + "원하시는 기능을 골라주세요~!" + exit + "                        " + blue + "|" + exit);
                System.out.println(blue + "|======================================================================|" + exit);
                System.out.println(blue + "|                                                                      |" + exit);
                System.out.println(blue + "|        ------------------              ------------------            |" + exit);
                System.out.println(blue + "|       |" + exit + "   [1]매매   " + blue + "|            |" + exit + "   [3] 월세  " + blue + "|           |" + exit);
                System.out.println(blue + "|        ------------------              ------------------            |" + exit);
                System.out.println(blue + "|                                                                      |" + exit);
                System.out.println(blue + "|                                                                      |" + exit);
                System.out.println(blue + "|        ------------------              ------------------            |" + exit);
                System.out.println(blue + "|       |" + exit + "   [2] 전세    " + blue + "|             |" + exit + "    [4]종료     " + blue + "|            |" + exit);
                System.out.println(blue + "|        ------------------              ------------------            |" + exit);
                System.out.println(blue + "|                                                                      |" + exit);
                System.out.println(blue + "========================================================================" + exit);
                int tr=sc.nextInt();
                if(tr==4){
                    break;
                }
                sql = "UPDATE ROOMINFO SET deposit=NULL,monthly=NULL,jeonsegeum=NULL,Sale_price=NULL WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pStmt = conn.prepareStatement(sql);
                    pStmt.setInt(1,honum);
                    int rst = pStmt.executeUpdate();
                    System.out.println("rst : " + rst);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pStmt);
                    Common.close(conn);
                }

                switch (tr){
                    case 1:
                        System.out.println("\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀             ⠀⠀⠘\n" +
                                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  매매 가격 입력⠀⠀⢀⠇\n" +
                                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                        int sal=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method=?,Sale_price=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pStmt = conn.prepareStatement(sql);
                            pStmt.setString(1,"매매");
                            pStmt.setInt(2,sal);
                            pStmt.setInt(3,honum);
                            int rst = pStmt.executeUpdate();
                            System.out.println("rst : " + rst);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pStmt);
                            Common.close(conn);
                        }
                        break;
                    case 2:
                        System.out.println("\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀             ⠀⠀⠘\n" +
                                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  전세 가격 입력⠀⠀⢀⠇\n" +
                                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                        int jeo=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method=?,jeonsegeum=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pStmt = conn.prepareStatement(sql);
                            pStmt.setString(1,"전세");
                            pStmt.setInt(2,jeo);
                            pStmt.setInt(3,honum);
                            int rst = pStmt.executeUpdate();
                            System.out.println("rst : " + rst);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pStmt);
                            Common.close(conn);
                        }
                        break;
                    case 3:
                        System.out.println("\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀             ⠀⠀⠘\n" +
                                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀월세 보증금 가격 입력⠀⠇\n" +
                                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                        int dep=sc.nextInt();
                        System.out.println("\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀             ⠀⠀⠘\n" +
                                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  월세 가격 입력⠀⠀⢀⠇\n" +
                                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                        int mon=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method=?,deposit=?,monthly=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pStmt = conn.prepareStatement(sql);
                            pStmt.setString(1,"월세");
                            pStmt.setInt(2,dep);
                            pStmt.setInt(3,mon);
                            pStmt.setInt(4,honum);
                            int rst = pStmt.executeUpdate();
                            System.out.println("rst : " + rst);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pStmt);
                            Common.close(conn);
                        }
                        break;
                }
                break;
            case 3:
                System.out.println("\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                        "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀바꾸고자 하는 ⠀⠀⠘\n" +
                        "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  매물 번호 입력⠀⠀⢀⠇\n" +
                        "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                        "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                        "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                        "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                        "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                honum=sc.nextInt();
                System.out.println("수정 하고자 하는 전화번호");
                int phnum=sc.nextInt();
                sql = "UPDATE ROOMINFO SET phonenumber = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pStmt = conn.prepareStatement(sql);
                    pStmt.setInt(1,phnum);
                    pStmt.setInt(2,honum);
                    int rst = pStmt.executeUpdate();
                    System.out.println("rst : " + rst);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pStmt);
                    Common.close(conn);
                }
                break;
            case 4:
                System.out.println("\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                        "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀바꾸고자 하는 ⠀⠀⠘\n" +
                        "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  매물 번호 입력⠀⠀⢀⠇\n" +
                        "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                        "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                        "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                        "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                        "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
                honum=sc.nextInt();
                sc.nextLine();
                System.out.println("수정 할 비고");
                String rem=sc.nextLine();
                sql = "UPDATE ROOMINFO SET remark = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pStmt = conn.prepareStatement(sql);
                    pStmt.setString(1,rem);
                    pStmt.setInt(2,honum);
                    int rst = pStmt.executeUpdate();
                    System.out.println("rst : " + rst);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pStmt);
                    Common.close(conn);
                }
                break;
            case 5:
                break;
        }
    }

    public void RoomDelete(){
        System.out.println("\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠚⠉⠉⠉⠉⠉⠛⠒⠲⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⣩⣗⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⡞⢡⣤⣧⣾⠀⠀⠀⠀⠀⣸⠗⠛⠲⣇⢠⡃⠀⠈⠑⠒⠂⠤⢀⢀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢀⠾⠀⡞⠡⠄⠈⡇⠀⠀⠀⠀⡁⠀⠆⠀⢸⡾⠀⠀⠀⠀   ⠀⠀⠀⠈⠁⠂⠒⠤⢀⣀\n" +
                "⠀⠀⠀⣸⠂⠀⢇⣀⣠⣾⣷⣾⣿⣶⣶⣿⡦⠤⠴⢫⡇⠀⠀삭제 하고자 하는⠀⠀⠘\n" +
                "⠀⠀⠀⡇⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⡜⠀⠀  매물 번호 입력⠀⠀⢀⠇\n" +
                "⠀⠀⢠⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠇⠀⠀             ⠀⠀⢸⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠘⠦⠤⢤⣀⠀⠀⠀         ⠀⠀⠃⠀\n" +
                "⠀⠀⢸⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠈⠉⢙⣗⣲⣤⣤⣀⡀⠀⠀⠀⡸⠀⠀\n" +
                "⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠋⠉⠉⠙⠻⠿⣜⠃⠵⢲⣃⠀⠀\n" +
                "⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢛⣷⣶⣤⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀\n");
        int del=sc.nextInt();
        String sql="DELETE FROM RoomInfo WHERE house_num=?";
        try{
            conn= Common.getConnection();
            pStmt=conn.prepareStatement(sql);
            pStmt.setInt(1,del);
            int rst = pStmt.executeUpdate();
            System.out.println("rst : "+ rst);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Common.close(pStmt);
            Common.close(conn);
        }
    }

    public void AdminSelectPrn(List<AdminInfoVo> list) {
        for (AdminInfoVo e : list) {
            System.out.print(e.getADM_ID() + " ");
            System.out.println(e.getADM_PW());
            System.out.println(blue + "========================================================================" + exit);
        }
    }

    public void RoomSelcetPrn(List<RoomInfoVo> list) {
        for (RoomInfoVo e : list) {
            System.out.print(e.getHouse_num() + " ");
            System.out.print(e.getUser_id() + " ");
            System.out.print(e.getPhoto_url() + " ");
            System.out.print(e.getTrade_method() + " ");
            System.out.print(e.getDeposit() + " ");
            System.out.print(e.getMonthly() + " ");
            System.out.print(e.getJeonsegeum() + " ");
            System.out.print(e.getSale_price() + " ");
            System.out.print(e.getArea() + " ");
            System.out.print(e.getAccept_date() + " ");
            System.out.print(e.getAddress() + " ");
            System.out.print(e.getFloor1() + " ");
            System.out.print(e.getPhonenumber() + " ");
            System.out.print(e.getRegit_date() + " ");
            System.out.println(e.getRemark());
            System.out.println(blue + "========================================================================" + exit);
        }

    }
}
