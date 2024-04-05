package com.kh.Olumgollum_Project.AdminInfo;

import com.kh.Olumgollum_Project.LoginInfo.LoginInfoDao;
import com.kh.Olumgollum_Project.LoginInfo.LoginInfoVo;
import com.kh.Olumgollum_Project.RoomInfo.OlumGollumPage;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class AdminInfoPage {
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m";
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";

    public void Adminpage(List<String> id_pw) throws InterruptedException, ParseException {
        Scanner sc = new Scanner(System.in);
        AdminInfoDao dao = new AdminInfoDao();
        LoginInfoDao dao1 = new LoginInfoDao();
        OlumGollumPage RIM = new OlumGollumPage();
        while (true) {
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(purple +
                    "                               _           _       \n" +
                    "                              | |         (_)      \n" +
                    "                      __ _  __| |_ __ ___  _ _ __  \n" +
                    "                     / _` |/ _` | '_ ` _ \\| | '_ \\ \n" +
                    "                    | (_| | (_| | | | | | | | | | |\n" +
                    "                     \\__,_|\\__,_|_| |_| |_|_|_| |_|\n" +
                    "                     _ __   __ _  __ _  ___        \n" +
                    "                    | '_ \\ / _` |/ _` |/ _ \\       \n" +
                    "                    | |_) | (_| | (_| |  __/       \n" +
                    "                    | .__/ \\__,_|\\__, |\\___|       \n" +
                    "                    | |           __/ |            \n" +
                    "                    |_|          |___/      " + exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(green + "   접속할 페이지 [1] 관리자 정보 [2] 회원정보 [3] 방정보 [4]돌아가기 [5] 종료" + exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
            int mana = sc.nextInt();
            System.out.println(blue + "========================================================================" + exit);
            switch (mana) {
                // 관리자 정보 변경 부분
                case 1:
                    System.out.println(green + "   [1] 관리자 조회 [2]관리자 추가 [3] 관리자 삭제 [4] 관리페이지로 [5] 돌아가기 [6] 종료" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
                    int ger = sc.nextInt();
                    System.out.println(blue + "========================================================================" + exit);
                    if (ger == 1) {
                        List<AdminInfoVo> list = dao.admin_infoSelect();
                        dao.AdminSelectPrn(list);
                        break;
                    } else if (ger == 2) {
                        dao.AdminInsert();
                        break;
                    } else if (ger == 3) {
                        dao.AdminDelete();
                        break;
                    } else if (ger == 4) {
                        Thread.sleep(1000);
                        continue;
                    } else if (ger == 5) {
                        // 관리자 모드 페이지로 돌아가기
                        if (id_pw.get(2).equals("Admin")) {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.Admin_Olumgollum_MainPage(id_pw);
                        }
                        // 유저 페이지로 돌아가기
                        else {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.User_Olumgollum_MainPage(id_pw);
                        }
                        System.out.println(blue + "========================================================================" + exit);
                        System.out.println(yellow+"         메인페이지로 이동합니다...."+exit);
                        System.out.println(blue + "========================================================================" + exit);
                        break;
                    } else if (ger == 6) {
                        System.exit(0);
                    } else {
                        System.out.println(green + "   번호를 잘못 입력 하였습니다.   " + exit);
                    }
                    //회원 정보 변경 부분
                case 2:
                    System.out.println(green + "   [1] 회원 정보 조회 [2] 회원 정보 삭제 [3] 관리페이지로 [4] 돌아가기 [5] 종료" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
                    int mem = sc.nextInt();
                    System.out.println(blue + "========================================================================" + exit);
                    if (mem == 1) {
                        List<LoginInfoVo> list = dao1.logsel();
                        dao1.logSelectPrn(list);
                        break;
                    } else if (mem == 2) {
                        dao.LogDelete();
                        break;
                    } else if (mem == 3) {
                        Thread.sleep(1000);
                        continue;
                    } else if (mem == 4) {
                        // 관리자 모드 페이지로 돌아가기
                        if (id_pw.get(2).equals("Admin")) {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.Admin_Olumgollum_MainPage(id_pw);
                        }
                        // 유저 페이지로 돌아가기
                        else {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.User_Olumgollum_MainPage(id_pw);
                        }
                        System.out.println(blue + "========================================================================" + exit);
                        System.out.println("    메인페이지로 이동합니다....");
                        System.out.println(blue + "========================================================================" + exit);
                        break;
                    } else if (mem == 5) {
                        System.exit(0);
                    } else {
                        System.out.println("번호를 잘못 입력 하였습니다.");
                    }
                case 3:
                    // 방 정보 변경 부분
                    System.out.println(green + "   [1] 방 조회 [2] 방 정보 수정 [3] 방 삭제 [4] 관리페이지로 [5] 돌아가기 [6] 종료" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
                    int ro = sc.nextInt();
                    if (ro == 1) {
                        List<RoomInfoVo> list = dao.RoomSelect();
                        dao.RoomSelcetPrn(list);
                        break;
                    } else if (ro == 2) {
                        dao.RoomUpdate();
                        break;
                    } else if (ro == 3) {
                        dao.RoomDelete();
                        break;
                    } else if (ro == 4) {
                        Thread.sleep(1000);
                        continue;
                    } else if (ro == 5) {
                        // 관리자 모드 페이지로 돌아가기
                        if (id_pw.get(2).equals("Admin")) {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.Admin_Olumgollum_MainPage(id_pw);
                        }
                        // 유저 페이지로 돌아가기
                        else {
                            System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                            Thread.sleep(1000);
                            RIM.User_Olumgollum_MainPage(id_pw);
                        }
                        System.out.println(blue + "========================================================================" + exit);
                        System.out.println("    메인페이지로 이동합니다....");
                        System.out.println(blue + "========================================================================" + exit);
                        break;
                    } else if (ro == 6) {
                        System.exit(0);
                    } else {
                        System.out.println("번호를 잘못 입력 하였습니다.");
                    }
                case 4:
                    // 관리자 모드 페이지로 돌아가기
                    if (id_pw.get(2).equals("Admin")) {
                        System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                        Thread.sleep(1000);
                        RIM.Admin_Olumgollum_MainPage(id_pw);
                    }
                    // 유저 페이지로 돌아가기
                    else {
                        System.out.println(purple + "                         메인 페이지로 돌아갑니다." + exit);
                        Thread.sleep(1000);
                        RIM.User_Olumgollum_MainPage(id_pw);
                    }
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println("    메인페이지로 이동합니다....");
                    System.out.println(blue + "========================================================================" + exit);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

}

