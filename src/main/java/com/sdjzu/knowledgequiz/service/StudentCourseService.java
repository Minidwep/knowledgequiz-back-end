package com.sdjzu.knowledgequiz.service;

import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.StudentCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseService {
    void addStuCourse(StudentCourse studentCourse);

    StudentCourse searchStuCourseByAccAndCid(String account,int courseId);

    List<Course> getStuCourse(String account);

    void delStuCourse(StudentCourse studentCourse);
}
