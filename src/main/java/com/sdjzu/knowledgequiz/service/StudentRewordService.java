package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.StudentReword;
import com.sdjzu.knowledgequiz.vo.StudentRewordVO;
import org.springframework.stereotype.Service;
@Service
public interface StudentRewordService extends IService<StudentReword> {

    IPage<StudentRewordVO> getStudentRewordVOByRewordId(Page<StudentRewordVO> page, String answerId);
}
