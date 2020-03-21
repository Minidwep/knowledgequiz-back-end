package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.entity.Teacher;
import com.sdjzu.knowledgequiz.mapper.TeacherMapper;
import com.sdjzu.knowledgequiz.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public void addTeacher(Teacher teacher) {
        Teacher teacherFlag = this.searchByAcc(teacher.getAccount());
        if (teacherFlag == null){
            log.info("插入教师"+"编号"+teacher.getAccount());
           teacherMapper.addTeacher(teacher);
        } else {
            log.info("教师"+teacher.getAccount()+"已存在");


        }
    }

    @Override
    public Teacher searchByAcc(String account) {

        return teacherMapper.searchByAcc(account);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        Teacher teacher1 = this.searchByAcc(teacher.getAccount());
        if(teacher1 !=null){
            try {
                teacherMapper.updateTeacher(teacher);
                return teacher;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null ;
        }
        return null ;
    }

    @Override
    public boolean deleteTeacher(String account) {
        Teacher teacher = this.searchByAcc(account);
        if(teacher !=null){
            teacherMapper.deleteTeacher(account);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Teacher> getTeaByKey(String keyword) {
        return teacherMapper.getTeaByKey(keyword);
    }
}
