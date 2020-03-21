package com.sdjzu.knowledgequiz.service;

import com.sdjzu.knowledgequiz.entity.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    Course searchByName(String name);

    void addCourseWithDetail(Course course);

    List<Course> getAll();

    Course updateCourse(Course course);

    boolean deleteCourse(String id);

    List<Course> getCourByKey(String keyword);

    Course searchById(String id);
}
