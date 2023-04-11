package com.sc.app.service.resume;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.model.entity.resume.UserResumeFileDO;
import com.sc.model.entity.resume.vo.UserResumeFileCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;

/**
* 
* @description 针对表【scj_user_resume_file(用户简历表文件表)】的数据库操作Service
* @createDate 2023-04-02 13:06:55
*/
public interface IUserResumeFileService extends IService<UserResumeFileDO> {
    UserResumeFileResVO addUserResumeFile(UserResumeFileCreateReqVO userResumeCreateReqVO);

    UserResumeFileResVO updateUserResumeFile(UserResumeFileUpdateReqVO userResumeUpdateReqVO);
}
