package com.cloud.web.thread;

import jodd.datetime.TimeUtil;

import java.util.concurrent.*;

/**
 *corePoolSize：核心线程数
 *         核心线程会一直存活，即使没有任务需要执行
 *        当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理
 *        设置allowCoreThreadTimeout=true（默认false）时，核心线程会超时关闭
 *
 * queueCapacity：任务队列容量（阻塞队列）
 *         当核心线程数达到最大时，新任务会放在队列中排队等待执行
 *
 * maxPoolSize：最大线程数
 *        当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务
 *        当线程数=maxPoolSize，且任务队列已满时，线程池会拒绝处理任务而抛出异常
 *
 * keepAliveTime：线程空闲时间
 *        当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
 *       如果allowCoreThreadTimeout=true，则会直到线程数量=0
 *
 * allowCoreThreadTimeout：允许核心线程超时
 * rejectedExecutionHandler：任务拒绝处理器
 *
 * 线程池提供的拒绝策略：
*                 ThreadPoolExecutor.AbortPolicy：丢弃任务，抛运行时异常
*                ThreadPoolExecutor.CallerRunsPolicy：执行任务
*                ThreadPoolExecutor.DiscardPolicy：忽视，什么都不会发生
*                ThreadPoolExecutor.DiscardOldestPolicy：从队列中踢出最先进入队列（最后一个执行）的任务
*               实现RejectedExecutionHandler接口，可自定义处理器

 * 原文链接：https://blog.csdn.net/WoAiBianCheng123abc/article/details/82828980
 */
public class TestThreadPoolExecutor {
    private static ThreadPoolExecutor threadPoolExecutor = null;

    static {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        threadPoolExecutor = new ThreadPoolExecutor(10,10, 60, TimeUnit.SECONDS,workQueue);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
