package com.zsy.thread.piped.communication;

import java.io.IOException;
import java.io.PipedWriter;

public class WriterThread extends Thread {
        String[] books = new String[] { "Struts2", "ROR敏捷开发", "基于J2EE的Ajax宝典", "轻量级J2EE企业应用指南" };

        private PipedWriter pipedWriter;

        public WriterThread(PipedWriter pipedWriter) {
            super();
            this.pipedWriter = pipedWriter;
        }

        public WriterThread() {
            super();
        }

        @Override
        public void run() {
            try {
                // 循环100次，像管道输出流中写入100个字符
                for (int i = 0; i < 100; i++) {
                    String message = books[i % 4];
                    pipedWriter.write(message + "\n");
                    System.out.println("我发送到WriteThread的消息："+ message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pipedWriter != null) {
                        pipedWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }