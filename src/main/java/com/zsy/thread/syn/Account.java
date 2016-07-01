package com.zsy.thread.syn;

/**
 * 账户类
 * 
 * @author zhengsy 2016-6-29
 */
public class Account {

    private String accountNo;   //账户编号
    private double balance;     //账户余额


    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    public synchronized void draw(double drawAmount) {
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

//    public void setBalance(double balance) {
//        this.balance = balance;
//    }

}
