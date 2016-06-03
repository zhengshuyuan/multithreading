package com.zsy.thread.base;

/**
 * 通过实现Runnable接口来创建并启动多线程程序
 * 
 * @author zhengsy 2016-6-2
 */
public class SecondThread implements Runnable {

    private int i;

    public void run() {
        // 实现runnable接口时，想获取当前线程，只能用Thread.currentThread()方法
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            
            if(i == 20){
                SecondThread stSecondThread = new SecondThread();
                new Thread(stSecondThread, "新线程1").start();
                new Thread(stSecondThread, "新线程2").start();
            }
        }
    }

}
