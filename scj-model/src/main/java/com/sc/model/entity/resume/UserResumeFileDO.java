package com.sc.model.entity.resume;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户简历表文件表
 * @TableName scj_user_resume_file
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_user_resume_file")
@Data
public class UserResumeFileDO extends BaseDO implements Serializable {
    /**
     * 用户简历文件ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 文件名称
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 文件类型
     */
    @TableField(value = "file_type")
    private String fileType;


    /**
     * 简历文件
     */
    @TableField(value = "resume_file")
    private byte[] resumeFile;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}