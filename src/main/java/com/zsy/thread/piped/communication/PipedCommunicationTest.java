package com.zsy.thread.piped.communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 使用管道流来进行线程通信
 * @author zhengsy
 * 2016-6-30
 */
public class PipedCommunicationTest extends Thread {
    
    public static void main(String[] args) {
        PipedWriter pipedWriter;
        PipedReader pipedReader;
        
        try {
            //分别创建两个独立的管道输出流，输入流
            pipedWriter = new PipedWriter();
            pipedReader = new PipedReader();
            //连接管道输出流，出入流
            pipedWriter.connect(pipedReader);
            //将连接好的管道流分别传入两个线程；
            //就可以让两个线程通过管道流进行通信
            new ReaderThread(pipedReader).start();
            new WriterThread(pipedWriter).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
