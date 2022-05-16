package com.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

//题库表
@Data
@NoArgsConstructor
public class tpaper {
    private Integer id;
    private String name;
    private equestion q1;
    private equestion q2;
    private equestion q3;

    public tpaper(Integer id, String name, equestion q1, equestion q2, equestion q3){
        this.id = id;
        this.name = name;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<equestion> getAll(){
        Collection res=new ArrayList<equestion>();

        res.add(q1);
        res.add(q2);
        res.add(q3);
        return res;
    }
}