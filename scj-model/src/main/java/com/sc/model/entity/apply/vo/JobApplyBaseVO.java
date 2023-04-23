package com.sc.model.entity.apply.vo;

import com.sc.model.entity.job.vo.JobInfoResVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.user.vo.UserResVO;
import lombok.Data;

import java.util.Date;

@Data
public class JobApplyBaseVO {
    /**
     * 应聘用户ID
     */
    private String userId;

    private UserResVO userInfo;

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
    private String status;

    /**
     * 简历ID
     */
    private String resumeId;

    /**
     * 简历文件ID
     */
    private String resumeFileId;

    private UserResumeFileResVO resumeFileInfo;
}
