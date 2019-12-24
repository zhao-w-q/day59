package com.dfbz.dao;

import com.dfbz.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhao
 * @description
 * @date 2019/11/4
 */
public class StudentProvider {

    public String batchInsert(@Param("students") List<Student> students) {
        StringBuilder builder = new StringBuilder("INSERT INTO tb_student (stu_name, stu_age, stu_password) VALUES ");
        for (int i = 0; i < students.size(); i++) {
            builder.append("(#{students[").append(i).append("].stuName}, #{students[").append(i).append("].stuAge}, #{students[").append(i).append("].stuPassword}), ");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }

    public String deleteByIds(@Param("sid") int... sid) {
        StringBuilder builder = new StringBuilder("DELETE FROM tb_student WHERE ");
        for (int i = 0; i < sid.length; i++) {
            builder.append("stu_id = #{sid[").append(i).append("]} or ");
        }
        builder.delete(builder.lastIndexOf("or"),builder.lastIndexOf("or")+2);
        return builder.toString();
    }

    public String updateByNotnull(Student entity) {
        StringBuilder builder = new StringBuilder("UPDATE tb_student SET ");
        if (entity.getStuName() != null) {
            builder.append("stu_name = #{stuName}, ");
        }
        if (entity.getStuAge() != null) {
            builder.append("stu_age = #{stuAge}, ");
        }
        if (entity.getStuPassword() != null) {
            builder.append("stu_password = #{stuPassword}, ");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("WHERE stu_id = #{stuId}");
        return builder.toString();
    }

    public String findByCondition(Student entity) {
        StringBuilder builder = new StringBuilder("SELECT stu_id, stu_name, stu_age, stu_password FROM tb_student WHERE 1=1 ");
        if (entity.getStuName() != null) {
            builder.append("AND stu_name like CONCAT('%',#{stuName},'%')");
        }
        if (entity.getStuAge() != null) {
            builder.append("AND stu_age = #{stuAge}");
        }
        if (entity.getStuPassword() != null) {
            builder.append("AND stu_password = #{stuPassword}");
        }
        return builder.toString();
    }
}
