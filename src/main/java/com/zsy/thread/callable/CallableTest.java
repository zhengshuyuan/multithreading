package com.zsy.thread.callable;

import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        //创建Callable对象
        RtnThread rtnThread = new RtnThread();
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>(rtnThread);
        
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"的循环变量i的值："+i);
            
            if(i==20){
                //实质上还是以Callable对象来创建并启动线程
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            //获取线程返回值
            System.out.println("子线程的返回值："+task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
