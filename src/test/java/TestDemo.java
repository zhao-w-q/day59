import com.dfbz.dao.StudentDao;
import com.dfbz.dao.TbResultDao;
import com.dfbz.entity.Student;
import com.dfbz.entity.TbResult;
import com.dfbz.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao
 * @description
 * @date 2019/11/4
 */
public class TestDemo {

    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    private StudentDao dao = sqlSession.getMapper(StudentDao.class);
    private TbResultDao tDao = sqlSession.getMapper(TbResultDao.class);

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setStuName("小明");
        s1.setStuAge(22);
        s1.setStuPassword("2345");
        s2.setStuName("小红");
        s3.setStuName("小东");
        s3.setStuAge(33);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        dao.batchInsert(list);
    }

    @Test
    public void test2() {
        dao.deleteByIds(1036, 1037, 1038);
    }

    @Test
    public void test3() {
        Student s1 = new Student();
        s1.setStuName("小明");
        s1.setStuPassword("2345");
        s1.setStuId(1029);
        dao.updateByNotnull(s1);
    }

    @Test
    public void test4() {
        Student s1 = new Student();
        s1.setStuName("无情");
        dao.findByCondition(s1);
    }

    @Test
    public void test5() {
        TbResult tr = tDao.findById(1L);
//        System.out.println(tr);
//        System.out.println(tr.getStudent());
    }

    @Test
    public void test6(){
        List<Student> list = dao.findAll();
        for(Student s:list){
            System.out.println(s);
            System.out.println(s.getTbResults());
        }
    }
}
