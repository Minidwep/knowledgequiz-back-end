package com.sdjzu.knowledgequiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.StudentReword;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.StudentRewordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentRewordMapper extends BaseMapper<StudentReword> {

    IPage<StudentRewordVO> getStudentRewordVOByRewordId(@Param("page")Page<StudentRewordVO> page, @Param("rewordId") String rewordId);
}
