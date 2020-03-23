package com.sdjzu.knowledgequiz.vo;

import com.alibaba.druid.filter.AutoLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVO {
    int id;
    String title;
    String detail;
    String account;
    int courseId;
    Date upTime;
    Date nextTime;
    Date downTime;
    int status;
    int star;
    String userName;
    String courseName;
}
