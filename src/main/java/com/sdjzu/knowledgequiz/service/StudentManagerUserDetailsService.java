package com.sdjzu.knowledgequiz.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjzu.knowledgequiz.entity.User;
import com.sdjzu.knowledgequiz.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentManagerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            List<SimpleGrantedAuthority> list = new ArrayList<>();
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("account", username);
            User user = userMapper.selectOne(queryWrapper);
            if(!user.getUserType().equals("")){
                for(String s : user.getUserType().split(" ")){
                    s = "ROLE_" + s;
                    list.add(new SimpleGrantedAuthority(s));        //由于不可能是空的(数据库中必须字段)
                    System.out.println(s);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPwd(), list);
        } catch (EmptyResultDataAccessException e) {
            log.debug("查询结果集为空:{}", username);
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
    }
}
