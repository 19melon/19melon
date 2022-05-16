package com.exam.controller;

import com.exam.dao.EquestionDao;
import com.exam.dao.sgradeDao;
import com.exam.dao.studentDao;
import com.exam.dao.tpaperDao;
import com.exam.pojo.equestion;
import com.exam.pojo.sgrade;
import com.exam.pojo.tpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class submitController {

    @Autowired
    tpaperDao tpaperdao;
    @Autowired
    studentDao studentdao;
    @Autowired
    sgradeDao sgradedao;

    private Integer Grade=0;
    @RequestMapping ("/Grade/{ID}")
    public String list(@PathVariable("ID") Integer id, @RequestParam("ans1") String ans1, @RequestParam("ans2") String ans2, @RequestParam("ans3") String ans3, Model model ){
        tpaper tpa=tpaperdao.gettpaperById(id);
        Collection<equestion>  equs=  tpa.getAll();
        Collection<String> anss=new ArrayList<String>();
        anss.add(ans1);anss.add(ans2);anss.add(ans3);

        Grade=0;
        if(tpa.getQ1().getAnswer().equals(ans1))Grade++;
        if(tpa.getQ2().getAnswer().equals(ans2))Grade++;
        if(tpa.getQ3().getAnswer().equals(ans3))Grade++;


        model.addAttribute("equs",equs);
        model.addAttribute("anss",anss);
        model.addAttribute("score",Grade);
        model.addAttribute("name",studentdao.getName());

        sgradedao.add(new sgrade(studentdao.getName(), studentdao.getId(),id,Grade));
        sgradedao.output(sgradedao.initid-1);
        return "Student/show";
    }
}
