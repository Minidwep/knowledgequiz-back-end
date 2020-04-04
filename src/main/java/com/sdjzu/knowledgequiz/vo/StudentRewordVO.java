package com.sdjzu.knowledgequiz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRewordVO {

    int id;
    int answerId;
    int rewordId;
    String teaAccount;
    String stuAccount;
    String stuName;
    String teaName;
}
