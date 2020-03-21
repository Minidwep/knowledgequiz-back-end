package com.sdjzu.knowledgequiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
   private int id;
   private String account;
   private String pwd;
   private String name;
   private String research;
   private String title;
   private String acaDegree;
   private String[] courseInit;



    public Teacher(String account, String pwd, String name, String research, String title, String acaDegree, String courseInit[]) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.research = research;
        this.title = title;
        this.acaDegree = acaDegree;
        this.courseInit = courseInit;
    }

}
