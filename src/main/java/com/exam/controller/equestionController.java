package com.exam.controller;

import com.exam.dao.EquestionDao;
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
public class equestionController {

    @Autowired
    EquestionDao equestionDao;
    @RequestMapping("/equs")
    public String list(Model model){
        Collection<equestion> equestions = equestionDao.getAll();
        System.out.println(equestions);
        model.addAttribute("equs", equestions);
        return "equ/list";
    }
    @GetMapping("/equ")
    public String toAddpage(){
        return "equ/add";
    }

    //添加
    @PostMapping("/equ")
    public String addEqu(equestion eques){
        EquestionDao.save(eques);
        return "redirect:/equs";
    }

    //去修改页面
    @GetMapping("/equ/{id}")
    public String toUpdateEqu(@PathVariable("id")Integer id, Model model){
        equestion eques = equestionDao.getequestionById(id);
        model.addAttribute("equ",eques);
        return "equ/update";
    }
    //更新
    @PostMapping("/updateEqu")
    public String updateEqu(equestion eques){
        EquestionDao.save(eques);
        return "redirect:/equs";
    }

    //删除
    @GetMapping("/delequ/{id}")
    public String deleteEqu(@PathVariable("id")int id){
        EquestionDao.delete(id);
        return "redirect:/equs";
    }
}
