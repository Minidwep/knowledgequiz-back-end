package com.sdjzu.knowledgequiz.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.*;
import com.sdjzu.knowledgequiz.service.*;
import com.sdjzu.knowledgequiz.util.FileUtil;
import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.PasswordVO;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import com.sdjzu.knowledgequiz.vo.StudentRewordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.SpinnerUI;
import java.util.Date;
import java.util.Iterator;
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

    @Autowired
    RewordService rewordService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentRewordService studentRewordService;

    @Value("${file.path}")
    private String  imgPath;

    //    发布一个新题目
    @PostMapping("/question")
    public Msg saveQuestion(@RequestBody Question question){
        question.setUpTime(new Date());
        question.setStatus(1);
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
    public Msg getQuestionList(@PathVariable("account") String account, @PathVariable("pn") Integer pn){

        Page<QuestionVO> page = new Page<>(pn,5);  // 查询第n页，每页返回5条
        IPage<QuestionVO> questionByAcc = questionService.selectQuestionVOByTea(page,account);
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
    //    更新问题信息
    @PutMapping("/question")
    public Msg updateQuestion(@RequestBody Question question){
        System.out.println(question.toString());
        boolean flag = questionService.updateById(question);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }

    //    删除问题信息
    @DeleteMapping("/question/{id}")
    public Msg deleteQuestion(@PathVariable("id")int id){
        boolean flag = questionService.removeById(id);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }
    //    审核通过问题
    @PutMapping("/questionUp/{id}")
    public Msg UpQuestion(@PathVariable("id") int id){
        Question byId = questionService.getById(id);
        byId.setStatus(1);
        boolean flag = questionService.updateById(byId);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }
    //   采纳回答
    @GetMapping("/answerUp/{answerId}")
    public Msg UpAnswer(@PathVariable("answerId") int answerId){
        Answer answer = answerService.getById(answerId);
        answer.setStar(1);
        Question question = questionService.getById(answer.getQuestionId());
        question.setStatus(2);
        questionService.updateById(question);
        boolean flag = answerService.updateById(answer);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }

    //    查询一共回答了多少题
    @GetMapping("/userInfo/{account}")
    public Msg getAnswerNum(@PathVariable("account") String account){
//        回答数
        QueryWrapper<Answer> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("account", account);
        List<Answer> answerNum = answerService.list(queryWrapper1);
//        被采纳数
        QueryWrapper<Answer> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("account", account)
                .eq("star","1");
        List<Answer> answerStarNum = answerService.list(queryWrapper2);
//        提问数
        QueryWrapper<Question> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("account", account);
        List<Question> questionNum = questionService.list(queryWrapper3);
        return Msg.success().add("answerNum",answerNum.size()).add("answerStarNum",answerStarNum.size())
                .add("questionNum",questionNum.size());
    }

    //      查看某个用户下的所有提出的问题
    @GetMapping("/questionList/One/{account}/{pn}")
    public Msg getQuestionByOne(@PathVariable("account") String account,@PathVariable("pn") int pn){
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.eq("account", account);
        Page<Question> page = new Page<>(pn,5);
        IPage<Question> iPage = questionService.page(page, questionQueryWrapper);
        return Msg.success().add("pageInfo",iPage);
    }
    //    查看某个用户下所有的回答
    @GetMapping("/answerList/One/{account}/{pn}")
    public Msg getAnswerByOne(@PathVariable("account") String account,@PathVariable("pn") int pn){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        Page<AnswerVO> page = new Page<>(pn,5);
        IPage<AnswerVO> iPage = answerService.getAnswerVOByAccount(page, account);
        return Msg.success().add("pageInfo",iPage);
    }
//    得到某个问题的相信信息
    @GetMapping("/question/{questionId}")
    public Msg getQuestionByQid(@PathVariable("questionId") int questionId){
        QuestionVO questionVO = questionService.selectQuestionVOByQId(questionId);
        return Msg.success().add("question",questionVO);
    }
//    模糊查询
    @GetMapping("/questionList/keyword/{keyword}")
    public Msg getQuestionByKeyword(@PathVariable("keyword") String keyword){
        List<QuestionVO> questionVOList = questionService.selectQuestionVOByKeyword(keyword);
        return Msg.success().add("questionList",questionVOList);
    }
//    发布奖励
    @PostMapping("/reword")
    public Msg createReword(@RequestBody Reword reword){
        rewordService.save(reword);
        return Msg.success();
    }
//    删除奖励
    @DeleteMapping("/reword/{id}")
    public Msg deleteReword(@PathVariable("id") int id){
        rewordService.removeById(id);
        return Msg.success();
    }
//    查看奖励
    @GetMapping("/reword/course/{courseId}")
    public Msg getReword(@PathVariable("courseId") String courseId){
        QueryWrapper<Reword> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List<Reword> list = rewordService.list(queryWrapper);
        return Msg.success().add("rewordList",list);
    }

    //    修改密码
    @PostMapping("/password")
    public Msg rePassword(@RequestBody PasswordVO passwordVO){
        String account = passwordVO.getAccount();
        Teacher teacher = teacherService.searchByAcc(account);
        if(  passwordVO.getExPwd().equals(teacher.getPwd())){
            teacher.setPwd(passwordVO.getPwd());
            teacherService.updateTeacher(teacher);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    //   设置奖励问题
    @PutMapping("/stuReword")
    public Msg stuReword(@RequestBody StudentReword studentReword){
        QueryWrapper<StudentReword> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stu_account",studentReword.getStuAccount())
                .eq("reword_id",studentReword.getRewordId());
        StudentReword one = studentRewordService.getOne(queryWrapper);
        if (one == null){
            boolean flag = studentRewordService.save(studentReword);
            if(flag)
                return Msg.success();
            else
                return Msg.fail();
        }
        else {
            return Msg.fail().add("message", "奖励已经存在");
        }

    }

    //   查询某个奖励下的学生
    @GetMapping("/stuReword/{rewordId}/{pn}")
    public Msg getRewordByRewordId(@PathVariable("rewordId") String rewordId,@PathVariable("pn") int pn){
        Page<StudentRewordVO> page = new Page<>(pn,5);
        IPage<StudentRewordVO> iPage = studentRewordService.getStudentRewordVOByRewordId(page, rewordId);
        return Msg.success().add("pageInfo",iPage);
    }
    //    删除奖励
    @DeleteMapping("/stuReword/{id}")
    public Msg deleteStuReword(@PathVariable("id") int id){

        studentRewordService.removeById(id);
        return Msg.success();
    }

}
