package com.sdjzu.knowledgequiz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExcel {
    String account;
    String name;
    String college;
    String courseInit;
}
