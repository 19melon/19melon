package com.exam.controller;

import com.exam.dao.studentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    studentDao studentdao;


    @RequestMapping("/teacher/login")
    public String login1(@RequestParam("username") String username, @RequestParam("password") String password,
                         Model model, HttpSession session){
        //具体的业务
        if( !StringUtils.isEmpty(username)   &&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误");
            return "indexOfTeacher";
        }
        //return "OK";
    }

    @RequestMapping("/student/login")
    public String login2(@RequestParam("username") String username, @RequestParam("password") String password,
                         Model model, HttpSession session){
        //具体的业务
        if(studentdao.have(username) &&"123".equals(password)){
            session.setAttribute("loginUser",username);
            studentdao.set( studentdao.find(username));
            studentdao.setid(username);
            model.addAttribute("name",studentdao.getName());
            return "Student/homework.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误");
            return "indexOfStudent";
        }
    }

}
