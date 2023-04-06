package com.sc.model.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.*;

/**
 * 
 * @TableName scj_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO extends BaseDO implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮箱地址
     */
    private String emailAddr;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}