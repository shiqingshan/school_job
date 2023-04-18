package com.sc.model.entity.apply.vo;

import com.sc.model.entity.job.vo.JobInfoResVO;
import lombok.Data;

import java.util.Date;

@Data
public class JobApplyBaseVO {
    /**
     * 应聘用户ID
     */
    private String userId;

    /**
     * 招聘信息ID
     */
    private String jobId;

    private JobInfoResVO jobInfo;

    /**
     * 应聘日期
     */
    private Date applyDate;

    /**
     * 应聘状态
     */
    private Integer status;

    /**
     * 简历ID
     */
    private String resumeId;

    /**
     * 简历文件ID
     */
    private String resumeFileId;
}
