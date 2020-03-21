package com.sdjzu.knowledgequiz.mapper;

import com.sdjzu.knowledgequiz.entity.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherCourseMapper {

    TeacherCourse searchTeaCourseByAccAndCid(@Param("account") String account,@Param("courseId")int courseId );

    void addTeaCourse(@Param("teacherCourse") TeacherCourse teacherCourse);

    List<TeacherCourse> getTeaCourse(@Param("account") String account);

    void delTeaCourse(@Param("teacherCourse") TeacherCourse teacherCourse);
}
