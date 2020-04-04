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
@TableName("student_reword")//@TableName中的值对应着表名
public class StudentReword {
    @TableId(type = IdType.AUTO)
    int id;
    int answerId;
    int rewordId;
    String teaAccount;
    String stuAccount;
}
