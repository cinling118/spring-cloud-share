package com.cloud.service.service.impl;

import com.cloud.service.entity.User;
import com.cloud.service.mapper.UserMapper;
import com.cloud.service.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void test1() {
        List<String> list = new ArrayList<String>();
        //生产一个3.4M左右的List
        int i = 0;
        for (int j = 0; j < 100000; j++) {
            list.add(new String("我是中国人 我为中国骄傲"));
        }
    }

    @Override
    public void test2() {
//        int sum = 0;
//        for (int j = 0; j < 10000; j++) {
//            sum +=j;
//        }
        StopWatch stopWatch = new StopWatch("查询、sleep(500)、再更新任务耗时");
        stopWatch.start("任务一");
        User user = userMapper.selectById(10000);
        user.setUserDate(new Date());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userMapper.updateById(user);
        stopWatch.stop();
        System.err.println(stopWatch.prettyPrint());
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
}
