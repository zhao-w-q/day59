package com.dfbz.dao;

import com.dfbz.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    @InsertProvider(type = StudentProvider.class, method = "batchInsert")
    int batchInsert(@Param("students") List<Student> students);

    @DeleteProvider(type = StudentProvider.class, method = "deleteByIds")
    int deleteByIds(@Param("sid") int... sid);

    @UpdateProvider(type = StudentProvider.class, method = "updateByNotnull")
    int updateByNotnull(Student entity);

    @SelectProvider(type = StudentProvider.class, method = "findByCondition")
    List<Student> findByCondition(Student entity);

//    @Select("select stu_id, stu_name, stu_age, stu_password from tb_student")
//    @Results({
//            @Result(property = "stuId",column = "stu_id"),
//            @Result(many = @Many(select = "com.dfbz.dao.TbResultDao.findByStuId",fetchType = FetchType.LAZY),
//            property = "tbResults",column = "stu_id")
//    })
    List<Student> findAll();

//    @Select("select stu_id, stu_name, stu_age, stu_password from tb_student where stu_id = #{stuId}")
    Student findById(Long stuId);
}
