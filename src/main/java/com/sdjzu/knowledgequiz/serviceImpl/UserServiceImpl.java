package com.sdjzu.knowledgequiz.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.entity.User;
import com.sdjzu.knowledgequiz.mapper.CourseMapper;
import com.sdjzu.knowledgequiz.mapper.QuestionMapper;
import com.sdjzu.knowledgequiz.mapper.UserMapper;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
