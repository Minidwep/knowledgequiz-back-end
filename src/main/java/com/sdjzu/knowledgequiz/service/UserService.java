package com.sdjzu.knowledgequiz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {
}
