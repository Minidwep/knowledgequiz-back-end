package com.sdjzu.knowledgequiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String account;
    String name;
    String pwd;
    String college;
    String[] courseInit;
    String classes;
    public Student(String account, String name, String pwd, String college, String[] courseInit,String classes) {
        this.account = account;
        this.name = name;
        this.pwd = pwd;
        this.college = college;
        this.courseInit = courseInit;
        this.classes = classes;
    }
}
