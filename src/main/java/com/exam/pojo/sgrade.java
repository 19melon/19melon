package com.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//成绩表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class sgrade {
    private String name;//学生姓名
    private String Sid;//学号
    private Integer id;//试卷号
    private Integer grade;//成绩
   /* public int getgrade() {
        return id;
    }
    public void setgrade(int grade) {
        this.grade = grade;
    }*/
    public void output(){
        System.out.println(name+" "+Sid+" "+id+" "+grade);
    }

}

