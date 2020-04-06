package com.sdjzu.knowledgequiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionMapper extends BaseMapper<Question> {
    IPage<QuestionVO> getQuestionByAcc(@Param("page") Page<QuestionVO> page, @Param("account") String account);

    IPage<QuestionVO> getQuestionList(@Param("page") Page<QuestionVO> page);

    IPage<QuestionVO> getQuestionByStuAcc(@Param("page") Page<QuestionVO> page, @Param("account") String account);

    IPage<QuestionVO> selectQuestionVOByCourseId(@Param("page") Page<QuestionVO> page,@Param("courseId") int courseId);

    IPage<QuestionVO> selectQuestionVOByCourseIdDown(@Param("page")Page<QuestionVO> page,@Param("courseId") int courseId);

    QuestionVO selectQuestionVOByQId(@Param("questionId")int questionId);

    List<QuestionVO> selectQuestionVOByKey(@Param("keyword")String keyword);

    List<QuestionVO> selectQuestionVOByKeyAndCourse(@Param("keyword")String keyword,@Param("courseId") int courseId);
    List<QuestionVO> selectQuestionVOHaveAnswerByKey(@Param("keyword")String keyword,@Param("courseId") int courseId);
    List<QuestionVO> selectQuestionVOHaveStarByKey(@Param("keyword")String keyword,@Param("courseId") int courseId);

    IPage<QuestionVO> selectQuestionVOByKeywordAndIpage(@Param("page")Page<QuestionVO> page,@Param("keyword")String keyword);

}

