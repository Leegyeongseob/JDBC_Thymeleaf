package com.kh.Olumgollum_Project.MyPage;



import com.kh.Olumgollum_Project.RoomInfo.OlumGollumPage;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class MyPage {
    public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36;m" ;
    public static final String white     = "\u001B[37m" ;
    public static final String exit     = "\u001B[0m" ;
    //우리 아이디
    public void MyPageFunc(List<String> id_pw) throws InterruptedException, ParseException {
        Scanner sc = new Scanner(System.in);
        MyPageDao dao = new MyPageDao();
        OlumGollumPage RIM = new OlumGollumPage();
        while (true) {
            //마이페이지의 메인화면을 뿌려주는 함수
            dao.mprn();
            int num = sc.nextInt();
            System.out.println(blue + "========================================================================" + exit);
            System.out.println(purple+"                      이동중입니다. 잠시만 기다려주세요..."+exit);
            Thread.sleep(2000);
            switch (num) {
                case 1:
                    // 개인정보 수정
                    dao.Userupdate(id_pw);
                    break;
                case 2:
                    // 찜목록
                    List<RoomInfoVo> list = dao.Love_list(id_pw);
                    //찜 리스트 출력
                    dao.loveprn(list);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(green+"    [1]찜 삭제하기 [2]메인페이지로 [3] 나가기 "+exit);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.print(blue + "|" + exit + "     " + yellow + "|   번호입력   |" + exit + "     " + blue + "|     " + exit);
                    int num1 = sc.nextInt();
                    switch (num1) {
                        case 1:
                            // 찜 삭제
                            dao.Love_delete(id_pw);
                            break;
                        case 2:
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
                            System.out.println("     메인페이지로 이동합니다....");
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println(blue + "========================================================================" + exit);
                            System.out.println(green+"    다시 입력해주세요."+exit);
                            continue;
                    }
                    break;
                case 3:
                    //올룸 목록
                    List<RoomInfoVo> list2 = dao.olume_list(id_pw);
                    // 올룸 리스트 출력
                    dao.loveprn(list2);
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(green+"   [1]올룸 수정하기 [2]올룸 삭제하기 [3]메인페이지로 [4]나가기"+exit);
                    int num2 = sc.nextInt();
                    switch (num2) {
                        case 1:
                            //올룸 수정하기
                            dao.RoomUpdate();
                            break;
                        case 2:
                            //올룸 삭제하기
                            dao.RoomDelete();
                            break;
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
                            System.out.println("     메인페이지로 이동합니다....");
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println(blue + "========================================================================" + exit);
                            System.out.println(green+"    다시 입력해주세요."+exit);
                            continue;
                    }
                    break;
                case 4:
                    dao.UserDelete(id_pw);
                case 5:
                    System.exit(0);
                default:
                    System.out.println(blue + "========================================================================" + exit);
                    System.out.println(green+"    다시 입력해주세요."+exit);
                    continue;
            }
            break;
        }
    }
}
