package com.kh.Olumgollum_Project.RoomInfo;


import com.kh.Olumgollum_Project.AdminInfo.AdminInfoPage;
import com.kh.Olumgollum_Project.MyPage.MyPage;
import com.kh.Olumgollum_Project.RoomSearch.RoomSearchPage;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class OlumGollumPage {
    public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36;m" ;
    public static final String white     = "\u001B[37m" ;
    public static final String exit     = "\u001B[0m" ;
    public void Admin_Olumgollum_MainPage(List<String> user_id_pw) throws ParseException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        RoomInfoDao dao = new RoomInfoDao(); // 방 올룸 페이지로 이동하기 위한 객체
        RoomSearchPage RSP = new RoomSearchPage(); // 방 골룸 페이지로 이동하기 위한 객체
        AdminInfoPage AIP = new AdminInfoPage(); //관리자 페이지로 이동하기 위한 객체
        MyPage MPM = new MyPage(); // 마이페이지로 이동하기 위한 객체
        System.out.println(blue+"========================================================================" + exit);
        System.out.println(blue+"|"+exit+"      "+red+"관리자모드"+exit+"          "+purple+"Olumgollum_MainPage"+exit+"           "+blue+"|"+exit +green+"  [0]마이페이지"+exit+blue+"  |"+exit);
        System.out.println(blue+"|                                                      ----------------|"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                     |"+exit+"       [1] 방 올룸       "+blue+"|                       |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                                                                      |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                     |"+exit+"       [2] 방 골룸       "+blue+"|                       |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|-----------------                                     ----------------|"+exit);
        System.out.println(blue+"|"+exit+" "+red+"[3]관리자 페이지"+exit+"  "+blue+"|                                    |"+exit+"    [4]나가기    "+blue+"|"+exit);
        System.out.println(blue + "========================================================================" + exit);
        System.out.print("     페이지 선택  :   ");
        int sel = sc.nextInt();
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(yellow+"                            로딩중입니다...."+exit);
        System.out.println(blue + "========================================================================" + exit);
        Thread.sleep(2000);
        switch (sel) {
            // 마이페이지로 이동
            case 0:
                System.out.println(purple+"                         마이 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                MPM.MyPageFunc(user_id_pw);
                break;
            // 방 올룸 페이지로 이동
            case 1:
                System.out.println(purple+"                        방 올룸 페이지로 이동합니다."+exit);
                Thread.sleep(1000);

                //방 데이터 입력 input함수 rvo 객체에 저장
                RoomInfoVo rvo = dao.RoomInputFunc();
                while(true){
                    System.out.print("[0]종료하기 [1]입력된 데이터 확인 [2]데이터 DB에 저장 : ");
                    int select = sc.nextInt();
                    switch(select) {
                        case 0:
                            Thread.sleep(2000);
                            System.out.println(blue + "========================================================================" + exit);
                            System.out.println(red + "                         프로그램을 종료합니다." + exit);
                            System.out.println(blue + "========================================================================" + exit);
                            break;
                        case 1:
                            //입력된 방 데이터 확인 함수 rvo 객체 출력
                            dao.RoomInputPrF(rvo);
                            break;
                        case 2:
                            //데이터베이스에 Insert하는 함수 rvo객체 INSERT
                            dao.RoomInsert(rvo);
                            break;
                        default:
                            System.out.println("잘못 입력했습니다.");
                    }
                    if(select == 0) break;
                }
                break;
            case 2:
                // 방 골룸 페이지로 이동
                System.out.println(purple+"                        방 골룸 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                RSP.RoomSearchPage(user_id_pw);
                break;
            case 3:
                //관리자 페이지 이동
                System.out.println(purple+"                         관리자 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                AIP.Adminpage(user_id_pw);
                break;
            case 4:
                Thread.sleep(2000);
                System.out.println(blue + "========================================================================" + exit);
                System.out.println(red + "                         프로그램을 종료합니다." + exit);
                System.out.println(blue + "========================================================================" + exit);
                System.exit(0);;
            default:
                System.out.println(red+"                         입력이 잘못 되었습니다."+exit);
        }
    }
    public void User_Olumgollum_MainPage(List<String> user_id_pw) throws ParseException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        RoomInfoDao dao = new RoomInfoDao(); // 방 올룸 페이지로 이동하기 위한 객체
        RoomSearchPage RSP = new RoomSearchPage(); // 방 골룸 페이지로 이동하기 위한 객체
        MyPage MPM = new MyPage(); // 마이페이지로 이동하기 위한 객체
        System.out.println(blue+"========================================================================" + exit);
        System.out.println(blue+"|"+exit+"                        "+purple+"Olumgollum_MainPage"+exit+"           "+blue+"|"+exit + green+"  [0]마이페이지"+exit +blue+"  |"+exit);
        System.out.println(blue+"|                                                      ----------------|"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                     |"+exit+"       "+yellow+"[1] 방 올룸"+exit+"       "+blue+"|                       |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                                                                      |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                     |"+exit+"       "+yellow+"[2] 방 골룸"+exit+"       "+blue+"|                       |"+exit);
        System.out.println(blue+"|                      ------------------------                        |"+exit);
        System.out.println(blue+"|                                                     -----------------|"+exit);
        System.out.println(blue+"|                                                    |"+exit+"    [3]나가기     "+blue+"|"+exit);
        System.out.println(blue + "========================================================================" + exit);
        System.out.print("     페이지 선택  :   ");
        int sel = sc.nextInt();
        System.out.println(blue + "========================================================================" + exit);
        System.out.println(yellow+"                            로딩중입니다...."+exit);
        System.out.println(blue + "========================================================================" + exit);
        Thread.sleep(2000);
        switch (sel) {
            // 마이페이지로 이동
            case 0:
                System.out.println(purple+"                         마이 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                MPM.MyPageFunc(user_id_pw);
                break;
            // 방 올룸 페이지로 이동
            case 1:
                System.out.println(purple+"                        방 올룸 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                //방 데이터 입력 input함수 rvo 객체에 저장
                RoomInfoVo rvo = dao.RoomInputFunc();
                while(true){
                    System.out.print("[0]종료하기 [1]입력된 데이터 확인 [2]데이터 DB에 저장 : ");
                    int select = sc.nextInt();
                    switch(select) {
                        case 0:
                            Thread.sleep(2000);
                            System.out.println(blue + "========================================================================" + exit);
                            System.out.println(red + "                         프로그램을 종료합니다." + exit);
                            System.out.println(blue + "========================================================================" + exit);
                            break;
                        case 1:
                            //입력된 방 데이터 확인 함수 rvo 객체 출력
                            dao.RoomInputPrF(rvo);
                            break;
                        case 2:
                            //데이터베이스에 Insert하는 함수 rvo객체 INSERT
                            dao.RoomInsert(rvo);
                            break;
                        default:
                            System.out.println("잘못 입력했습니다.");
                    }
                    if(select == 0) break;
                }
                break;
            // 방 골룸 페이지로 이동
            case 2:
                // 방 골룸 페이지로 이동
                System.out.println(purple+"                        방 골룸 페이지로 이동합니다."+exit);
                Thread.sleep(1000);
                RSP.RoomSearchPage(user_id_pw);
                break;
            case 3:
                Thread.sleep(2000);
                System.out.println(blue + "========================================================================" + exit);
                System.out.println(red + "                         프로그램을 종료합니다." + exit);
                System.out.println(blue + "========================================================================" + exit);
                System.exit(0);;
            default:
                System.out.println("입력이 잘못 되었습니다.");
        }
    }
}
