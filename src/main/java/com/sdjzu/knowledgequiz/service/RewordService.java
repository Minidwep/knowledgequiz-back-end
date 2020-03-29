package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.Reword;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RewordService extends IService<Reword> {

}
