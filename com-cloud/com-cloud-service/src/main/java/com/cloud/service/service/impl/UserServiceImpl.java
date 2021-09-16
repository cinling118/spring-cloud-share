package com.cloud.service.service.impl;

import com.cloud.service.entity.User;
import com.cloud.service.mapper.UserMapper;
import com.cloud.service.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //生产一个34M左右的List
        int i = 0;
        for (int j = 0; j < 1000000; j++) {
            list.add(new String("我是中国人 我为中国骄傲"));
        }
        try {
            Thread.sleep(20000);//让线程等待20秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
