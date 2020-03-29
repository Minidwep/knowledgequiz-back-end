package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.Question;

import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService extends IService<Question> {
    IPage<QuestionVO> selectQuestionVOByTea(Page<QuestionVO> page, String account);
    IPage<QuestionVO> selectQuestionVOByStu(Page<QuestionVO> page, String account);

    IPage<QuestionVO> selectQuestionVOByCourseId(Page<QuestionVO> page, int courseId);

    IPage<QuestionVO> selectQuestionVOByCourseIdDown(Page<QuestionVO> page, int courseId);

    QuestionVO selectQuestionVOByQId(int questionId);

    List<QuestionVO> selectQuestionVOByKeyword(String keyword);
}
