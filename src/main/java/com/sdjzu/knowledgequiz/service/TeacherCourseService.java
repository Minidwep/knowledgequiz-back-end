package com.sdjzu.knowledgequiz.service;

import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.TeacherCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherCourseService {
    void addTeaCourse(TeacherCourse teacherCourse);

    TeacherCourse searchTeaCourseByAccAndCid(String account,int courseId);

    List<Course> getTeaCourse(String account);

    void delTeaCourse(TeacherCourse teacherCourse);


}
