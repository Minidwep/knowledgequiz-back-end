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
@TableName("question")//@TableName中的值对应着表名
public class Question {
    @TableId(type = IdType.AUTO)
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

}
