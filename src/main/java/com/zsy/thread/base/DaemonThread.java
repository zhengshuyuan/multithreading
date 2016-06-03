package com.zsy.thread.base;

/**
 * 控制线程-守护线程
 * @author zhengsy
 * 2016-6-2
 */
public class DaemonThread extends Thread {
    
    @Override
    public void run() {
        for (int i=0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread thread = new DaemonThread();
        //将此线程设置成后台线程
        thread.setDaemon(true);
        //启动后台线程
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        //---程序执行到此处，前台线程main线程结束---
        //后台线程也应该随之结束
    }

}
