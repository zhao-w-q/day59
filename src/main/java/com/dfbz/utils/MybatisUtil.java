package com.dfbz.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author Zhao
 * @description
 * @date 2019/11/1
 */
public class MybatisUtil {

    private static final SqlSessionFactory SSF = createSqlSessionFactory();

    // 创建一个线程绑定变量，将变量放在该对象里面，表示对象同一条线程共享
    private static final ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();

    private static SqlSessionFactory createSqlSessionFactory() {
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SqlSession getSqlSession(){
        if(threadLocal.get()==null){
            threadLocal.set(SSF != null ? SSF.openSession() : null);
        }
        return threadLocal.get();
    }

}
