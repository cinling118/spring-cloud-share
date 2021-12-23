package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.entity.User;
import com.cloud.service.mapper.UserMapper;
import com.cloud.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.lang.reflect.Field;
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
        //打印占用内存大小
//        Field f = ArrayList.class.getDeclaredField("elementData");
//        f.setAccessible(true);
//        Object[] o = (Object[]) f.get(list);
//        String result = "测试RAM结束，测试占用内存空间约为 : " + ((long)o.length * (long)"我是中国人 我为中国骄傲".length() * 2);
//        System.out.println(result);
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
}
