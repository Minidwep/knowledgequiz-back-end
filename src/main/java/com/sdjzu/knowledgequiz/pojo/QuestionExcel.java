package com.sdjzu.knowledgequiz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class QuestionExcel {
    String userName;
    String courseName;
    String title;
    String detail;

}
