package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.entity.User;
import com.cloud.service.mapper.UserMapper;
import com.cloud.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public static List<String> staticList = new ArrayList<>();

    public static Map<Long, User> userMap = new HashMap<>();

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void test1() throws Exception {
        List<String> list = new ArrayList<String>();
        //生产一个3.4M左右的List
        int i = 0;
        for (int j = 0; j < 100000; j++) {
            list.add(new String("绝对不可能，我本地没有问题！"));
        }
    }

    @Override
    public void test2() {
//        int sum = 0;
//        for (int j = 0; j < 10000; j++) {
//            sum +=j;
//        }
//        synchronized (UserServiceImpl.class){
            StopWatch stopWatch = new StopWatch("查询、sleep(2500)、再更新任务耗时");
            stopWatch.start("任务一");
            User user = userMapper.selectById(10000);
            user.setUserDate(new Date());
            try {
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> list = new ArrayList<String>();
            //生产一个3.4M左右的List
            int i = 0;
            for (int j = 0; j < 20000; j++) {
                list.add(new String("我是程序猿"));
            }
            userMapper.updateById(user);
            stopWatch.stop();
            System.err.println(stopWatch.prettyPrint());
//        }
    }

    @Override
    public long add(String userName, String passWord) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPass(passWord);
        user.setUserDate(new Date());
        userMapper.insert(user);
//        System.out.println(2/0);//测试事务回滚
        return user.getUserId();
    }
    @Override
    public List<User> findAllUser2() {
        try {
            this.test1();//生产一个3.4M左右的list
            Thread.sleep(2000);
        } catch (Exception e) {
        } finally {
        }
        return userMapper.findAllUser();
    }


    /**
     * 优化前：循环insert
    */
    public void forInsert(List<User> list){
        for (User user : list) {
            userMapper.insert(user);
        }
    }

    /**
     * 优化后：批量insert
    */
    public void batchInsert(List<User> list){
        userMapper.batchInsert(list);
    }

    /**
     * 优化前：循环update
     */
    public void forUpdate(List<User> list){
        for (User user : list) {
            userMapper.updateUserById(user);
        }
    }

    /**
     * 优化后：批量update
     */
    public void batchUpdate(List<User> list){
        userMapper.batchUpdate(list);
    }

    /**
     * 优化前：循环查询
     */
    public List<User> forSelect(List<Long> userIdList){
        List<User> userList = new ArrayList<>();
        for (Long userId : userIdList) {
            userList.add(userMapper.selectUserById(userId));
        }
        return userList;
    }

    /**
     * 优化后：批量查询
     */
    public List<User> selectByIdList(List<Long> userIdList){
        return userMapper.selectByIdList(userIdList);
    }

    /**
     * 优化前：循环删除
     */
    public void forDelete(List<Long> userIdList){
        for (Long userId : userIdList) {
            userMapper.deleteById(userId);
        }
    }

    /**
     * 优化后：批量查询
     */
    public void deleteByIdList(List<Long> userIdList){
        userMapper.deleteByIdList(userIdList);
    }

    @Override
    public List<User> test11() {
        //----生产一个3.4M左右的List-begin---
        List<String> list = new ArrayList<String>();
        int i = 0;
        for (int j = 0; j < 100000; j++) {
            list.add(new String("绝对不可能，我本地没有问题！"));
        }
        list= null;
        //----生产一个3.4M左右的List-end---
        try {
            Thread.sleep(1000);//模拟查询数据：1秒
        } catch (Exception e) {
        }
        List<Long> userIdList = new ArrayList<>();
        for (long j = 21;j<=30;j++) {
            userIdList.add(j);
        }
        return userMapper.selectByIdList(userIdList);
    }

    /**
     * 代码优化：
    */
    @Override
    public List<User> test22() {
        this.testJVM();//生产一个3.4M左右的list
        try {
            Thread.sleep(1000);//模拟查询数据：1秒
        } catch (Exception e) {
        }
        List<Long> userIdList = new ArrayList<>();
        for (long j = 21;j<=30;j++) {
            userIdList.add(j);
        }
        return userMapper.selectByIdList(userIdList);
    }

    /**
     * 生产一个3.4M左右的List
    */
    private void testJVM(){
        List<String> list = new ArrayList<String>();
        int i = 0;
        for (int j = 0; j < 100000; j++) {
            list.add(new String("绝对不可能，我本地没有问题！"));
        }
    }
}
