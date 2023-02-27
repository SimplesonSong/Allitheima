package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppClose {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        ctx.close();
    }
}
