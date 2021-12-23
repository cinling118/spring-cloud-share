package com.cloud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenzhiyun
 * @Title: TestJad
 * @ProjectName: com-cloud
 * @Description:
 * @date: 2021/12/22 15:33
 */
public class TestJad {
    public static void main(String[] args) throws InterruptedException {
        TestJad test = new TestJad();
        while (true) {
            try {
                AtomicInteger i = new AtomicInteger();
                Runnable runnable = () -> {
                    i.getAndIncrement();
                };
                test.testLambda();
            } catch (NoClassDefFoundError e) {
                e.printStackTrace();
                Thread.sleep(2000);
            }
        }
    }

    public void testLambda(){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }
        list.forEach(integer -> System.out.println("value=" + integer));
    }
}
