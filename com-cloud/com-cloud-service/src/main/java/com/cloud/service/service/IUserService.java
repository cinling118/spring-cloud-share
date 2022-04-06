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
    public void test1() throws Exception;
    public void test2();
    public long add(String userName, String passWord);

    public List<User> findAllUser2();
    public void forInsert(List<User> list);
    public void batchInsert(List<User> list);
    public void forUpdate(List<User> list);
    public void batchUpdate(List<User> list);
    public List<User> forSelect(List<Long> userIdList);
    public List<User> selectByIdList(List<Long> userIdList);
    public void forDelete(List<Long> userIdList);
    public void deleteByIdList(List<Long> userIdList);

    public List<User> test11();
    public List<User> test22();
}
