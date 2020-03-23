package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.User;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService extends IService<Answer> {
    List<AnswerVO> getAnswerVO(int questionId);
}
