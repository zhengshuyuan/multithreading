package com.zsy.thread.syn;


/**
 * 收钱线程类，该线程根据执行账户，取钱数量进行取钱操作，取钱的逻辑是当其 余额不足时无法提取现金，当余额足够时，系统吐出钞票，余额减少；
 * 
 * @author zhengsy 2016-6-29
 */
public class DrawThread extends Thread {

    private Account account; // 模拟用户账户
    private double drawAmount; // 当前取钱线程所希望取的钱数

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 当账户余额大于取钱数
        /**
         * 使用account作为同步监视器，任何线程进入下面同步代码块之间，必须先获得对account
         * 账户的的锁定-其他线程无法获得锁，就无法修改它 这种做法符合：加锁-》修改完成——》释放锁 逻辑
         */
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {

                System.out.println(Thread.currentThread().getName() + "\t 取钱成功！取的金额为：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改余额
//                account.setBalance(account.getBalance() - drawAmount);
                System.out.println(Thread.currentThread().getName() + "账户余额为：" + account.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 余额不足");
            }
        }
    }

}
