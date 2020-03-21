package com.sdjzu.knowledgequiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String name;
    private String detail;

    //重写hashCode方法
    public int hashCode() {
        return this.name.hashCode();
    }

    //重写equals方法
    public boolean equals(Object obj) {
        if (!(obj instanceof Course)) return false;
        Course c = (Course) obj;
        return this.name.equals(c.name) ;
    }
}
