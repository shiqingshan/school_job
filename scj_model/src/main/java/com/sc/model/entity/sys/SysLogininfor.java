package com.sc.model.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统访问记录
 * @TableName scj_sys_logininfor
 */
@TableName(value ="scj_sys_logininfor")
@Data
public class SysLogininfor implements Serializable {
    /**
     * 访问ID
     */
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    /**
     * 用户账号
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 登录IP地址
     */
    @TableField(value = "ipaddr")
    private String ipaddr;

    /**
     * 登录地点
     */
    @TableField(value = "login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    @TableField(value = "browser")
    private String browser;

    /**
     * 操作系统
     */
    @TableField(value = "os")
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 提示消息
     */
    @TableField(value = "msg")
    private String msg;

    /**
     * 访问时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}