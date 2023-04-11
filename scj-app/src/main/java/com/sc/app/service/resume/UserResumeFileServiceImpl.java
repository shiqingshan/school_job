package com.sc.app.service.resume;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.resume.UserResumeFileConvert;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.resume.UserResumeFileDO;
import com.sc.model.entity.resume.vo.UserResumeFileCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;
import com.sc.persistence.resume.UserResumeFileMapper;
import org.springframework.stereotype.Service;

/**
* 
* @description 针对表【scj_user_resume_file(用户简历文件表)】的数据库操作Service实现
* @createDate 2023-04-02 13:06:55
*/
@Service
public class UserResumeFileServiceImpl extends ServiceImpl<UserResumeFileMapper, UserResumeFileDO>
    implements IUserResumeFileService {

    /**
     * @param userResumeCreateReqVO
     * @return
     */
    @Override
    public UserResumeFileResVO addUserResumeFile(UserResumeFileCreateReqVO userResumeCreateReqVO) {
        UserResumeFileDO userResumeFileDO = UserResumeFileConvert.INSTANCE.convert(userResumeCreateReqVO);
        if(save(userResumeFileDO)){
            return UserResumeFileConvert.INSTANCE.convert(userResumeFileDO);
        }
        throw new ServiceException("添加用户简历文件失败");
    }

    /**
     * @param userResumeUpdateReqVO
     * @return
     */
    @Override
    public UserResumeFileResVO updateUserResumeFile(UserResumeFileUpdateReqVO userResumeUpdateReqVO) {
        UserResumeFileDO userResumeFileDO = UserResumeFileConvert.INSTANCE.convert(userResumeUpdateReqVO);
        if(updateById(userResumeFileDO)){
            return UserResumeFileConvert.INSTANCE.convert(userResumeFileDO);
        }
        throw new ServiceException("修改用户简历文件失败");
    }
}




