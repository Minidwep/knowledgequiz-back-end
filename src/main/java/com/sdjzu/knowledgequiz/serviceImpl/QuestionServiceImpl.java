package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.*;
import com.sdjzu.knowledgequiz.mapper.*;
import com.sdjzu.knowledgequiz.pojo.IPagePojo;
import com.sdjzu.knowledgequiz.pojo.QuestionPojo;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public IPagePojo questionList(int pn, QueryWrapper queryWrapper) {
        Page<Question> page = new Page<>(pn,5);  // 查询第n页，每页返回5条
        IPage<Question> iPage = questionMapper.selectPage(page,queryWrapper);
//        List<Question> questions =  questionMapper.selectList(queryWrapper);
        List<Question> records = iPage.getRecords();
        List<QuestionPojo> questionPojoList =  new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();

        for (Question question : records) {
            QuestionPojo questionPojo = new QuestionPojo();
            questionPojo.setQuestion(question);
//            通过课程号查询课程名
            Course course = courseMapper.getById(questionPojo.getQuestion().getCourseId());
//            通过账号查询用户类型
            QueryWrapper<User> query1 = new QueryWrapper<>();
            query1.eq("account", questionPojo.getQuestion().getAccount());
            User user = userMapper.selectOne(query1);
            System.out.println("user = "+user.toString());
//            通过账号和用户类型确定用户名
            String userType = user.getUserType();
            String username = "";
            if(userType.equals("1")){
                Teacher teacher = teacherMapper.searchByAcc(questionPojo.getQuestion().getAccount());
                username = teacher.getName();
            } else {
                Student student = studentMapper.searchByAcc(questionPojo.getQuestion().getAccount());
                username = student.getName();
            }
            questionPojo.setUserName(username);
            questionPojo.setCourseName(course.getName());
            questionPojoList.add(questionPojo);
        }

        return IPagePojo.init().add("iPage",iPage).add("questionPojoList",questionPojoList);
    }
}
