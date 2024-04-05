package com.kh.Olumgollum_Project.MyPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import com.kh.Olumgollum_Project.COMMON.Common;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import java.util.*;
public class MyPageDao {
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m" ;
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pSmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    // 삭제할 방 번호 저장
    // 개인정보 수정 비밀번호 전화번호 주소 닉네임
    public void Userupdate(List<String> id_pw) {
        System.out.print(blue+
                "|======================================================================|\n" +

                "|       \uD83D\uDD2E      _____  _____  ____   _____  _____  _____        \uD83D\uDD2E     |\n" +
                "|            \uD83D\uDD2E|  |  ||  _  ||    \\ |  _  ||_   _||   __|              |\n" +
                "|              |  |  ||   __||  |  ||     |  | |  |   __|      \uD83D\uDD2E      |\n" +
                "|  \uD83D\uDD2E          |_____||__|   |____/ |__|__|  |_|  |_____|              |\n" +
                "|======================================================================|\n" +
                "| \uD83C\uDF26\uFE0F     ------------------              ------------------            |\n" +
                "|        |[1]   비밀번호    |     \uD83C\uDF38      |[2]   전화번호    |            |\n" +
                "|        ------------------              ------------------            |\n" +
                "|        ------------------              ------------------            |\n" +
                "| \uD83C\uDF38     |[3]     주소     |   \uD83C\uDF26\uFE0F        |[4]   닉네임      | \uD83C\uDF38        |\n" +
                "|        ------------------              ------------------            |\n" +
                "|        ------------------                                            |\n" +
                "|        |[5]    나가기    |         |￣￣￣￣￣￣￣|        ☁\uFE0F   ⭐      |\n" +
                "|        ------------------         | 뭐 바꿀래?  |            \uD83C\uDF38\uD83C\uDF38     |\n" +
                "|                   ☁\uFE0F              |＿＿＿＿＿＿＿|    ☁\uFE0F     \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38   |\n" +
                "|                                   (\\__/) ||              \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38   |\n" +
                "|                                   (•ㅅ•).||                  \uD83C\uDF38      |\n" +
                "|       ☁\uFE0F          \uD83C\uDF26\uFE0F              / . . . .づ                        |\n" +
                "========================================================================\n" +exit+
                yellow+"     뭐 바꿀래? : "+exit);
        int up = sc.nextInt();
        System.out.println(blue + "========================================================================" + exit);


        String sql = null;
        switch (up) {
            case 1:
                System.out.print("   수정하고자 하는 비밀번호 입력 : ");
                String pwd = sc.next();
                sql = "UPDATE INFO SET PASSWORD = ? WHERE USER_MAIL=?";
                try {
                    conn = Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1, pwd);
                    pSmt.setString(2, id_pw.get(0));
                    pSmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 2:
                System.out.print("   수정하고자 하는 전화번호 입력 :");
                String pn = sc.next();
                sql = "UPDATE INFO SET PHONE_NUMBER = ? WHERE USER_MAIL=?";
                try {
                    conn = Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1, pn);
                    pSmt.setString(2, id_pw.get(0));
                    pSmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 3:
                System.out.println("   수정하고자 하는 주소 입력 :");
                String ad = sc.nextLine();
                sql = "UPDATE INFO SET ADDRESS = ? WHERE USER_MAIL=?";
                try {
                    conn = Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1, ad);
                    pSmt.setString(2, id_pw.get(0));
                    pSmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 4:
                System.out.println("   수정하고자 하는 닉네임 입력 :");
                String ni = sc.next();
                sql = "UPDATE INFO SET NICKNAME = ? WHERE USER_MAIL=?";
                try {
                    conn = Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1, ni);
                    pSmt.setString(2, id_pw.get(0));
                    pSmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 5:
                System.exit(0);
        }
    }

    //===========================================================================================================================================================================================================
    public List<RoomInfoVo> Love_list(List<String> id_pw) { // 찜한방 목록화
        List<RoomInfoVo> love = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT rm.house_num,rm.user_id,rm.photo_url,rm.trade_method,rm.deposit,rm.MONTHLY,rm.jeonsegeum,rm.address, rm.area, rm.sale_price " +
                    "FROM ROOMINFO rm JOIN LOVE_ROOM lr " +
                    "ON rm.house_num = lr.shouse_num WHERE lr.user_id = '" + id_pw.get(0) + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //내가 찜한 방에 대한 정보들
                love.add(new RoomInfoVo(rs.getInt("house_num"), rs.getString("user_id"), rs.getString("photo_url"), rs.getString("trade_method"),
                        rs.getInt("deposit"), rs.getInt("MONTHLY"), rs.getInt("jeonsegeum"),
                        rs.getInt("sale_price"), rs.getString("area"), null, rs.getString("address"), null,
                        0, null, null));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return love;
    }

    //==================================================================================================================================================================================================================
    //db에서 찜삭제함수
    public void Love_delete(List<String> id_pw) { // 찜한방 목록 Delete
        try {
            // love 내가 찜한 방의 정보들
            conn = Common.getConnection();
            stmt = conn.createStatement();
            System.out.print("   삭제 할 방 번호를 입력해주세요 : ");
            int num = sc.nextInt();
            // 찜한 방 목록에서 확인 후 삭제
            String sql = "DELETE FROM LOVE_ROOM WHERE USER_ID = '" + id_pw.get(0) + "'" + "AND SHOUSE_NUM = '" + num + "'";
            rs = stmt.executeQuery(sql);
            // 방목록에서 원하는방 삭제
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//==========================================================================================================================================================================

    public List<RoomInfoVo> olume_list(List<String> id_pw) { // 올룸 목록

        List<RoomInfoVo> olume = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT address, deposit, area, trade_method, photo_url, MONTHLY, jeonsegeum, sale_price " +
                    "FROM ROOMINFO WHERE USER_ID = '" + id_pw.get(0) + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                olume.add(new RoomInfoVo(0, null, rs.getString("photo_url"), rs.getString("trade_method"),
                        rs.getInt("deposit"), rs.getInt("monthly"), rs.getInt("jeonsegeum"),
                        rs.getInt("sale_price"), rs.getString("area"), null, rs.getString("address"), null,
                        0, null, null));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return olume;
    }

    //===========================================================================================================================================================================
    // 개인정보 수정 비밀번호 전화번호 주소 닉네임
    public void print(List<RoomInfoVo> list){
        for(RoomInfoVo e : list)
            System.out.println(e.getUser_id());
    }
    //============================================================================================================================
    //올룸 수정 함수
    // 업데이트
    public void RoomUpdate(){
        System.out.print("   수정하고 싶은 정보 [1] 방 사진 [2] 거래방식(가격) [3] 전화번호 [4] 비고 [5] 종료");
        int up = sc.nextInt();
        String sql = null;
        int honum;
        switch (up) {
            case 1:
                System.out.print("   바꾸고자 하는 매물번호 : ");
                honum=sc.nextInt();
                System.out.println("수정 사진 등록");
                String url = sc.next();
                sql = "UPDATE ROOMINFO SET photo_url = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1,url);
                    pSmt.setInt(2,honum);
                    pSmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 2:
                System.out.print("   바꾸고자 하는 매물번호  :");
                honum=sc.nextInt();
                System.out.println("바꾸고 싶은 거래방식 선택 [1] 매매 [2] 전세 [3] 월세 [4] 종료");
                int tr=sc.nextInt();
                if(tr==4){
                    break;
                }
                sql = "UPDATE ROOMINFO SET deposit = NULL, monthly = NULL, jeonsegeum = NULL , Sale_price = NULL WHERE house_num =?";
                try{
                    conn=Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setInt(1,honum);
                    pSmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                switch (tr){
                    case 1:
                        System.out.print("  매매 가격을 알려주세요");
                        int sal=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method = ?,Sale_price=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pSmt = conn.prepareStatement(sql);
                            pSmt.setString(1,"매매");
                            pSmt.setInt(2,sal);
                            pSmt.setInt(3,honum);
                            pSmt.executeUpdate();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pSmt);
                            Common.close(conn);
                        }
                        break;
                    case 2:
                        System.out.print("  전세 가격을 알려주세요");
                        int jeo=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method=?,jeonsegeum=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pSmt = conn.prepareStatement(sql);
                            pSmt.setString(1,"전세");
                            pSmt.setInt(2,jeo);
                            pSmt.setInt(3,honum);
                            pSmt.executeUpdate();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pSmt);
                            Common.close(conn);
                        }
                        break;
                    case 3:
                        System.out.print("   보증금 가격 : ");
                        int dep=sc.nextInt();
                        System.out.print("   월세 가격 : ");
                        int mon=sc.nextInt();
                        sql = "UPDATE ROOMINFO SET trade_method=?,deposit=?,monthly=? WHERE house_num=?";
                        try{
                            conn=Common.getConnection();
                            pSmt = conn.prepareStatement(sql);
                            pSmt.setString(1,"월세");
                            pSmt.setInt(2,dep);
                            pSmt.setInt(3,mon);
                            pSmt.setInt(4,honum);
                            pSmt.executeUpdate();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            Common.close(pSmt);
                            Common.close(conn);
                        }
                        break;
                }
                break;
            case 3:
                System.out.print("   바꾸고자 하는 매물번호  :");
                honum=sc.nextInt();
                System.out.print("   수정 하고자 하는 전화번호  :");
                int phnum=sc.nextInt();
                sql = "UPDATE ROOMINFO SET phonenumber = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setInt(1,phnum);
                    pSmt.setInt(2,honum);
                    pSmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 4:
                System.out.print("   바꾸고자 하는 매물번호  :");
                honum=sc.nextInt();
                sc.nextLine();
                System.out.print("   수정 할 비고  :");
                String rem=sc.nextLine();
                sql = "UPDATE ROOMINFO SET remark = ? WHERE house_num=?";
                try{
                    conn=Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1,rem);
                    pSmt.setInt(2,honum);
                    pSmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 5:
                System.exit(0);
        }
    }
    //올룸 삭제 함수
    // 방삭제
    public void RoomDelete(){
        System.out.print("   삭제 할 매물번호를 입력하세요 : ");
        int num1 = sc.nextInt();
        String sql="DELETE FROM LOVE_ROOM WHERE SHOUSE_NUM = ?";
        try{
            conn = Common.getConnection();
            pSmt = conn.prepareStatement(sql);
            pSmt.setInt(1,num1);
            pSmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Common.close(pSmt);
            Common.close(conn);
        }
    }
    //======================================================== 회원 탈퇴=======================================================
    public void UserDelete(List<String> id_pw) {
        System.out.println(red+
                "=====================================\n"+
                "   ·▄▄▄▄  ▄▄▄ .▄▄▌  ▄▄▄ .▄▄▄▄▄▄▄▄ .\n" +
                "   ██▪ ██ ▀▄.▀·██•  ▀▄.▀·•██  ▀▄.▀·\n" +
                "   ▐█· ▐█▌▐▀▀▪▄██▪  ▐▀▀▪▄ ▐█.▪▐▀▀▪▄\n" +
                "   ██. ██ ▐█▄▄▌▐█▌▐▌▐█▄▄▌ ▐█▌·▐█▄▄▌\n" +
                "   ▀▀▀▀▀•  ▀▀▀ .▀▀▀  ▀▀▀  ▀▀▀  ▀▀▀ \n" +
                "=====================================");
        System.out.println(blue+" [1]\uD83D\uDE2D탈퇴 [2] 나가기  :");
        int ud = sc.nextInt();
        String sql = "DELETE FROM INFO WHERE USER_MAIL =  ?";
        switch (ud) {
            case 1:
                try {
                    conn = Common.getConnection();
                    pSmt = conn.prepareStatement(sql);
                    pSmt.setString(1, id_pw.get(0));
                    pSmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Common.close(pSmt);
                    Common.close(conn);
                }
                break;
            case 2:
                break;
        }
    }
    //=========================================================================================================================================================
    public void loveprn(List<RoomInfoVo> LP) {
        System.out.println(blue + "=======================================================================" + exit);
        System.out.println(blue +
                "   —̳͟͞͞ \uD83D\uDC97    ██╗         ██╗    ███████╗    ████████╗        \uD83C\uDF38       \n" +
                "               ██║         ██║    ██╔════╝    ╚══██╔══╝               \n" +
                "               ██║         ██║    ███████╗       ██║    —̳͟͞͞ \uD83D\uDC97             \n" +
                "      \uD83C\uDF38       ██║         ██║    ╚════██║       ██║                  \n" +
                "               ███████╗    ██║    ███████║       ██║               —̳͟͞͞ \uD83D\uDC97  \n" +
                "    —̳͟͞͞ \uD83D\uDC97   ╚══════╝    ╚═╝    ╚══════╝       ╚═╝  \uD83C\uDF38                \n");
        System.out.println(blue + "=======================================================================" + exit);
        for (RoomInfoVo e : LP) {
            System.out.println(blue + "|  ⭐------------------⭐                                              " + exit);
            System.out.println(blue + "|   ▏                    ▏  \uD83C\uDFE0"+e.getAddress()+"                           " + exit);
            System.out.println(blue + "|   ▏"+(e.getPhoto_url())+"               ▏          \uD83D\uDCB8"+e.getJeonsegeum()+"                                  " + exit);
            System.out.println(blue + "|   ▏                    ▏          \uD83D\uDCB8"+e.getSale_price()+"                                " + exit);
            System.out.println(blue + "|   ▏                    ▏          \uD83D\uDCB8"+e.getMonthly()+"                                " + exit);
            System.out.println(blue + "|  ⭐------------------⭐       \uD83D\uDFEB"+e.getArea()+"                                   " + exit);
            System.out.println(blue + "――――――――――――――――――――――――――――――――――――――――――――" + exit);
        }
    }
    //===============================================================================================================================================
    public void mprn() {
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(blue +
                "|   —̳͟͞͞ \uD83D\uDC97     _____ __ __    _____ _____ _____ _____      \uD83C\uDF38        |\n" +
                "|               |     |  |  |  |  _  |  _  |   __|   __|               |\n" +
                "|         \uD83C\uDF38    | | | |_   _|  |   __|     |  |  |   __|   —̳͟͞͞ \uD83D\uDC97    |\n" +
                "|               |_|_|_| |_|    |__|  |__|__|_____|_____|               |\n" +
                "|         —̳͟͞͞ \uD83D\uDC97                                 —̳͟͞͞ \uD83D\uDC97            |");
        System.out.println(blue + "|======================================================================|" + exit);
        System.out.println(blue + "| \uD83C\uDF26\uFE0F     ------------------              ------------------            |" + exit);
        System.out.println(blue + "|       |" + exit + "[1]   회원 수정    " + blue + "|     \uD83C\uDF38      |" + exit + "[2]    찜 목록    " + blue + "|           |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "| \uD83C\uDF38    |" + exit + "[3]   올룸 목록    " + blue + "|   \uD83C\uDF26\uFE0F        |" + exit + "[4]   회원 탈퇴   " + blue + "| \uD83C\uDF38        |" + exit);
        System.out.println(blue + "|        ------------------              ------------------            |" + exit);
        System.out.println(blue + "|        ------------------                                            |" + exit);
        System.out.println(blue + "|       |" + exit + "[5]    나가기      " + blue + "         |￣￣￣￣￣￣￣|     " + red + "   ☁\uFE0F   ⭐  " + blue + "    |");
        System.out.println(blue + "|        ------------------         |  선택하쇼   |     " + green + "       \uD83C\uDF38\uD83C\uDF38 " + blue + "    |");
        System.out.println(blue + "|                   ☁\uFE0F              |＿＿＿＿＿＿＿|  " + green + "  ☁\uFE0F     \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38    " + blue + "|");
        System.out.println(blue + "|                                   (\\__/) || " + green + "             \uD83C\uDF38\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38   " + blue + "|");
        System.out.println(blue + "|                                   (•ㅅ•).||  " + green + "                \uD83C\uDF38      " + blue + "|");
        System.out.println(blue + "|       ☁\uFE0F          \uD83C\uDF26\uFE0F              / . . . .づ  " + green + "                      " + blue + "|");
        System.out.println(blue + "========================================================================" + exit);
        System.out.print(blue + "|" + exit + "     " + yellow + "|  선택하쇼   |" + exit + "     " + blue + "|     " + exit);
    }
}
