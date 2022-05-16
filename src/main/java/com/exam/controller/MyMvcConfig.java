package com.exam.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/mmain.html").setViewName("Student/homework.html");
        registry.addViewController("/sstudent.html").setViewName("indexOfStudent.html");
        registry.addViewController("/tteacher.html").setViewName("indexOfTeacher.html");
    }

}
