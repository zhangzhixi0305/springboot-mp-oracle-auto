package com.zhixi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixi.pojo.Student;
import com.zhixi.service.StudentService;
import com.zhixi.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhixi
 * @description 针对表【STUDENT】的数据库操作Service实现
 * @createDate 2022-10-21 17:13:03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询所有在线用户
     *
     * @return 用户集合
     */
    @Override
    public List<Student> queryStudent() {
        return studentMapper.queryStudent();
    }

    /**
     * 根据姓名模糊查询
     *
     * @param name 姓名
     * @return 包含此字符的用户数据
     */
    @Override
    public List<Student> findAllByNameStudents(String name) {
        return studentMapper.findAllByNameStudents(name);
    }
}




