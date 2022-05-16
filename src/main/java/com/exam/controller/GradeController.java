package com.exam.controller;

import com.exam.dao.EquestionDao;
import com.exam.dao.sgradeDao;
import com.exam.pojo.sgrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class GradeController {
    @Autowired
    sgradeDao sgradeDao;

    @RequestMapping("/sgds")
    public String list(Model model) {
        Collection<sgrade> sgrades = sgradeDao.getAll();
        model.addAttribute("sgds", sgrades);
        return "sgd/list";
    }

    @GetMapping ("/ssgd")
    public String sgd(){
        return "sgd/add";
    }


    //删除
    @RequestMapping ("/delsgd/{id}")
    public String deleteSgd(@PathVariable("id") int id) {
        sgradeDao.delete(id);
        return "redirect:/sgds";
    }
}