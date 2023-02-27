package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.dao.OrderDao;
import com.itheima.factory.OrderDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder {
    public static void main(String[] args) {
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        orderDao.save();
    }
}
