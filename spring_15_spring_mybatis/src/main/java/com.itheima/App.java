package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        //1、创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2、加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //3、创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5、执行SQLSession对象执行查询，获取User
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account ac = accountDao.findById(1);
        System.out.println(ac);
        //6、释放资源
        sqlSession.close();
    }
}