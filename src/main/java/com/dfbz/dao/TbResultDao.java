package com.dfbz.dao;

import com.dfbz.entity.TbResult;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TbResultDao {

//    @Select("select res_id, res_subject, res_score, stu_id from tb_result where res_id = #{resId}")
//    @Results(value = {
//            @Result(property = "stuId",column = "stu_id"),
//            @Result(property = "student",column = "stu_id",
//                    one = @One(select = "com.dfbz.dao.StudentDao.findById",
//                            fetchType = FetchType.LAZY))
//    })
    TbResult findById(Long resId);

    @Select("select res_id, res_subject, res_score, stu_id from tb_result where stu_id = #{stuId}")
    List<TbResult> findByStuId(Long stuId);
}
