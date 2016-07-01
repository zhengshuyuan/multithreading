package com.zsy.thread.callable;

import java.util.concurrent.Callable;

public class RtnThread implements Callable<Integer> {

    /**
     * 实现call方法，作为线程执行体
     */
    public Integer call() throws Exception {
        int i=0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值："+i);
        }
        //call方法可以有返回值
        return i;
    }

}
