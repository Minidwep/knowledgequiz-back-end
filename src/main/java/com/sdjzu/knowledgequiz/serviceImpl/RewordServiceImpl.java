package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.Reword;
import com.sdjzu.knowledgequiz.mapper.AnswerMapper;
import com.sdjzu.knowledgequiz.mapper.RewordMapper;
import com.sdjzu.knowledgequiz.service.AnswerService;
import com.sdjzu.knowledgequiz.service.RewordService;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RewordServiceImpl extends ServiceImpl<RewordMapper, Reword> implements RewordService {
}
