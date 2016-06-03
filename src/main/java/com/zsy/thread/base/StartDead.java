package com.zsy.thread.base;

/**
 * 测试某条线程是否已经死亡,isAlive()
 * @author zhengsy
 * 2016-6-2
 */
public class StartDead extends Thread {

    private int i;

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
        //创建线程
        StartDead sdDead = new StartDead();
        for(int i=0;i<300;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i==20){
                //启动线程
                sdDead.start();
                //判断启动后线程的isAlive值，输出true;
                System.out.println(sdDead.isAlive());
            }
            if(i>20 && !sdDead.isAlive()){
                //线程死亡后，再执行start，抛出java.lang.IllegalThreadStateException
                sdDead.start();
            }
        }
    }

}
