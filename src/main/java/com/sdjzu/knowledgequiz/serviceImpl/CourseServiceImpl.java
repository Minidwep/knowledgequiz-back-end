package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.mapper.CourseMapper;
import com.sdjzu.knowledgequiz.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
//        1 查询数据中是否有该数据
        Course courseFlag = this.searchByName(course.getName());
        if(courseFlag == null){
            log.info("在课程表中插入课程"+course.getName());
             courseMapper.addCourse(course);
        } else {
            log.info("课程"+course.getName()+"已存在");

        }
    }

    @Override
    public Course searchByName(String name) {
        return courseMapper.searchByName(name);
    }



    @Override
    public void addCourseWithDetail(Course course) {
        Course courseFlag = this.searchByName(course.getName());
        if(courseFlag == null){
            log.info("在课程表中插入课程"+course.getName());
            courseMapper.addCourse(course);
        } else {
            course.setId(courseFlag.getId());
            courseMapper.updateCourse(course);
            log.info("课程"+course.getName()+"已更新");

        }
    }

    @Override
    public List<Course> getAll() {
        return courseMapper.getAll();
    }

    @Override
    public Course updateCourse(Course course) {
        Course course1 = courseMapper.getById(course.getId());
        if(course1 !=null){
            try {
                courseMapper.updateCourse(course);
                return course;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null ;
        }
        return null ;
    }

    @Override
    public Course searchById(String id) {
        return courseMapper.getById(Integer.parseInt(id));
    }

    @Override
    public boolean deleteCourse(String id) {
        Course course = courseMapper.getById(Integer.parseInt(id));
        if(course !=null){
            courseMapper.deleteCourse(Integer.parseInt(id));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Course> getCourByKey(String keyword) {
        return courseMapper.getCourByKey(keyword);
    }
}
