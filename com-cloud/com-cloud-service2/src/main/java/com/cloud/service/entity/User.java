package com.cloud.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "userId", type = IdType.AUTO)
    private Long userId;

    /**
     * 名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    @TableField("userPass")
    private String userPass;

    @TableField("userDate")
    private Date userDate;


}
