package com.zsy.thread.lock.communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.omg.IOP.Codec;

/**
 * 使用condition对象来控制线程协调运行
 * @author zhengsy
 * 2016-6-30
 */
public class Account {
    
    //显式定义Lock对象
    private final Lock lock = new ReentrantLock();
    //获得指定Lock对象所对应的条件变量
    private final Condition condition = lock.newCondition();
    
    private String accountNo;
    private double balance;
    
    //标识是否有存款
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Account() {}
    
    public void draw(double drawAmount){
        //加锁
        lock.lock();
        try {
            if(!flag){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 取钱成功！取的金额为：" + drawAmount);
                // 修改余额
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "账户余额为：" + balance);
                //将标识设置为false
                flag = false;
                //唤醒其他线程；
                condition.signalAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public void deposit(double depositAmount){
        lock.lock();
        try{
            if(flag){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName()+"存款："+depositAmount);
                balance += depositAmount;
                flag = true;
                condition.signalAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }
    
}
