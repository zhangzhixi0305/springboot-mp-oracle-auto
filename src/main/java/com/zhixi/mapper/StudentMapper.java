package com.zhixi.mapper;

import com.zhixi.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author zhixi
* @description 针对表【STUDENT】的数据库操作Mapper
* @createDate 2022-10-21 17:13:02
* @Entity com.zhixi.pojo.Student
*/
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询所有存在用户
     *
     * @return 用户集合
     */
    List<Student> queryStudent();


    /**
     * 根据姓名模糊查询
     *
     * @param name 姓名
     * @return 包含此字符的用户数据
     */
    List<Student> findAllByNameStudents(@Param("name") String name);
}




