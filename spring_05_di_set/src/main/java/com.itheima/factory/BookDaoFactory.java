package com.itheima.factory;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;

public class BookDaoFactory {
    public BookDao getBookDao() {
        return new BookDaoImpl();
    }
}
