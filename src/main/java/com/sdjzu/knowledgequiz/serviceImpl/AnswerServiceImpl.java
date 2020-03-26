package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.User;
import com.sdjzu.knowledgequiz.mapper.AnswerMapper;
import com.sdjzu.knowledgequiz.mapper.UserMapper;
import com.sdjzu.knowledgequiz.service.AnswerService;
import com.sdjzu.knowledgequiz.service.UserService;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
    @Autowired
    AnswerMapper answerMapper;
    @Override
    public List<AnswerVO> getAnswerVO(int questionId) {
        return answerMapper.getAnswerVO(questionId);
    }

    @Override
    public List<AnswerVO> getAnswerVOByAccount(String account) {
        return answerMapper.getAnswerVOByAccount(account);
    }
}