package com.zhixi;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixi.pojo.Student;
import com.zhixi.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@SpringBootTest
class OracleDemoApplicationTests {

    @Autowired
    private StudentService studentService;

    /**
     * 查询全部用户
     */
    @Test
    void queryStudent() {
        BaseMapper<Student> studentMapper = studentService.getBaseMapper();
        /*MybatisPlus方式查询*/
        LambdaQueryWrapper<Student> studentQueryWrapper = new LambdaQueryWrapper<>();
        studentQueryWrapper.eq(Student::getIsDeleted, 0);
        System.out.println(studentMapper.selectList(studentQueryWrapper));
        /*Mybatis方式*/
        List<Student> studentList = studentService.queryStudent();
        System.out.println(studentList);
    }

    /**
     * 根据用户姓名模糊查询
     */
    @Test
    void queryByName() {
        String name = "%刘%";
        /*MybatisPlus方式*/
       /* BaseMapper<Student> baseMapper = studentService.getBaseMapper();
        LambdaQueryWrapper<Student> studentQueryWrapper = new LambdaQueryWrapper<>();
        studentQueryWrapper.like(Student::getName, name);
        System.out.println(baseMapper.selectList(studentQueryWrapper));*/
        log.info("========================");
        /*Mybatis方式*/
        List<Student> allByNameStudents = studentService.findAllByNameStudents(name);
        allByNameStudents.forEach(System.out::println);
    }


    @Test
    void insertStudent() {
        BaseMapper<Student> studentMapper = studentService.getBaseMapper();
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(23);
        student.setSex("男");
        student.setTel(18888888888L);
        student.setEmail("");
        student.setBirthday(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setIsDeleted(0L);
        studentMapper.insert(student);
    }
}
