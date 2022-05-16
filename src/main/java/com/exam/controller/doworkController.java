package com.exam.controller;

import com.exam.dao.studentDao;
import com.exam.dao.tpaperDao;
import com.exam.pojo.equestion;
import com.exam.pojo.tpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collection;

@Controller
public class doworkController {


    @Autowired
    tpaperDao tpaperdao;
    @Autowired
    studentDao studentdao;

    @RequestMapping("/dowork/{ID}")
    public String list(@PathVariable("ID") Integer id, Model model){
        tpaper tpa=tpaperdao.gettpaperById(id);
        Collection<equestion>  equs=  tpa.getAll();
        model.addAttribute("equs",equs);
        model.addAttribute("nowId",id);
        model.addAttribute("name",studentdao.getName());
        return "Student/do";
    }
}
