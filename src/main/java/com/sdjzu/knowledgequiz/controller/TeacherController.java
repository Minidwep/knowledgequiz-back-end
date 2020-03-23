package com.sdjzu.knowledgequiz.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.Course;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.service.AnswerService;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.service.TeacherCourseService;
import com.sdjzu.knowledgequiz.util.FileUtil;
import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
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

    @Autowired
    AnswerService answerService;

    @Value("${file.path}")
    private String  imgPath;

//    发布一个新题目
    @PostMapping("/question")
    public Msg saveQuestion(@RequestBody Question question){
        question.setUpTime(new Date());
        boolean save = questionService.save(question);
        if(save)
            return Msg.success();
        else
            return Msg.fail();
    }
// 异步请求处理图片上传
    @PostMapping("/fileUpload")
    @ResponseBody
    public Msg upload(@RequestParam("file") MultipartFile file) {

        String type = file.getContentType().split("/")[1];
        System.out.println(type);
        String imgName = IdUtil.simpleUUID()+"."+type;
        FileUtil.upload(file, imgPath, imgName);
        return Msg.success().add("url","images/"+imgName);
    }
    //查询教师的选课
    @GetMapping("/teaCourse/{account}")
    public Msg getTeaCourse(@PathVariable("account") String account){
        List<Course> teaCourseList = teacherCourseService.getTeaCourse(account);
        if(teaCourseList != null)
            return Msg.success().add("courseList",teaCourseList);
        else
            return Msg.fail();
    }

//    返回某一个老师能查看的所有题目
    @GetMapping("/questionList/{account}/{pn}")
    public Msg getQuestionList(@PathVariable("account") String account,@PathVariable("pn") Integer pn){
        Page<QuestionVO> page = new Page<>(pn,5);  // 查询第n页，每页返回5条
        IPage<QuestionVO> questionByAcc = questionService.selectQuestionVO(page,account);
        return Msg.success().add("pageInfo", questionByAcc);
    }
//      回答问题
    @PostMapping("/answer")
    public Msg createAnswer(@RequestBody Answer answer){
        answer.setUpTime(new Date());
        boolean save = answerService.save(answer);
        if(save)
            return Msg.success();
        else
            return Msg.fail();
    }

//    得到某个问题的所有答案
    @GetMapping("/question/answer/{questionId}")
    public Msg getAnswerByQid(@PathVariable("questionId")int questionId){
        List<AnswerVO> answerVO = answerService.getAnswerVO(questionId);
        return Msg.success().add("answerVOList",answerVO);
    }

// 得到某个课程下的所有问题
    @GetMapping("/question/course/{courseId}/{pn}")
    public Msg getQuestionByCourseId(@PathVariable("courseId") int courseId,@PathVariable("pn") int pn){
        Page<QuestionVO> page = new Page<>(pn,5);  // 查询第n页，每页返回5条
        IPage<QuestionVO> questionByCourseId = questionService.selectQuestionVOByCourseId(page,courseId);
        return  Msg.success().add("pageInfo",questionByCourseId);
    }
//    得到某个课程下未审核的问题
    @GetMapping("/questionDown/course/{courseId}/{pn}")
    public Msg getQuestionByCourseIdDown(@PathVariable("courseId") int courseId,@PathVariable("pn") int pn){
    Page<QuestionVO> page = new Page<>(pn,5);  // 查询第n页，每页返回5条
    IPage<QuestionVO> questionByCourseId = questionService.selectQuestionVOByCourseIdDown(page,courseId);
    return  Msg.success().add("pageInfo",questionByCourseId);
}
}
