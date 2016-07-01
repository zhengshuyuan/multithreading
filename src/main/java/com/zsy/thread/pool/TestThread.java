package com.zsy.thread.pool;

// 定义一个简单的线程类
public class TestThread implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的i值为：" + i);
        }

    }

}
