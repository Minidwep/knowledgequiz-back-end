package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.TeacherCourse;
import com.sdjzu.knowledgequiz.mapper.CourseMapper;
import com.sdjzu.knowledgequiz.mapper.TeacherCourseMapper;
import com.sdjzu.knowledgequiz.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Resource
    TeacherCourseMapper teacherCourseMapper;

    @Resource
    CourseMapper courseMapper;

    @Override
    public void addTeaCourse(TeacherCourse teacherCourse) {
        TeacherCourse teacherCourseFlag =
                this.searchTeaCourseByAccAndCid(teacherCourse.getAccount(), teacherCourse.getCourseId());
        if(teacherCourseFlag == null){
            log.info("插入授课信息-教师编号"+teacherCourse.getAccount()+"课程号"+teacherCourse.getCourseId());
            teacherCourseMapper.addTeaCourse(teacherCourse);
        } else {
            log.info("授课信息"+teacherCourse.getAccount()+"课程号"+teacherCourse.getCourseId()+"已存在");
        }
    }

    @Override
    public TeacherCourse searchTeaCourseByAccAndCid(String account, int courseId) {
        return teacherCourseMapper.searchTeaCourseByAccAndCid(account,courseId);
    }

    @Override
    public List<Course> getTeaCourse(String account) {
        List<TeacherCourse> teaCourse = teacherCourseMapper.getTeaCourse(account);
        List<Course> list = new ArrayList<>();
        for (TeacherCourse teacherCourse : teaCourse) {
            Course course = courseMapper.getById(teacherCourse.getCourseId());
            list.add(course);
        }
        return list;
    }

    @Override
    public void delTeaCourse(TeacherCourse teacherCourse) {

        teacherCourseMapper.delTeaCourse(teacherCourse);
    }
}
