package com.exam.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class studentDao {

    private static String name;
    private static String id;
    private static Map <String,String>students=null;//从学号到姓名的映射
    static{
        students=new HashMap<String,String>();
        students.put("0001","张三");
        students.put("0002","李四");
        students.put("0003","王五");
        students.put("0004","刘六");
    }

    public boolean have(String id)
    {
       return students.containsKey(id);
    }
    public String getName(){return name;}
    public String getId(){return id;}
    public void  set(String tname)
    {
        name=tname;
        return ;
    }
    public void  setid(String tname)
    {
        id=tname;
        return ;
    }

    public String find(String key)
    {
        return students.get(key);
    }

}
