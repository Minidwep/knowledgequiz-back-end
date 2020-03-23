package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.*;
import com.sdjzu.knowledgequiz.mapper.*;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
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
    public IPage<QuestionVO> selectQuestionVO(Page<QuestionVO> page, String account) {
        return questionMapper.getQuestionByAcc(page, account);
    }

    @Override
    public IPage<QuestionVO> selectQuestionVOByCourseId(Page<QuestionVO> page, int courseId) {
        return questionMapper.selectQuestionVOByCourseId(page,courseId);
    }
    @Override
    public IPage<QuestionVO> selectQuestionVOByCourseIdDown(Page<QuestionVO> page, int courseId) {
        return questionMapper.selectQuestionVOByCourseIdDown(page,courseId);
    }

}
