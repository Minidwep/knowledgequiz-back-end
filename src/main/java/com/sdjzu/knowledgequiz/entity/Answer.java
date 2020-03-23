package com.sdjzu.knowledgequiz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("answer")//@TableName中的值对应着表名
public class Answer {
    @TableId(type = IdType.AUTO)
    int id;
    int questionId;
    int star;
    String account;
    String detail;
    Date upTime;
}
