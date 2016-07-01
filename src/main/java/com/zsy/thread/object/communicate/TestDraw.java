package com.zsy.thread.object.communicate;

/**
 * 主程序
 * 
 * @author zhengsy 2016-6-30
 */
public class TestDraw {
    
    public static void main(String[] args) {
        //创建一个账户
        Account acct = new Account("1234567", 0);
        new DrawThread("取钱者", acct, 800).start();
        new DepositThread("存款者甲", acct, 800).start();
        new DepositThread("存款者乙", acct, 800).start();
        new DepositThread("存款者丙", acct, 800).start();
    }
}
