package com.kh.Olumgollum_Project.RoomSearch;


import com.kh.Olumgollum_Project.RoomInfo.OlumGollumPage;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoomSearchPage {
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m";
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";
    Scanner sc = new Scanner(System.in);
    RoomSearchDao dao = new RoomSearchDao();

    public void RoomSearchPage(List<String> id_pw) throws ParseException, InterruptedException {
        OlumGollumPage RIM = new OlumGollumPage();
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(blue + "|" + exit + red + "     /$$$$$$   /$$$$$$  /$$       /$$       /$$   /$$ /$$      /$$" + blue + "    |\n" + exit +
                blue + "|" + exit + red + "    /$$__  $$ /$$__  $$| $$      | $$      | $$  | $$| $$$    /$$$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "   | $$  \\__/| $$  \\ $$| $$      | $$      | $$  | $$| $$$$  /$$$$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "   | $$ /$$$$| $$  | $$| $$      | $$      | $$  | $$| $$ $$/$$ $$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "   | $$|_  $$| $$  | $$| $$      | $$      | $$  | $$| $$  $$$| $$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "   | $$  \\ $$| $$  | $$| $$      | $$      | $$  | $$| $$\\  $ | $$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "   |  $$$$$$/|  $$$$$$/| $$$$$$$$| $$$$$$$$|  $$$$$$/| $$ \\/  | $$" + exit + blue + "    |\n" + exit +
                blue + "|" + exit + red + "    \\______/  \\______/ |________/|________/ \\______/ |__/     |__/" + exit + blue + "    |" + exit);
        System.out.println(blue + "|======================================================================|" + exit);
        System.out.println(blue + "|                                                     " + blue + "| " + exit + " [3] 돌아가기 " + blue + "  |" + exit);
        System.out.println(blue + "|                                                     -----------------|" + exit);
        System.out.println(blue + "|                                                                      |" + exit);
        System.out.println(blue + "|                      ------------------------                        |" + exit);
        System.out.println(blue + "|                     |" + exit + "     [1] 전체 방 조회     " + blue + "|                       |" + exit);
        System.out.println(blue + "|                      ------------------------                        |" + exit);
        System.out.println(blue + "|                                                                      |" + exit);
        System.out.println(blue + "|                                                                      |" + exit);
        System.out.println(blue + "|                      ------------------------                        |" + exit);
        System.out.println(blue + "|                     |" + exit + "      [2] 세부 검색      " + blue + "|                        |" + exit);
        System.out.println(blue + "|                      ------------------------                        |" + exit);
        System.out.println(blue + "|                                                     -----------------|" + exit);
        System.out.println(blue + "|                                                     |" + exit + "   [4] 나가기  " + blue + "  |" + exit);
        System.out.println(blue + "========================================================================" + exit);


        while (true) {
            System.out.println(purple+"  메뉴 선택 : [1]전체 방 조회 [2]세부 검색 [3]돌아가기 [4]나가기 : "+exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.print(yellow+"  번호 입력 :  "+exit);
            int sel = sc.nextInt();

            List<RoomInfoVo> list = new ArrayList<>();
            switch (sel) {
                case 1: // 전체 방 정보 조회
                    List<RoomInfoVo> allList = dao.roomSelect();
                    dao.roomSelectPrn(allList);
                    continue;

                case 2: // 지역별 검색
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println("  지역별 검색을 시작합니다.");
                    System.out.println(blue + "========================================================================" + exit);
                    list = dao.adressSearchSelect();
                    dao.roomSelectPrn(list);

                    System.out.println("  거래검색을 하시겠습니까? [네,아니요] ");
                    System.out.println(blue + "========================================================================" + exit);
                    String str = sc.next();
                    System.out.println(blue + "========================================================================" + exit);
                    if (str.equals("네")) {

                        list = dao.tradeSelect(list);
                        dao.roomSelectPrn(list);
                    }
                    System.out.println("평 수을 검색하시겠습니까? [네,아니요] ");
                    System.out.println(blue + "========================================================================" + exit);
                    String str2 = sc.next();
                    System.out.println(blue + "========================================================================" + exit);
                    if (str2.equals("네")) {

                        List<RoomInfoVo> list3 = dao.areaTradeSelect(list);
                        dao.roomSelectPrn(list3);
                    }
                    System.out.println("층 수을 검색하시겠습니까? [네,아니요] ");
                    System.out.println(blue + "========================================================================" + exit);
                    String str3 = sc.next();
                    System.out.println(blue + "========================================================================" + exit);
                    if (str3.equals("네")) {
                        List<RoomInfoVo> list4 = dao.floorTradeSelect(list);
                        dao.roomSelectPrn(list4);
                    }
                    System.out.println("다시 검색하시겠습니까?");
                    System.out.println(blue + "========================================================================" + exit);
                    String str4 = sc.next();
                    System.out.println(blue + "========================================================================" + exit);
                    if (str4.equals("네")) continue;
                    else break;
                case 3:
                    // 관리자 모드 페이지로 돌아가기
                    if(id_pw.get(2).equals("Admin"))
                    {
                        System.out.println(blue + "========================================================================" + exit);
                        System.out.println(purple+"                         메인 페이지로 돌아갑니다."+exit);
                        Thread.sleep(1000);
                        RIM.Admin_Olumgollum_MainPage(id_pw);
                    }
                    // 유저 페이지로 돌아가기
                    else
                    {
                        System.out.println(blue + "========================================================================" + exit);
                        System.out.println(purple+"                         메인 페이지로 돌아갑니다."+exit);
                        Thread.sleep(1000);
                        RIM.User_Olumgollum_MainPage(id_pw);
                    }
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println("    메인페이지로 이동합니다....");
                    System.out.println(blue + "========================================================================" + exit);
                    break;
                case 4:
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println("    프로그램을 종료합니다....");
                    System.out.println(blue + "========================================================================" + exit);
                    break;
                default:
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println("    메뉴를 잘못 선택했습니다.");
                    System.out.println(blue + "========================================================================" + exit);
                    continue;
            }
            break;
        }
    }
}
