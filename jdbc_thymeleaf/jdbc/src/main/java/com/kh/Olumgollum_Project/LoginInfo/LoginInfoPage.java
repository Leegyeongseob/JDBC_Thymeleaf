package com.kh.Olumgollum_Project.LoginInfo;


import com.kh.Olumgollum_Project.AdminInfo.AdminInfoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LoginInfoPage {
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36;m" ;
    public static final String white = "\u001B[37m";
    public static final String exit = "\u001B[0m";

    public List<String> startfunc() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        LoginInfoDao dao = new LoginInfoDao();
        AdminInfoDao Addao = new AdminInfoDao();
        List<String> User_id_pw = new ArrayList<>(); // 로그인 또는 회원 가입 성공시 ID,PW 저장 후 리턴
        while(true) {
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(blue + "|" + exit + "                       " + purple + "원하시는 기능을 골라주세요~!" + exit + "                        " + blue + "|" + exit);
            System.out.println(blue + "|======================================================================|" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|        ------------------              ------------------            |" + exit);
            System.out.println(blue + "|       |" + exit + "   [1]로그인 화면   " + blue + "|            |" + exit + "  [3]회원정보확인   " + blue + "|           |" + exit);
            System.out.println(blue + "|        ------------------              ------------------            |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "|        ------------------              ------------------            |" + exit);
            System.out.println(blue + "|       |" + exit + "   [2] 회원가입    " + blue + "|             |" + exit + "    [4]나가기     " + blue + "|            |" + exit);
            System.out.println(blue + "|        ------------------              ------------------            |" + exit);
            System.out.println(blue + "|                                                                      |" + exit);
            System.out.println(blue + "========================================================================" + exit);
            System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
            int log = sc.nextInt();
            System.out.println(blue + "========================================================================" + exit);
            switch (log) {
                case 1:
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(red + "|            [1] 일반 유저 로그인              [2] 관리자 로그인            |" +exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.print(blue + "|" + exit + "     " + yellow + "번호입력" + exit + "     " + blue + "|     " + exit);
                    int chi = sc.nextInt();
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(purple + "                 로그인 화면으로 이동합니다......(로딩중....)" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    //화면전환이 너무 빨라서 2초간 멈춤.
                    Thread.sleep(2000);
                    // 관리자 인 경우 로그인
                    if (chi == 2){
                        User_id_pw = Addao.Adminlogin();
                        System.out.println(red+"                       관리자 권한으로 접속하였습니다..."+exit);
                        Thread.sleep(2000);
                    }
                    else {
                        //로그인 하러 이동! (성공시 리스트에 ID, PW를 User_id_pw 리스트에 저장)
//                        User_id_pw = dao.login();
                    }
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    System.out.println(blue + "|" + exit + "                           " + red + "!OLUMGOLUM LOGIN!" + exit + "                          " + blue + "|" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    System.out.println(blue + "|                      -----------------------------                   |" + exit);
                    System.out.println(blue + "|             " + purple + "아이디" + exit + "   " + blue + "|" + exit + "       " + User_id_pw.get(0));
                    System.out.println(blue + "|                      -----------------------------                   |" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    System.out.println(blue + "|                      -----------------------------                   |" + exit);
                    System.out.println(blue + "|            " + purple + "패스워드" + exit + "   " + blue + "|" + exit + "        " + User_id_pw.get(1));
                    System.out.println(blue + "|                      -----------------------------                   |" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    Thread.sleep(2000);
                    System.out.println(blue + "|" + exit + "                      " + yellow + "-----------------------------" + exit + "                   " + blue + "|" + exit);
                    System.out.println(blue + "|" + exit + "                     " + yellow + "|          로그인 완료!         |" + exit + "                  " + blue + "|" + exit);
                    System.out.println(blue + "|" + exit + "                      " + yellow + "-----------------------------" + exit + "                   " + blue + "|" + exit);
                    System.out.println(blue + "|                                                                      |" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(green+"                         올룸골룸에 접속하였습니다..."+exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(yellow+"\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⢇⠇⠅⠂⠐⠠⢑⠸⡸⣱⢟⣟⡿⡽⣇⢏⡆⢂⠄⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠢⠡⠁⢀⠈⠀⡂⡑⡸⡸⡽⡽⡽⡝⡎⡲⡩⢐⢰⢪⣗⡧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢔⠦⢄⡞⠌⡐⠀⠀⡀⠐⡐⢌⢜⡎⡇⡯⣫⢧⡣⡣⡂⢂⠕⣕⢵⢍⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⡎⡎⡞⡐⠀⠀⠂⠠⡀⡢⢱⣐⡇⣗⡽⡕⣗⣵⡵⣜⣄⠢⡱⣪⢇⢪⢪⢢⢢⢠⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢑⢵⢑⠠⡬⠢⢨⢤⡱⣵⡵⠓⣗⢷⡽⡚⢕⢕⣣⣳⢢⢓⢮⣫⢪⠪⣪⡳⡯⣯⣿⣽⣮\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⢐⢾⣻⠢⠀⠀⠀⠀⠀⠀⠀⠊⢆⠀⠌⡢⣡⡪⣼⡽⡊⠄⡯⡳⢽⣿⢿⣽⣻⢮⢇⡗⡕⣽⢰⢱⢱⢹⢽⡿⣾⣿⣿\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⢻⢮⡳⡡⠀⠀⠀⠀⠀⠀⠀⠈⢐⢐⠌⡪⢚⢱⠵⢪⢌⣞⣯⢿⣺⡻⣮⣞⡯⣟⢮⢺⢼⢮⢮⣪⣗⣿⣿⣿⣿⠿\n" +
                            "   ⠀⠀⠀⢀⡴⣶⠠⠀⠀⢟⡮⡲⡠⠀⠀⠀⠀⢀⢠⣐⢘⠸⡨⡢⣣⢫⠨⢀⠂⡪⡫⡷⡵⣽⣽⢽⣻⣯⢎⢗⣿⡿⡽⣷⡿⠛⠉⠉⠀⠀\n" +
                            "   ⠀⠀⠀⠘⢾⢽⢝⢔⠀⢙⣽⡺⡰⡀⠀⢀⢔⢕⢕⢜⡄⣂⡑⡕⢌⢚⠾⣦⡳⣼⡼⣿⢾⣻⣞⣗⣿⢯⡓⣽⣻⣽⣻⡯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⡀⠁⢿⣯⣗⡧⡒⣯⡯⣏⢮⢌⢌⡘⠐⡁⣦⣳⢅⢷⡹⣜⢄⠕⢕⢯⡳⣯⣿⣿⣟⡾⢝⣝⣜⡾⣫⡻⡾⣽⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⢀⢪⣰⡨⡀⣳⣿⣺⣗⣕⡯⣗⢯⣮⣻⢦⣡⣳⣳⡽⡢⠀⢯⢺⢵⡱⣑⢔⢽⡮⣷⢿⢷⡏⡞⣪⢪⡪⡧⣫⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⢳⣕⣯⣖⢼⣻⡿⣳⢯⣞⣯⣿⣺⣞⣿⡳⠛⠚⠉⠀⠀⠀⡗⢵⢝⡮⡏⡇⡏⡎⡇⡗⡽⡸⣸⢸⢼⢽⢵⣿⣿⣯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠠⠨⡀⡻⣺⣾⣿⡯⡯⡯⣫⡻⣯⡷⣟⠾⠑⠀⠀⠀⠀⠀⠀⠀⢸⢸⢸⢪⡺⡸⡜⣜⢼⢸⣪⣯⢮⣳⣽⣽⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀\n" +
                            "   ⢨⡳⣕⢹⣯⣿⣷⣟⣯⣯⢷⣕⡵⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠱⡱⡱⡕⡯⡾⡼⡮⣟⢯⣳⡳⡵⣯⣿⣻⣿⣿⣿⡗⠀⠀⠀⠀⠀\n" +
                            "   ⠐⡽⡾⠜⠈⠛⢻⣿⣷⣿⣽⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢮⢺⢜⢎⢗⢽⣪⣷⣿⢯⣿⣳⣯⣷⣿⣿⢷⣳⠀⠀⠀⠀⠀"+exit);
                    Thread.sleep(2000);
                    return User_id_pw;
                case 2:
                    System.out.println(purple + "               회원가입 화면으로 이동합니다......(로딩중....)" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    Thread.sleep(2000);
                    //회원가입 하러 이동!
                    User_id_pw = dao.logInsert();
                    System.out.println(yellow + "                         가입이 완료되었습니다" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    //화면전환이 너무 빨라서 2초간 멈춤.
                    System.out.println(purple + "                  올룸골룸에 접속하였습니다....(로딩중...)"+exit);
                    System.out.println(yellow+"\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⢇⠇⠅⠂⠐⠠⢑⠸⡸⣱⢟⣟⡿⡽⣇⢏⡆⢂⠄⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠢⠡⠁⢀⠈⠀⡂⡑⡸⡸⡽⡽⡽⡝⡎⡲⡩⢐⢰⢪⣗⡧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢔⠦⢄⡞⠌⡐⠀⠀⡀⠐⡐⢌⢜⡎⡇⡯⣫⢧⡣⡣⡂⢂⠕⣕⢵⢍⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⡎⡎⡞⡐⠀⠀⠂⠠⡀⡢⢱⣐⡇⣗⡽⡕⣗⣵⡵⣜⣄⠢⡱⣪⢇⢪⢪⢢⢢⢠⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢑⢵⢑⠠⡬⠢⢨⢤⡱⣵⡵⠓⣗⢷⡽⡚⢕⢕⣣⣳⢢⢓⢮⣫⢪⠪⣪⡳⡯⣯⣿⣽⣮\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⢐⢾⣻⠢⠀⠀⠀⠀⠀⠀⠀⠊⢆⠀⠌⡢⣡⡪⣼⡽⡊⠄⡯⡳⢽⣿⢿⣽⣻⢮⢇⡗⡕⣽⢰⢱⢱⢹⢽⡿⣾⣿⣿\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⢻⢮⡳⡡⠀⠀⠀⠀⠀⠀⠀⠈⢐⢐⠌⡪⢚⢱⠵⢪⢌⣞⣯⢿⣺⡻⣮⣞⡯⣟⢮⢺⢼⢮⢮⣪⣗⣿⣿⣿⣿⠿\n" +
                            "   ⠀⠀⠀⢀⡴⣶⠠⠀⠀⢟⡮⡲⡠⠀⠀⠀⠀⢀⢠⣐⢘⠸⡨⡢⣣⢫⠨⢀⠂⡪⡫⡷⡵⣽⣽⢽⣻⣯⢎⢗⣿⡿⡽⣷⡿⠛⠉⠉⠀⠀\n" +
                            "   ⠀⠀⠀⠘⢾⢽⢝⢔⠀⢙⣽⡺⡰⡀⠀⢀⢔⢕⢕⢜⡄⣂⡑⡕⢌⢚⠾⣦⡳⣼⡼⣿⢾⣻⣞⣗⣿⢯⡓⣽⣻⣽⣻⡯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⡀⠁⢿⣯⣗⡧⡒⣯⡯⣏⢮⢌⢌⡘⠐⡁⣦⣳⢅⢷⡹⣜⢄⠕⢕⢯⡳⣯⣿⣿⣟⡾⢝⣝⣜⡾⣫⡻⡾⣽⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⢀⢪⣰⡨⡀⣳⣿⣺⣗⣕⡯⣗⢯⣮⣻⢦⣡⣳⣳⡽⡢⠀⢯⢺⢵⡱⣑⢔⢽⡮⣷⢿⢷⡏⡞⣪⢪⡪⡧⣫⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⢳⣕⣯⣖⢼⣻⡿⣳⢯⣞⣯⣿⣺⣞⣿⡳⠛⠚⠉⠀⠀⠀⡗⢵⢝⡮⡏⡇⡏⡎⡇⡗⡽⡸⣸⢸⢼⢽⢵⣿⣿⣯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠠⠨⡀⡻⣺⣾⣿⡯⡯⡯⣫⡻⣯⡷⣟⠾⠑⠀⠀⠀⠀⠀⠀⠀⢸⢸⢸⢪⡺⡸⡜⣜⢼⢸⣪⣯⢮⣳⣽⣽⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀\n" +
                            "   ⢨⡳⣕⢹⣯⣿⣷⣟⣯⣯⢷⣕⡵⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠱⡱⡱⡕⡯⡾⡼⡮⣟⢯⣳⡳⡵⣯⣿⣻⣿⣿⣿⡗⠀⠀⠀⠀⠀\n" +
                            "   ⠐⡽⡾⠜⠈⠛⢻⣿⣷⣿⣽⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢮⢺⢜⢎⢗⢽⣪⣷⣿⢯⣿⣳⣯⣷⣿⣿⢷⣳⠀⠀⠀⠀⠀"+exit);
                    Thread.sleep(2000);
                    return User_id_pw;
                case 3:
                    // 관리자 여부 확인
                    System.out.println(green+"      회원정보는 관리자만 볼 수 있습니다. 관리자 로그인으로 넘어갑니다."+exit);
                    //관리자 계정으로 로그인
                    User_id_pw = Addao.Adminlogin();
                    System.out.println(yellow + "                회원정보 확인 페이지로 이동합니다.....(로딩중....)" + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    Thread.sleep(2000);
                    List<LoginInfoVo> list = dao.logsel();
                    dao.logSelectPrn(list);
                    System.out.println(red+"                       관리자 권한으로 접속하였습니다..."+exit);
                    System.out.println(yellow+"\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⢇⠇⠅⠂⠐⠠⢑⠸⡸⣱⢟⣟⡿⡽⣇⢏⡆⢂⠄⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠢⠡⠁⢀⠈⠀⡂⡑⡸⡸⡽⡽⡽⡝⡎⡲⡩⢐⢰⢪⣗⡧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢔⠦⢄⡞⠌⡐⠀⠀⡀⠐⡐⢌⢜⡎⡇⡯⣫⢧⡣⡣⡂⢂⠕⣕⢵⢍⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⡎⡎⡞⡐⠀⠀⠂⠠⡀⡢⢱⣐⡇⣗⡽⡕⣗⣵⡵⣜⣄⠢⡱⣪⢇⢪⢪⢢⢢⢠⠀⠀⠀\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢑⢵⢑⠠⡬⠢⢨⢤⡱⣵⡵⠓⣗⢷⡽⡚⢕⢕⣣⣳⢢⢓⢮⣫⢪⠪⣪⡳⡯⣯⣿⣽⣮\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⢐⢾⣻⠢⠀⠀⠀⠀⠀⠀⠀⠊⢆⠀⠌⡢⣡⡪⣼⡽⡊⠄⡯⡳⢽⣿⢿⣽⣻⢮⢇⡗⡕⣽⢰⢱⢱⢹⢽⡿⣾⣿⣿\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⠀⢻⢮⡳⡡⠀⠀⠀⠀⠀⠀⠀⠈⢐⢐⠌⡪⢚⢱⠵⢪⢌⣞⣯⢿⣺⡻⣮⣞⡯⣟⢮⢺⢼⢮⢮⣪⣗⣿⣿⣿⣿⠿\n" +
                            "   ⠀⠀⠀⢀⡴⣶⠠⠀⠀⢟⡮⡲⡠⠀⠀⠀⠀⢀⢠⣐⢘⠸⡨⡢⣣⢫⠨⢀⠂⡪⡫⡷⡵⣽⣽⢽⣻⣯⢎⢗⣿⡿⡽⣷⡿⠛⠉⠉⠀⠀\n" +
                            "   ⠀⠀⠀⠘⢾⢽⢝⢔⠀⢙⣽⡺⡰⡀⠀⢀⢔⢕⢕⢜⡄⣂⡑⡕⢌⢚⠾⣦⡳⣼⡼⣿⢾⣻⣞⣗⣿⢯⡓⣽⣻⣽⣻⡯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⠀⡀⠁⢿⣯⣗⡧⡒⣯⡯⣏⢮⢌⢌⡘⠐⡁⣦⣳⢅⢷⡹⣜⢄⠕⢕⢯⡳⣯⣿⣿⣟⡾⢝⣝⣜⡾⣫⡻⡾⣽⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⢀⢪⣰⡨⡀⣳⣿⣺⣗⣕⡯⣗⢯⣮⣻⢦⣡⣳⣳⡽⡢⠀⢯⢺⢵⡱⣑⢔⢽⡮⣷⢿⢷⡏⡞⣪⢪⡪⡧⣫⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠀⠀⢳⣕⣯⣖⢼⣻⡿⣳⢯⣞⣯⣿⣺⣞⣿⡳⠛⠚⠉⠀⠀⠀⡗⢵⢝⡮⡏⡇⡏⡎⡇⡗⡽⡸⣸⢸⢼⢽⢵⣿⣿⣯⠀⠀⠀⠀⠀⠀\n" +
                            "   ⠠⠨⡀⡻⣺⣾⣿⡯⡯⡯⣫⡻⣯⡷⣟⠾⠑⠀⠀⠀⠀⠀⠀⠀⢸⢸⢸⢪⡺⡸⡜⣜⢼⢸⣪⣯⢮⣳⣽⣽⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀\n" +
                            "   ⢨⡳⣕⢹⣯⣿⣷⣟⣯⣯⢷⣕⡵⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠱⡱⡱⡕⡯⡾⡼⡮⣟⢯⣳⡳⡵⣯⣿⣻⣿⣿⣿⡗⠀⠀⠀⠀⠀\n" +
                            "   ⠐⡽⡾⠜⠈⠛⢻⣿⣷⣿⣽⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢮⢺⢜⢎⢗⢽⣪⣷⣿⢯⣿⣳⣯⣷⣿⣿⢷⣳⠀⠀⠀⠀⠀"+exit);
                    Thread.sleep(2000);
                    return User_id_pw;
                case 4:
                    Thread.sleep(1000);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(red + "                         프로그램을 종료합니다." + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.exit(0);
                default:
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(red + "                         다시 번호를 입력해주세요." + exit);
                    System.out.println(blue + "========================================================================" + exit);
                    break;
            }
        }
    }
}

