package com.cloud.web.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long userId;

    /**
     * 名称
     */
    private String userName;

    /**
     * 密码
     */
    private String userPass;

    private Date userDate;


}
