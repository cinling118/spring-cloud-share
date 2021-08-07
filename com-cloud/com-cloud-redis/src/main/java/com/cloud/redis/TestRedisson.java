package com.cloud.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @Description: redis分布式缓存锁
*/
public class TestRedisson {
    public static void main(String[] args) {
        Config config = new Config();
        //本地单个节点
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        config.useSingleServer().setPassword("123456");

        //本地集群，哨兵模式
//        config.useSentinelServers().setMasterName("mymaster").addSentinelAddress("redis://127.0.0.1:26479","redis://127.0.0.1:26579", "redis://127.0.0.1:26379");
//        config.useClusterServers().addNodeAddress("redis://127.0.0.1:26379","redis://127.0.0.1:26479", "redis://127.0.0.1:26579");
        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("lock1");
        boolean isLock = false;
        try{
            isLock = lock.tryLock(10L,TimeUnit.SECONDS);
            if (isLock) {
                System.out.println("正在处理业务");
                Thread.sleep(5000);
                System.out.println("处理业务完毕");
            }
//            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }
}
