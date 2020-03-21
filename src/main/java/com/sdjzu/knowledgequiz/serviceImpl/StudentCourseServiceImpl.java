package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.StudentCourse;
import com.sdjzu.knowledgequiz.mapper.CourseMapper;
import com.sdjzu.knowledgequiz.mapper.StudentCourseMapper;
import com.sdjzu.knowledgequiz.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {
    @Resource
    StudentCourseMapper studentCourseMapper;

    @Resource
    CourseMapper courseMapper;
    @Override
    public void addStuCourse(StudentCourse studentCourse) {
        StudentCourse studentCourseFlag = this.searchStuCourseByAccAndCid(studentCourse.getAccount(), studentCourse.getCourseId());
        if(studentCourseFlag == null ){
            log.info("插入选课信息-学生编号"+studentCourse.getAccount()+"课程号"+studentCourse.getCourseId());
            studentCourseMapper.addStuCourse(studentCourse);
        }else{
            log.info("选课信息-学生编号"+studentCourse.getAccount()+"课程号"+studentCourse.getCourseId()+"已存在");
        }
    }

    @Override
    public StudentCourse searchStuCourseByAccAndCid(String account, int courseId) {
        return studentCourseMapper.searchStuCourseByAccAndCid(account, courseId);
    }

    @Override
    public List<Course> getStuCourse(String account) {
        List<StudentCourse> stuCourse = studentCourseMapper.getStuCourse(account);
        List<Course> list = new ArrayList<>();
        for (StudentCourse studentCourse : stuCourse) {
            Course course = courseMapper.getById(studentCourse.getCourseId());
            list.add(course);
        }
        return list;
    }

    @Override
    public void delStuCourse(StudentCourse studentCourse) {
        studentCourseMapper.delStuCourse(studentCourse);
    }
}
