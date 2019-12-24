import com.dfbz.dao.StudentDao;
import com.dfbz.dao.TbResultDao;
import com.dfbz.entity.Student;
import com.dfbz.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Zhao
 * @description
 * @date 2019/11/5
 */
public class TestCache {

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_config.xml"));

        SqlSession session = sqlSessionFactory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student user1 = studentDao.findById(1001L);   //发送sql查询出来，放入一级缓存
        System.out.println(user1.getStuName());

        Student user2 = studentDao.findById(1001L);       //直接从一级缓存中查询(不发送sql)
        System.out.println(user2.getStuName());

        session.close();            //session关闭(此session的一级缓存销毁)

        SqlSession session2 = sqlSessionFactory.openSession();
        StudentDao userMapper2 = session2.getMapper(StudentDao.class);
        Student user3 = userMapper2.findById(1001L);          //发送sql查询一级缓存

        System.out.println(user3.getStuName());
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_config.xml"));

        SqlSession session = sqlSessionFactory.openSession();

        TbResultDao tb = session.getMapper(TbResultDao.class);
        tb.findById(1L);
        StudentDao mapper = session.getMapper(StudentDao.class);
        mapper.findAll();
        mapper.findById(1001L);
        mapper.findById(1003L);
        mapper.findById(1005L);
        mapper.findById(1006L);
        mapper.findById(1007L);
        session.close();

    }
}
