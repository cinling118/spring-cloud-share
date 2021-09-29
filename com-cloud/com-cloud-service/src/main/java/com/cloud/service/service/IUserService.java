package com.cloud.service.service;

import com.cloud.service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
public interface IUserService extends IService<User> {
    public List<User> findAllUser();
    public void test1();
    public void test2();
    public long add(String userName, String passWord);
}
