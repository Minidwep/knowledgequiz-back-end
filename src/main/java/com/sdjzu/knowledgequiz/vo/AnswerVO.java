package com.sdjzu.knowledgequiz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerVO {

    int id;
    int questionId;
    int star;
    String account;
    String detail;
    Date upTime;
    String username;
    String title;
}
