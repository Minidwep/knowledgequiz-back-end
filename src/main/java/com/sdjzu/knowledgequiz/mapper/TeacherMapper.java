package com.sdjzu.knowledgequiz.mapper;

import com.sdjzu.knowledgequiz.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    void addTeacher(@Param("teacher") Teacher teacher);
    Teacher searchByAcc(@Param("account") String account);

    List<Teacher> getAll();

    void updateTeacher(@Param("teacher") Teacher teacher);

    void deleteTeacher(@Param("account")String account);

    List<Teacher> getTeaByKey(@Param("keyword") String keyword);
}
