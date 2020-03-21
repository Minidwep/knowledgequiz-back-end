package com.sdjzu.knowledgequiz.service;

import com.sdjzu.knowledgequiz.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    void addTeacher(Teacher teacher);
    Teacher searchByAcc(String account);

    List<Teacher> getAll();

    Teacher updateTeacher(Teacher teacher);

    boolean deleteTeacher(String account);

    List<Teacher> getTeaByKey(String keyword);
}
