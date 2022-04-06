package com.cloud.web;

import com.cloud.web.thread.TestThreadPoolExecutor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenzhiyun
 * @Title: TestJVM
 * @ProjectName: com-cloud
 * @Description:
 * @date: 2021/12/29 9:02
 */
public class TestJVM {
    public static void main(String[] args) throws  Exception{
//        com.google.common.base.Stopwatch stopwatch = com.google.common.base.Stopwatch.createStarted();
//        test();
//        Thread.sleep(100);
//        System.out.println("--------方法1耗时-----：{}" + stopwatch.elapsed(TimeUnit.MILLISECONDS) );
//        stopwatch.reset();
//        stopwatch.start();
//        int i = 1;
//        int j = i++;
//        int k = i+++i*i++;
//        System.out.println("i=" + i);
//        System.out.println("j=" + j);
//        System.out.println("k=" + k);
//        Thread.sleep(10);
//        System.out.println("--------方法2耗时-----：{}" + stopwatch.elapsed(TimeUnit.MILLISECONDS) );
        System.out.println(new Date(1647250688L));
        System.out.println(new Date(16472510545L));
        System.out.println(System.currentTimeMillis());
    }

    public static void test(){
        int yonyou=5;
        System.out.println("test" + yonyou);
    }
}
