package com.sdjzu.knowledgequiz.service;

import com.sdjzu.knowledgequiz.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void addStudent(Student student);
    Student searchByAcc(String account);
    List<Student> getAll();

    Student updateStudent(Student student);

    boolean deleteStudent(String account);

    List<Student> getStuByKey(String keyword);
}
