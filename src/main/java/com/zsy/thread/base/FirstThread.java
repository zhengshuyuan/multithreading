package com.zsy.thread.base;


/**
 * 通过继承Thread来创建线程
 * 
 * @author zhengsy 2016-6-2
 */
public class FirstThread extends Thread {

    private int i;//实例属性，而非局部变量，线程间不共享

    /**
     * 线程执行体
     */
    @Override
    public void run() {
        // getName()返回当前线程的名；
        // this 获取当前线程
        for (; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            
            if(i == 20){
                //创建并启动两条线程
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }

}
