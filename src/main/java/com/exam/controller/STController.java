package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class STController {

    @RequestMapping("/student")
    public String student(){
        return "indexOfStudent";
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "indexOfTeacher";
    }
}
