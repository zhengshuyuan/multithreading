package com.zsy.thread.object.communicate;


/**
 * 模拟用户存钱，取钱
 * @author zhengsy
 * 2016-6-29
 */
public class Account {
    private String accountNo;   //账户编号
    private double balance;     //账户余额
    //标识账户中是否已有存款的旗标
    private boolean flag = false;
    
    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 取钱成功！取的金额为：" + drawAmount);
                // 修改余额
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "账户余额为：" + balance);
                //将标识设置为false
                flag = false;
                //唤醒其他线程；
                notifyAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    public synchronized void deposit(double depositAmount){
        try{
            if(flag){
                wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"存款："+depositAmount);
                balance += depositAmount;
                flag = true;
                notifyAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
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
