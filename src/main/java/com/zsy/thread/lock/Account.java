package com.zsy.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock保证线程安全
 * @author zhengsy
 * 2016-6-29
 */
public class Account {
    private String accountNo;   //账户编号
    private double balance;     //账户余额
    
    private final ReentrantLock lock = new ReentrantLock();//锁机制


    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    public void draw(double drawAmount) {
        lock.lock();//对同步锁加锁
        try {
            if (balance >= drawAmount) {

                System.out.println(Thread.currentThread().getName() + "\t 取钱成功！取的金额为：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改余额
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "账户余额为：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 余额不足");
            } 
        }finally{
            lock.unlock();//使用finally来确保释放锁
        }
    }

    public int hashCode(){
        return accountNo.hashCode();
    }
    
    public boolean equals(Object obj){
        if(obj != null && obj.getClass() == Account.class){
            Account account = (Account)obj;
            return account.getAccountNo().equals(accountNo);
        }
        return false;
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
