package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.pojo.IPagePojo;
import com.sdjzu.knowledgequiz.pojo.QuestionPojo;
import com.sdjzu.knowledgequiz.util.Msg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService extends IService<Question> {
    IPagePojo questionList(int pn , QueryWrapper queryWrapper);
}
