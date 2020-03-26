package com.sdjzu.knowledgequiz.controller;

import java.util.Objects;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjzu.knowledgequiz.conifg.JwtTokenUtil;
import com.sdjzu.knowledgequiz.entity.User;
import com.sdjzu.knowledgequiz.pojo.JwtRequest;
import com.sdjzu.knowledgequiz.pojo.JwtResponse;
import com.sdjzu.knowledgequiz.service.StudentManagerUserDetailsService;
import com.sdjzu.knowledgequiz.service.UserService;
import com.sdjzu.knowledgequiz.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private StudentManagerUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Msg createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", authenticationRequest.getUsername());
        User user = userService.getOne(queryWrapper);
        return Msg.success().add("token",new JwtResponse(token)).add("user",user);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}