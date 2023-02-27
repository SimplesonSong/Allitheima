package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private int ConnectionNum;
    private String ConnectionName;

    public void setConnectionNum(int connectionNum) {
        ConnectionNum = connectionNum;
    }

    public void setConnectionName(String connectionName) {
        ConnectionName = connectionName;
    }


//    public BookDaoImpl() {
//        System.out.println("book dao constructor is running...");
//    }

    public void save(){
        System.out.println("book dao save..."+ConnectionName+","+ConnectionNum);
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
