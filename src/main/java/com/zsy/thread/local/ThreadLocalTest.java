package com.zsy.thread.local;

public class ThreadLocalTest {

    public static void main(String[] args) {
        //启动两条线程，共享一个account
        Account at = new Account("初始名");
        
        new MyTest(at, "线程1").start();
        new MyTest(at, "线程2").start();
    }

}
