package com.sdjzu.knowledgequiz.mapper;

import com.sdjzu.knowledgequiz.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
    Student searchByAcc(@Param("account") String account);
    void addStudent(@Param("student") Student student);

    void updateStudent(@Param("student")Student student);

    void deleteStudent(@Param("account")String account);

    List<Student> getStuByKey(@Param("keyword")String keyword);
}
