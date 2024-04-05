package com.kh.Olumgollum_Project.Controller;

import com.kh.Olumgollum_Project.LoginInfo.LoginInfoDao;
import com.kh.Olumgollum_Project.LoginInfo.LoginVo;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoDao;
import com.kh.Olumgollum_Project.RoomInfo.RoomInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/OlumGollum")
public class OlumGollumController {
    List<String> User_id_pw = new ArrayList<>();
    @GetMapping("/LoginPage")
    public String LoginPage(Model model){
        model.addAttribute("ID_PASSWORD",new LoginVo());
        return "OlumGollum_Olum/LoginPage";
    }
    // 일반 사용자의 로그인
    @PostMapping("/LoginPage")
    public String SetLogin(@ModelAttribute("ID_PASSWORD")LoginVo User) throws InterruptedException {
       LoginInfoDao LID = new LoginInfoDao();
       LoginVo User_id= LID.LoginUserIdEx(User);
       User_id_pw = LID.login(User_id);
       return "OlumGollum_Olum/OlumGollumMainPage";
    }
    //User 메인 페이지
    @GetMapping("/MainPage")
    public String MainPage(Model model){

        return "OlumGollum_Olum/OlumGollumMainPage";
    }
    // 방 올리기 페이지
    //================================================================================================
    @GetMapping("/RoomInsert")
    public String OlumPage(Model model){
        model.addAttribute("RoomInfoVos",new RoomInfoVo());
        return "OlumGollum_Olum/RoomInfoOlumUp";

    }
    @PostMapping("/RoomInsert")
    public String OlumDBinsert(@ModelAttribute("RoomInfoVos")RoomInfoVo RIV){
        RoomInfoDao dao = new RoomInfoDao();
        dao.RoomInsert(RIV);
        return "OlumGollum_Olum/RoomInfoOlumUpRst";
    }
    //================================================================================================
    //관리자 계정의 MainPage
    @GetMapping("/AdminMainPage")
    public String AdminMainPage(Model model){
        return "OlumGollum_Olum/AdminOlumGollumMainPage";
    }
}
