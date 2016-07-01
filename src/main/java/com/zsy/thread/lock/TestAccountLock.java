package com.zsy.thread.lock;

public class TestAccountLock {
    public static void main(String[] args) {
        Account account = new Account("12345", 2000);
        account.draw(800);
    }
}
