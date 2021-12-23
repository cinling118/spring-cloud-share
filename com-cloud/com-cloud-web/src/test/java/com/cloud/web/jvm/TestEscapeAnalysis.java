package com.cloud.web.jvm;

/**
 * -server -XMX10m -Xms10m -XX:+PrintGC
 * 1、开启栈上分配： -XX:+DoEscapeAnalysis -XX:+EliminateAllocations
 * 2、关闭TLAB(线程本地分配缓存)分配： -XX:-UseTLAB
 */
public class TestEscapeAnalysis {
    class User{
        public int id;
        public String name;
    }
    public void test() {
        User user=new User();
        user.id=1;
        user.name="sixtrees";
    }
    public static void main(String[] args) {
        System.out.println("start-----------");
        long beginTime=System.currentTimeMillis();
        TestEscapeAnalysis pos=new TestEscapeAnalysis();
        for(int i=0;i<100000000;i++)
        {
            pos.test();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("总共运行----"+(endTime-beginTime)+"ms");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
        }
    }

}