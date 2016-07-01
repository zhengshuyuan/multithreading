package com.zsy.thread.local;

public class Account {

    /**
     * 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
     * 每个线程都会保留该变量的一个副本
     */
    private ThreadLocal<String> name = new ThreadLocal<String>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("------"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
    
    
    
}
