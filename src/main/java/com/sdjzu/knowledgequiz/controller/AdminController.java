package com.sdjzu.knowledgequiz.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdjzu.knowledgequiz.entity.*;
import com.sdjzu.knowledgequiz.pojo.StudentExcel;
import com.sdjzu.knowledgequiz.service.*;
import com.sdjzu.knowledgequiz.util.Msg;
import com.sdjzu.knowledgequiz.vo.QuestionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherCourseService teacherCourseService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentCourseService studentCourseService;

    @Autowired
    QuestionService questionService;

    /**
     * 接受excel文件，课程去重，插入课程，再插入教师信息。
     * 为什么要去重，加快一点效率
     * 而且使用hasp去重，会比直接在sql中去重。快的多得多
     *
     * @param file
     * @return
     */
    @PostMapping("/TeacherExcelUpload")
    @ResponseBody
    public Msg uploadTeacherExcel(@RequestParam("file") MultipartFile file) {
        try {
            //        将excel转化为 二维list
            List<List<Object>> list = adminService.getListByExcel(file);
            if(list == null || list.size()==0){
                log.error("用户不是上传的excel文件,或者excel文件为空!");
                return Msg.fail().add("msg", "用户不是上传的excel文件,或者excel文件为空");
            }
//        去重的课程列表
            HashSet<String> courseSet = new HashSet<>();
//        教师列表（带课程信息）
            List<Teacher> teachers = new ArrayList<>();
//        解析数据
            for (int i = 0; i < list.size() - 1; i++) {
                List<Object> excelList = list.get(i);
//            去除因为整型转String时，加的.0
                String account = new DecimalFormat("0").format(Double.parseDouble(excelList.get(0).toString()));;
                String pwd = account;
                String name = excelList.get(1).toString();
                String research = excelList.get(2).toString();
                String title = excelList.get(3).toString();
                String acaDegree = excelList.get(4).toString();
                String courseInit = excelList.get(5).toString();
                String[] splitCourses = courseInit.split(",");
                for (String splitItem : splitCourses) {
                    courseSet.add(splitItem);
                }
                Teacher teacher = new Teacher(account, pwd, name, research, title, acaDegree, splitCourses);
                teachers.add(teacher);
            }

            log.info("去掉重复项后的课程");
            for (String s : courseSet) {
                log.info(s);
            }

            log.info("在数据库中插入课程信息");
            for (String cname : courseSet) {
                Course course = new Course();
                course.setName(cname);
                courseService.addCourse(course);
            }
            log.info("课程信息插入完毕");


            log.info("在数据库中插入教师信息");
            for (Teacher teacher : teachers) {
                teacherService.addTeacher(teacher);

            }
            log.info("教师信息插入完毕");

            log.info("在数据库中插入教师授课信息");
            for (Teacher teacher : teachers) {
                for (String teaCourseName : teacher.getCourseInit()) {
//                获取课程对应的id。
                    Course course = courseService.searchByName(teaCourseName);
                    if(course!=null){
                        TeacherCourse teaCourse = new TeacherCourse();
                        teaCourse.setCourseId(course.getId());
                        teaCourse.setAccount(teacher.getAccount());
                        teacherCourseService.addTeaCourse(teaCourse);
                    }
                }
            }
            log.info("教师授课信息插入完毕");
            return Msg.success().add("msg", "excel内容插入成功");
        }
        catch (Exception e){
            log.error("excel有内容为空");
            e.printStackTrace();
            return Msg.fail().add("msg", "excel内容不得为空");
        }

    }

    @PostMapping("/StudentExcelUpload")
    @ResponseBody
    public Msg uploadStudentExcel(@RequestParam("file") MultipartFile file) {
        try {
            //        将excel转化为 二维list
            List<List<Object>> list = adminService.getListByExcel(file);
            if(list == null || list.size()==0){
                log.error("用户不是上传的excel文件,或者excel文件为空!");
                return Msg.fail().add("msg", "用户不是上传的excel文件,或者excel文件为空");
            }
//        去重的课程列表
            HashSet<String> courseSet = new HashSet<>();
//        教师列表（带课程信息）
            List<Student> students = new ArrayList<>();
//        解析数据
            for (int i = 0; i < list.size() - 1; i++) {
                List<Object> excelList = list.get(i);
//            去除因为整型转String时，加的.0
                String account = new DecimalFormat("0").format(Double.parseDouble(excelList.get(0).toString()));;
                String pwd =account;
                String name = excelList.get(1).toString();
                String college = excelList.get(2).toString();
                String courseInit = excelList.get(3).toString();
                String[] splitCourses = courseInit.split(",");
                for (String splitItem : splitCourses) {
                    courseSet.add(splitItem);
                }
                Student student = new Student(account, name ,pwd,college, splitCourses);
                students.add(student);
            }

            log.info("去掉重复项后的课程");
            for (String s : courseSet) {
                log.info(s);
            }

            log.info("在数据库中插入课程信息");
            for (String cname : courseSet) {
                Course course = new Course();
                course.setName(cname);
                courseService.addCourse(course);
            }
            log.info("课程信息插入完毕");


            log.info("在数据库中插入学生信息");
            for (Student student : students) {
                studentService.addStudent(student);
            }
            log.info("学生信息插入完毕");

            log.info("在数据库中插入学生选课信息");
            for (Student student : students) {
                for (String StuCourseName : student.getCourseInit()) {
//                获取课程对应的id。
                    Course course = courseService.searchByName(StuCourseName);
                    if(course!=null){
                        StudentCourse stuCourse = new StudentCourse();
                        stuCourse.setCourseId(course.getId());
                        stuCourse.setAccount(student.getAccount());
                        studentCourseService.addStuCourse(stuCourse);
                    }
                }
            }
            log.info("学生选课信息插入完毕");
            return Msg.success();
        }
        catch (Exception e){
            log.error("excel有内容为空");
            e.printStackTrace();
            return Msg.fail().add("msg", "excel内容不得为空");
        }

    }

    @PostMapping("/CourseExcelUpload")
    @ResponseBody
    public Msg uploadCourseExcel(@RequestParam("file") MultipartFile file) {
        try {
            //        将excel转化为 二维list
            List<List<Object>> list = adminService.getListByExcel(file);
            if(list == null || list.size()==0){
                log.error("用户不是上传的excel文件,或者excel文件为空!");
                return Msg.fail().add("msg", "用户不是上传的excel文件,或者excel文件为空");
            }

//        课程信息（）
            List<Course> courses = new ArrayList<>();
//        解析数据
            for (int i = 0; i < list.size() - 1; i++) {
                List<Object> excelList = list.get(i);
//            去除因为整型转String时，加的.0
                String name = excelList.get(0).toString();
                String detail = excelList.get(1).toString();
                Course course = new Course();
                course.setName(name);
                course.setDetail(detail);
                courses.add(course);
            }

            log.info("在数据库中插入课程详细信息");
            for (Course course : courses) {
                courseService.addCourseWithDetail(course);
            }
            log.info("课程信息插入完毕");

            return Msg.success();
        }
        catch (Exception e){
            log.error("excel有内容为空");
            e.printStackTrace();
            return Msg.fail().add("msg", "excel内容不得为空");
        }

    }
    /**
     * 分页查询
     * @param pn
     * @return
     */
    @GetMapping("/Student")
    @ResponseBody
    public Msg getStudentByPageHelper(@RequestParam(value="pn",defaultValue="1")Integer pn){
        PageHelper.startPage(pn, 7);
        List<Student> students = studentService.getAll();
        PageInfo page = new PageInfo(students,5);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/Update/Student",consumes = "application/json")
    @ResponseBody
    public Msg updateStudent(@RequestBody Student student){
        Student studentF = studentService.updateStudent(student);
        if(studentF != null){
            log.info("更新学生信息"+student.toString()+"成功");
            return Msg.success().add("student",studentF);
        }else {
            log.info("更新学生信息"+student.toString()+"失败");
            return Msg.fail();
        }


    }

    /**
     * 删除学生信息
     * @param account
     * @return
     */
    @GetMapping("/Delete/Student")
    @ResponseBody
    public Msg deleteStudent(@RequestParam String account){
        boolean flag = studentService.deleteStudent(account);
        if(flag){
            log.info("删除学生信息"+account+"成功");
            return Msg.success().add("account",account);
        }else {
            log.info("删除学生信息"+account+"失败");
            return Msg.fail();
        }
    }

    /**
     * 分页查询
     * @param pn
     * @return
     */
    @GetMapping("/Teacher")
    @ResponseBody
    public Msg getTeacherByPageHelper(@RequestParam(value="pn",defaultValue="1")Integer pn){
        PageHelper.startPage(pn, 7);
        List<Teacher> teachers = teacherService.getAll();
        PageInfo page = new PageInfo(teachers,5);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    @PostMapping(value="/Update/Teacher",consumes = "application/json")
    @ResponseBody
    public Msg updateTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher.toString());
        Teacher teacherF = teacherService.updateTeacher(teacher);
        if(teacherF != null){
            log.info("更新教师信息"+teacher.toString()+"成功");
            return Msg.success().add("teacher",teacherF);
        }else {
            log.info("更新教师信息"+teacher.toString()+"失败");
            return Msg.fail();
        }


    }

    /**
     * 删除教师信息
     * @param account
     * @return
     */
    @GetMapping("/Delete/Teacher")
    @ResponseBody
    public Msg deleteTeacher(@RequestParam String account){
        boolean flag = teacherService.deleteTeacher(account);
        if(flag){
            log.info("删除教师信息"+account+"成功");
            return Msg.success().add("account",account);
        }else {
            log.info("删除教师信息"+account+"失败");
            return Msg.fail();
        }


    }

    @GetMapping("/Course/Teacher")
    @ResponseBody
    public Msg getCourseByTeacher(@RequestParam String account){
        log.info("查询用户"+account+"的任课信息");
        List<Course> list = teacherCourseService.getTeaCourse(account);
        return Msg.success().add("list", list);
    }

    @PostMapping(value = "/Delete/TeaCourse",consumes = "application/json")
    @ResponseBody
    public Msg delCourseByTea(@RequestBody TeacherCourse teacherCourse){

        log.info("删除"+teacherCourse.toString()+"的任课信息");
        teacherCourseService.delTeaCourse(teacherCourse);
        return Msg.success();
    }


    @GetMapping("/Course/Student")
    @ResponseBody
    public Msg getCourseByStudent(@RequestParam String account){
        log.info("查询用户"+account+"的任课信息");
        List<Course> list = studentCourseService.getStuCourse(account);
        return Msg.success().add("list", list);
    }

    @PostMapping(value = "/Delete/StuCourse",consumes = "application/json")
    @ResponseBody
    public Msg delCourseByStu(@RequestBody StudentCourse studentCourse){

        log.info("删除"+studentCourse.toString()+"的任课信息");
        studentCourseService.delStuCourse(studentCourse);
        return Msg.success();
    }

    /**
     * 通过key时时检索
     * @param keyword
     * @return
     */
    @GetMapping("/Key/Student")
    @ResponseBody
    public Msg getStuByKey(@RequestParam String keyword){
        log.info("模糊查询"+keyword+"的学生信息");
        List<Student> stuByKey = studentService.getStuByKey(keyword);
        return Msg.success().add("students", stuByKey);
    }

    /**
     * 通过account精准查询学生信息
     * @param account
     * @return
     */
    @GetMapping("/Account/Student")
    @ResponseBody
    public Msg getStuByAccount(@RequestParam String account){
        log.info("精确查询"+account+"的学生信息");
        Student student = studentService.searchByAcc(account);
        return Msg.success().add("student", student);
    }

    /**
     * 通过key时时检索
     * @param keyword
     * @return
     */
    @GetMapping("/Key/Teacher")
    @ResponseBody
    public Msg getTeaByKey(@RequestParam String keyword){
        log.info("模糊查询"+keyword+"的教师信息");
        List<Teacher> teachers = teacherService.getTeaByKey(keyword);
        return Msg.success().add("teachers", teachers);
    }

    /**
     * 通过account精准查询学生信息
     * @param account
     * @return
     */
    @GetMapping("/Account/Teacher")
    @ResponseBody
    public Msg getTeaByAccount(@RequestParam String account){
        log.info("精确查询"+account+"的教师信息");
        Teacher teacher = teacherService.searchByAcc(account);
        return Msg.success().add("teacher", teacher);
    }


    /**
     * 分页查询课程
     * @param pn
     * @return
     */
    @GetMapping("/Course")
    @ResponseBody
    public Msg getCourseByPageHelper(@RequestParam(value="pn",defaultValue="1")Integer pn){
        PageHelper.startPage(pn, 7);
        List<Course> courses = courseService.getAll();
        PageInfo page = new PageInfo(courses,5);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @PostMapping(value="/Update/Course",consumes = "application/json")
    @ResponseBody
    public Msg updateCourse(@RequestBody Course course){
        Course courseF = courseService.updateCourse(course);
        if(courseF != null){
            log.info("更新课程信息"+course.toString()+"成功");
            return Msg.success().add("course",course);
        }else {
            log.info("更新学生信息"+course.toString()+"失败");
            return Msg.fail();
        }


    }

    /**
     * 删除课程信息
     * @param id
     * @return
     */
    @GetMapping("/Delete/Course")
    @ResponseBody
    public Msg deleteCourse(@RequestParam String id){
        System.out.println(id+"id是");
        boolean flag = courseService.deleteCourse(id);
        if(flag){
            log.info("删除课程信息"+id+"成功");
            return Msg.success().add("id",id);
        }else {
            log.info("删除课程信息"+id+"失败");
            return Msg.fail();
        }
    }
    /**
     * 通过key时时检索
     * @param keyword
     * @return
     */
    @GetMapping("/Key/Course")
    @ResponseBody
    public Msg getCourByKey(@RequestParam String keyword){
        log.info("模糊查询"+keyword+"的课程信息");
        List<Course> courses = courseService.getCourByKey(keyword);
        return Msg.success().add("courses", courses);
    }

    /**
     * 通过id精准查询课程信息
     * @param id
     * @return
     */
    @GetMapping("/Id/Course")
    @ResponseBody
    public Msg getCourseById(@RequestParam String id){
        log.info("精确查询"+id+"的课程信息");
        Course course = courseService.searchById(id);
        return Msg.success().add("course", course);
    }




    /**
     * 分页查询问题
     * @param pn
     * @return
     */
    @GetMapping("/questionList/{pn}")
    @ResponseBody
    public Msg getQuestionListByPageHelper(@PathVariable("pn") Integer pn){
        Page<QuestionVO> page = new Page<>(pn,7);
        IPage<QuestionVO> questionList = questionService.getQuestionList(page);
        System.out.println(questionList.getRecords().size());
        return Msg.success().add("pageInfo",questionList);
    }

    //    更新问题
    @PutMapping("/question")
    @ResponseBody
    public Msg updateQuestion(@RequestBody Question question){
        System.out.println(question.toString());
        boolean flag = questionService.updateById(question);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }

    //    删除问题
    @DeleteMapping("/question/{id}")
    @ResponseBody
    public Msg deleteQuestion(@PathVariable("id")int id){
        boolean flag = questionService.removeById(id);
        if(flag)
            return Msg.success();
        else
            return Msg.fail();
    }
    //    模糊查询  NO
    @GetMapping("/questionList/keyword/{keyword}/{pn}")
    @ResponseBody
    public Msg getQuestionByKeyword(@PathVariable("keyword") String keyword,@PathVariable("pn") Integer pn){
        Page<QuestionVO> page = new Page<>(pn,7);
        IPage<QuestionVO> questionVOList = questionService.selectQuestionVOByKeywordAndIpage(page,keyword);
        return Msg.success().add("questionList",questionVOList);
    }
    //    得到某个问题的相信信息
    @GetMapping("/question/{questionId}")
    @ResponseBody
    public Msg getQuestionByQid(@PathVariable("questionId") int questionId){
        QuestionVO questionVO = questionService.selectQuestionVOByQId(questionId);
        return Msg.success().add("question",questionVO);
    }
    //    模糊查询
    @GetMapping("/questionList/keyword/{keyword}")
    @ResponseBody
    public Msg getQuestionByKeyword(@PathVariable("keyword") String keyword){
        List<QuestionVO> questionVOList = questionService.selectQuestionVOByKeyword(keyword);
        return Msg.success().add("questionList",questionVOList);
    }
    @GetMapping("/courseList")
    @ResponseBody
    public Msg getCourseList(){
        List<Course> list = courseService.getAll();
        return Msg.success().add("courseList",list);
    }

    @PutMapping("/studentCourse")
    @ResponseBody
    public Msg addStudentCourse(@RequestBody StudentCourse studentCourse){

        try {
            StudentCourse flag = studentCourseService.searchStuCourseByAccAndCid(studentCourse.getAccount(), studentCourse.getCourseId());
            if(flag == null){
                studentCourseService.addStuCourse(studentCourse);
                return Msg.success();
            } else {
                return Msg.fail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }

    }

    @PutMapping("/teacherCourse")
    @ResponseBody
    public Msg addTeacherCourse(@RequestBody TeacherCourse teacherCourse){
        try {
            TeacherCourse flag = teacherCourseService.searchTeaCourseByAccAndCid(teacherCourse.getAccount(),teacherCourse.getCourseId());
            if(flag == null){
                teacherCourseService.addTeaCourse(teacherCourse);
                return Msg.success();
            } else {
                return Msg.fail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }

    }

//    导出学生信息
    @GetMapping("/excelOut/question")
    @ResponseBody
    public Msg outPutStudent(){
        List<Student> students = studentService.getAll();
        List<StudentExcel> StudentExcels = new ArrayList<>();

        for (Student student : students) {
            List<Course> stuCourse = studentCourseService.getStuCourse(student.getAccount());
            StringBuffer stringBuffer = new StringBuffer();
            for (Course course : stuCourse) {
                stringBuffer.append(course.getName()+",");
            }
            String str = stringBuffer.toString();
            String courseInit = str.substring(0,str.length()-1);
            StudentExcel studentExcel = new StudentExcel(student.getAccount(),student.getName(),student.getCollege(),courseInit);
            StudentExcels.add(studentExcel);
        }
        ExcelWriter writer = ExcelUtil.getWriter("e:/photo/writeBeanTest.xlsx");
        //自定义标题别名
        writer.addHeaderAlias("account", "学号");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("college", "学院");
        writer.addHeaderAlias("courseInit", "选课");
        writer.write(StudentExcels, true);
        // 关闭writer，释放内存
        writer.close();
        return Msg.success();
    }

}
