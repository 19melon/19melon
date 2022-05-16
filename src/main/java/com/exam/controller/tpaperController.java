package com.exam.controller;

import com.exam.dao.EquestionDao;
import com.exam.dao.sgradeDao;
import com.exam.dao.studentDao;
import com.exam.dao.tpaperDao;
import com.exam.pojo.tpaper;
import com.exam.pojo.equestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class tpaperController {

    @Autowired
    tpaperDao tpaperDao;
    @Autowired
    EquestionDao equestionDao;
    @Autowired
    studentDao studentdao;

    //展示
    @RequestMapping("/tpas")
    public String list(Model model){
        Collection<tpaper> tpapers = tpaperDao.getall();
        model.addAttribute("tpas",tpapers);
        return "tpa/list";
    }

    //增加
    @GetMapping("/tpa")
    public String toAddTest(Model model){
        Collection<equestion> equestions = equestionDao.getAll();
        model.addAttribute("equestions",equestions);
        return "tpa/addTpaper";
    }

    @PostMapping("/tpa")
    public String addTest(tpaper tpaper){
        //System.out.println("debug");
        tpaperDao.save(tpaper);
        return "redirect:/tpas";
    }

    //修改
    @GetMapping("/tpa/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        tpaper tpaper = tpaperDao.gettpaperById(id);
        model.addAttribute("tpa",tpaper);

        Collection<equestion> equestions = equestionDao.getAll();
        model.addAttribute("equestions",equestions);
        return "tpa/updateTpaper";
    }
    @PostMapping("/updatetpaper")
    public String updateT(tpaper tpaper){
        tpaperDao.save(tpaper);
        return "redirect:/tpas";
    }

    //删除
    @GetMapping("/delt/{id}")
    public String deleteT(@PathVariable("id")int id){
        tpaperDao.delete(id);
        return "redirect:/tpas";
    }

    @RequestMapping("/ttaps")
    public String llist(Model model){
        Collection<tpaper>  tpapers=  tpaperDao.getall();
        model.addAttribute("taps",tpapers);
        model.addAttribute("name",studentdao.getName());
        return "Student/work";
    }

}