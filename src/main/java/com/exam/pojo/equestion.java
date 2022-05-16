package com.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//题库表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class equestion {
    private Integer id;
    private String stem;
    private String answer;
    private String subject;
}

