package com.sdjzu.knowledgequiz.mapper;

import com.sdjzu.knowledgequiz.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    Course searchByName(@Param("name") String name);
    List<Course> getAll();

    void addCourse(@Param("course") Course course);

    Course getById(@Param("id") int courseId);

    void updateCourse(@Param("course") Course course);


    void deleteCourse(@Param("id") int courseId);

    List<Course> getCourByKey(@Param("keyword") String keyword);
}
