package com.cloud.service.mapper;

import com.cloud.service.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public List<User> findAllUser();
}
