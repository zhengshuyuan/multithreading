package com.zsy.thread.lock;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 死锁模拟
 * @author zhengsy
 * 2016-6-29
 */
public class DeadLock  implements Runnable{
    
    A a = new A();
    B b = new B();
    
    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入副线程之后");
    }
    public void run() {
        Thread.currentThread().setName("副线程");
        //调用b对象的bar方法
        b.bar(a);
        System.out.println("进入副线程之后");
    }
    
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        //以d1为target启动新线程
        new Thread(d1).start();
        //执行init方法作为新线程
        d1.init();
    }
    
    class A{
        public synchronized void foo(B b){
            System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了A实例的foo方法");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用B实例的last方法");
            b.last();
        }
        
        public synchronized void last(){
            System.out.println("进入A类的last方法内部");
        }
    }
    
    class B{
        public synchronized void bar(A a){
            System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了B实例的foo方法");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用A实例的last方法");
            a.last();
        }
        
        public synchronized void last(){
            System.out.println("进入B类的last方法内部");
        }
    }

}
