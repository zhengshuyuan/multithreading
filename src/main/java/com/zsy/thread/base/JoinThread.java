package com.zsy.thread.base;

/**
 * 控制线程-join
 * 线程等待
 * @author zhengsy
 * 2016-6-2
 */
public class JoinThread extends Thread {
    
    //设置该线程的名字
    public JoinThread(String name){
        super(name);
    }
    
    @Override
    public void run() {
        for (int i=0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动子线程
        new JoinThread("新线程").start();
        for(int i=0;i<100;i++){
            if(i==20){
                JoinThread jThread = new JoinThread("被JOIN的线程");
                jThread.start();
                //mina线程调用了jThread线程的join方法，main必须等待jThread执行结束才回继续执行
                jThread.join();
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

}
