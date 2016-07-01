package com.zsy.thread.base;

/**
 * yeild例子
 * 
 * @author zhengsy 2016-6-28
 */
public class TestYield extends Thread {

    public TestYield() {

    }

    public TestYield(String name) {
        super(name);
    }

    // 定义run方法作为线程执行体
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            // 当i==20,当前线程让步
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        // 启动两条并发线程
        TestYield ty1 = new TestYield("高级");
        ty1.setPriority(Thread.MAX_PRIORITY);
        ty1.start();
        TestYield ty2 = new TestYield("低级");
        ty2.setPriority(Thread.MIN_PRIORITY);
        ty2.start();
    }

}
