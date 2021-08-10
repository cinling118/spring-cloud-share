package com.cloud.web.io;

//定义一个runnable接口的实现类
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description: 多线程读取文件
*/
public class ThreadReadFile implements Runnable{
    //定义文件读取的游标位置
    private static int now=0;
    //定义即将被读取的文件
    static File file=new File("C:\\Users\\admin\\Desktop\\log\\error.txt");
    //使用io包中的RandomAccessFile类，支持文件的随机访问
    static RandomAccessFile raf=null;
    //定义每次读取的字节数
    final static int len=256;
    //
    private boolean readFinish = false;

    ThreadReadFile() throws IOException{
        raf=new RandomAccessFile(file, "rw");
    }
    @Override
    public void run() {
        while(true){
            try {
                //synchronized实现多线程的同步
                synchronized (raf) {
                    //将文件内容读取到b字节数组中
                    byte[] b = new byte[len];
                    //设置游标位置
                    raf.seek(now);
                    int temp=raf.read(b);
                    //如果没读取到，就结束线程
                    if(temp==-1){
                        readFinish = true;
                        return ;
                    }
                    //设置游标偏移量
                    now+=temp;
                    //打印文件内容
                    System.out.println(Thread.currentThread().getName() + ":" + new String(b));
                }


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public boolean isReadFinish() {
        return readFinish;
    }

    public void setReadFinish(boolean readFinish) {
        this.readFinish = readFinish;
    }

    public static void main(String[] args) throws IOException {
        ThreadReadFile run=new ThreadReadFile();
        StopWatch watch = new StopWatch();
        watch.start();
        new Thread(run,"thread1").start();
        new Thread(run,"thread2").start();
        new Thread(run,"thread3").start();
//        new Thread(run,"thread4").start();
//        new Thread(run,"thread5").start();
//        new Thread(run,"thread6").start();
        while (true){
            System.out.println("等待结果");
            if (run.isReadFinish()) {
                watch.stop();
                System.out.println("共执行：" + watch.getTotalTimeSeconds() + "秒");
                return;
            }
        }
    }
}