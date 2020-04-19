package com.sdjzu.knowledgequiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper extends BaseMapper<Answer> {
    List<AnswerVO> getAnswerVO(@Param("questionId") int questionId);

    IPage<AnswerVO> getAnswerVOByAccount(@Param("page")Page<AnswerVO> page,@Param("account") String account);

    AnswerVO getAnswerVoById(@Param("id") int id);
}
