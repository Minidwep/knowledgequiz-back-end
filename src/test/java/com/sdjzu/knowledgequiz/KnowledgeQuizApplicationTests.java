package com.sdjzu.knowledgequiz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdjzu.knowledgequiz.entity.Answer;
import com.sdjzu.knowledgequiz.entity.Question;
import com.sdjzu.knowledgequiz.entity.Student;
import com.sdjzu.knowledgequiz.entity.Teacher;
import com.sdjzu.knowledgequiz.mapper.*;
import com.sdjzu.knowledgequiz.service.AnswerService;
import com.sdjzu.knowledgequiz.service.QuestionService;
import com.sdjzu.knowledgequiz.service.TeacherCourseService;
import com.sdjzu.knowledgequiz.service.TeacherService;
import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.AnswerVO;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
class KnowledgeQuizApplicationTests {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    TeacherCourseMapper teacherCourseMapper;
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherCourseService teacherCourseService;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Test
    void contextLoads() {
        try {
            String datestr = "2019-04-17 14:55:10";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //将字符串转为date类型
            Date date = sdf.parse(datestr);
            //输出转换后的date类型的日期
            System.out.println(date.toString());
            //输出格式化后的日期
            System.out.println(sdf.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    void CourseMapperTest(){
//        String str = "2016111";
//        for (int i = 10 ; i<100;i++){
//
//            Student student = new Student();
//            student.setName("同学"+i);
//            student.setAccount(str+i);
//            student.setPwd(str+i);
//            student.setCollege("计算机科学与技术");
//            studentMapper.addStudent(student);
//        }

        String str = "11000";
        for (int i = 10 ; i<100;i++){

            Teacher teacher = new Teacher();
            teacher.setName("教师"+i);
            teacher.setResearch("软件工程研究室");
            teacher.setTitle("教授");
            teacher.setAcaDegree("博士");
            teacher.setPwd(str+i);
            teacher.setAccount(str+i);
            teacherMapper.addTeacher(teacher);
        }


//        Course course1 = new Course();
//        course1.setName("123");
//        courseMapper.addCourse(course1);
    }

    @Test
    void test1(){
//        List<Course> teaCourse = teacherCourseService.getTeaCourse("110020");
//        for (Course course : teaCourse) {
//            System.out.println(course.toString());
//        }
//            List<Student> stuByKey = studentMapper.getStuByKey("2016");
//            for (Student student : stuByKey) {
//                student.toString();
//
//        }
        Question question = new Question();
        question.setAccount("test");
//        question.setDetail(new Long("123"));
        question.setDownTime(new Date());
        question.setStatus(1);
        question.setCourseId(33);
//        int question1 = questionMapper.createQuestion(question);
//        int insert = questionMapper.insert(question);
//        System.out.println(insert);
        questionService.save(question);
    }
    @Test
    void teacher(){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", "110002");
        Map<String, Object> map1 = questionService.getMap(queryWrapper);
        Iterator it = map1.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
        List<Question> questions = questionMapper.selectList(queryWrapper);
        for (Question question : questions) {
            System.out.println(question.toString());
        }

    }
    @Test
    void pojo(){
        Page<QuestionVO> page = new Page<>(1,5);  // 查询第n页，每页返回5条

        IPage<QuestionVO> questionByAcc = questionMapper.getQuestionByAcc(page,"110002");
        for (QuestionVO questionVO : questionByAcc.getRecords()) {
            System.out.println(questionVO.toString());
        }
    }
    @Test
    void anser(){
        List<AnswerVO> answerVO = answerService.getAnswerVO(141);
        for (AnswerVO vo : answerVO) {
            System.out.println(vo.toString());

        }
    }
    @Test
    void question(){
        Page<QuestionVO> objectPage = new Page<>(1,5);

        IPage<QuestionVO> questionVOIPage = questionService.selectQuestionVOByCourseId(objectPage, 36);
        for (QuestionVO record : questionVOIPage.getRecords()) {
            System.out.println(record.toString());
        }

    }
    @Test
    void answer() {
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("account", "110002");
        List<Answer> list = answerService.list(queryWrapper);

        list.forEach(item->System.out.println(item.toString()));
    }
    @Test
    void answerVo(){
        Page<AnswerVO> page = new Page<>(1,5);
        IPage<AnswerVO> answerVOByAccount = answerService.getAnswerVOByAccount(page, "110002");
        for (AnswerVO record : answerVOByAccount.getRecords()) {
            System.out.println(record.toString());
        }
    }


}
