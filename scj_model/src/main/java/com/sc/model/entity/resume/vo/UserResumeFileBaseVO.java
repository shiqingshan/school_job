package com.sc.model.entity.resume.vo;


import lombok.Data;

@Data
public class UserResumeFileBaseVO {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

}
