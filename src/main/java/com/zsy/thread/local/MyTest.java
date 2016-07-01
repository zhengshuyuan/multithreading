package com.zsy.thread.local;


public class MyTest extends Thread {
    
    //定义一个Account属性
    private Account account;

    public MyTest(Account account,String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            //当i==6时输出将账户名替代成当前线程名
            if(i==6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户的i的值："+i);
        }
    }
    
    
    
    
}
