package com.exam.dao;

import com.exam.pojo.equestion;
import com.exam.pojo.tpaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class tpaperDao {
    private static Map<Integer,tpaper> tpapers = null;
    @Autowired
    private EquestionDao equestionDao;

    static{
        tpapers = new HashMap<Integer,tpaper>();

        tpapers.put(1,new tpaper(01,"测试1",new equestion(1,"1+1=","2","数学"),new equestion(2,"2+2=","4","数学"),new equestion(3,"3+3=","6","数学")));
    }

    private static Integer initId = 2;
    //往考卷添加题目
    public void save(tpaper tpaper){
        if(tpaper.getId()==null){
            tpaper.setId(initId++);
        }


        tpaper.setQ1(equestionDao.getequestionById(tpaper.getQ1().getId()));
        tpaper.setQ2(equestionDao.getequestionById(tpaper.getQ2().getId()));
        tpaper.setQ3(equestionDao.getequestionById(tpaper.getQ3().getId()));
        tpapers.put(tpaper.getId(),tpaper);
    }
    //展示考卷
    public Collection<tpaper> getall(){
        return tpapers.values();
    }
    //查找题目
    public tpaper gettpaperById(Integer id){
        return tpapers.get(id);
    }
    //删除考卷某题目
    public void delete(Integer id){
        tpapers.remove(id);
    }
}
