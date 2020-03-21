package com.sdjzu.knowledgequiz.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.entity.Teacher;
import com.sdjzu.knowledgequiz.pojo.IPagePojo;
import com.sdjzu.knowledgequiz.pojo.QuestionPojo;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.service.TeacherCourseService;
import com.sdjzu.knowledgequiz.util.FileUtil;
import com.sdjzu.knowledgequiz.util.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Autowired
    QuestionService questionService;

    @Autowired
    TeacherCourseService teacherCourseService;

    @Value("${file.path}")
    private String  imgPath;

    @PostMapping("/question")
    public Msg saveQuestion(@RequestBody Question question){
        question.setUpTime(new Date());
        boolean save = questionService.save(question);
        if(save)
            return Msg.success();
        else
            return Msg.fail();
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public Msg upload(@RequestParam("file") MultipartFile file) {

        String type = file.getContentType().split("/")[1];
        System.out.println(type);
        String imgName = IdUtil.simpleUUID()+"."+type;
        FileUtil.upload(file, imgPath, imgName);
        return Msg.success().add("url","images/"+imgName);
    }

    @GetMapping("/teaCourse/{account}")
    public Msg getTeaCourse(@PathVariable("account") String account){
        List<Course> teaCourseList = teacherCourseService.getTeaCourse(account);
        if(teaCourseList != null)
            return Msg.success().add("courseList",teaCourseList);
        else
            return Msg.fail();
    }
    @GetMapping("/questionList/{account}/{pn}")
    public Msg getQuestionList(@PathVariable("account") String account,@PathVariable("pn") Integer pn){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account).orderByDesc("up_time");
        IPagePojo iPagePojo = questionService.questionList(pn, queryWrapper);
        return Msg.success().add("pageInfo", iPagePojo);
    }



}
