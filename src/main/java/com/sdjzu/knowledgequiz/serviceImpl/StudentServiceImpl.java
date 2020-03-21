package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.entity.Student;
import com.sdjzu.knowledgequiz.mapper.StudentMapper;
import com.sdjzu.knowledgequiz.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        Student studentFlag = this.searchByAcc(student.getAccount());
        if(studentFlag == null ){
            log.info("添加学生信息"+student.getName()+student.getAccount());
            studentMapper.addStudent(student);
        }else {
            log.info("学生信息"+student.getName()+student.getAccount()+"已存在");
        }
    }

    @Override
    public Student searchByAcc(String account) {
        return studentMapper.searchByAcc(account);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = this.searchByAcc(student.getAccount());
        if(student1 !=null){
            try {
                studentMapper.updateStudent(student);
                return student;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null ;
        }
        return null ;
    }

    @Override
    public boolean deleteStudent(String account) {
        Student student = this.searchByAcc(account);
        if(student !=null){
            studentMapper.deleteStudent(account);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Student> getStuByKey(String keyword) {
        return studentMapper.getStuByKey(keyword);
    }

}
