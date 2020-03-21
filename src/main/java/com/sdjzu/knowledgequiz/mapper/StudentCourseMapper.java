package com.sdjzu.knowledgequiz.mapper;

import com.sdjzu.knowledgequiz.entity.StudentCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    StudentCourse searchStuCourseByAccAndCid(@Param("account") String account, @Param("courseId") int courseId);

    void addStuCourse(@Param("studentCourse") StudentCourse studentCourse);

    List<StudentCourse> getStuCourse(@Param("account")String account);

    void delStuCourse(@Param("studentCourse") StudentCourse studentCourse);
}
