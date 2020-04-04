package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.StudentReword;
import com.sdjzu.knowledgequiz.mapper.AnswerMapper;
import com.sdjzu.knowledgequiz.mapper.StudentRewordMapper;
import com.sdjzu.knowledgequiz.service.AnswerService;
import com.sdjzu.knowledgequiz.service.StudentRewordService;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.StudentRewordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRewordServiceImpl extends
        ServiceImpl<StudentRewordMapper, StudentReword> implements StudentRewordService {

    @Autowired
    StudentRewordMapper studentRewordMapper;
    @Override
    public IPage<StudentRewordVO> getStudentRewordVOByRewordId(Page<StudentRewordVO> page, String rewordId) {
        return studentRewordMapper.getStudentRewordVOByRewordId(page, rewordId);
    }
}