package com.cloud.web.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecute {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            ExeThreads ex = new ExeThreads();
            exe.execute(ex);
        }
        exe.shutdown();
    }

}

class ExeThreads implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("run start-----------------" + System.currentTimeMillis());
            Thread.sleep(15 * 1000);
            System.out.println("run end-----------------" + System.currentTimeMillis());

        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}