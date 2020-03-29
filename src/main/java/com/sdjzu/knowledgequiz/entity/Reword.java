package com.sdjzu.knowledgequiz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reword")//@TableName中的值对应着表名
public class Reword {
    @TableId(type = IdType.AUTO)
    int id;
    String account;
    String detail;
    String courseId;
}
