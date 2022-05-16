package com.exam.dao;

import com.exam.pojo.sgrade;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository

public class sgradeDao {
    //模拟数据库中的数据
    private static Map<Integer, sgrade> sgrades=null;
    //  @Autowired
    static{
        sgrades = new HashMap<Integer, sgrade>();//创建一个成绩表
        sgrades.put(1, new sgrade("张三","0001",1,1));
        sgrades.put(2, new sgrade("李四","0002",2,2));
        sgrades.put(3, new sgrade("王五","0003",3,3));
        sgrades.put(4, new sgrade("刘六","0004",1,1));
    }

    public static  Integer initid=5;
    public void add( sgrade t) {
        sgrades.put(initid++,t);
    }
    //获得所有学生信息
    public Collection<sgrade> getAll(){
        return sgrades.values();
    }

    public void output(Integer key){
        sgrades.get(key).output();
    }

    //通过id得到成绩
    public sgrade getsgradeById(String Sid){
        return  sgrades.get(Sid);
    }

    public static void delete(Integer id){
        sgrades.remove(id);
    }

}
