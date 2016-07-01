package com.zsy.thread.piped.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

/**
 * 使用管道流来进行线程通信
 * 
 * @author zhengsy 2016-6-30
 */
public class ReaderThread extends Thread {

    private PipedReader pr;
    // 用于包装管道流的BufferReader对象
    private BufferedReader br;

    public ReaderThread(PipedReader pr) {
        super();
        this.pr = pr;
        this.br = new BufferedReader(pr);
    }

    @Override
    public void run() {
        String bufString = null;
        // 逐行读取管道输入流中的内容
        try {
            while ((bufString = br.readLine()) != null) {
                System.out.println("我收到WriteThread的消息："+bufString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }


    
}
