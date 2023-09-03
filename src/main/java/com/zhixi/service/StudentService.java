package com.zhixi.service;

import com.zhixi.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zhixi
* @description 针对表【STUDENT】的数据库操作Service
* @createDate 2022-10-21 17:13:03
*/
public interface StudentService extends IService<Student> {
    /**
     * 查询所有在线用户
     *
     * @return 用户集合
     */
    List<Student> queryStudent();

    /**
     * 根据姓名模糊查询
     * @param name 姓名
     * @return 包含此字符的用户数据
     */
    List<Student> findAllByNameStudents(String name);
}
