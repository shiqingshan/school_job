package com.sc.app.service.resume;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.resume.UserResumeFileConvert;
import com.sc.app.service.TokenService;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.resume.UserResumeFileDO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;
import com.sc.persistence.resume.UserResumeFileMapper;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* 
* @description 针对表【scj_user_resume_file(用户简历文件表)】的数据库操作Service实现
* @createDate 2023-04-02 13:06:55
*/
@Service
@RequiredArgsConstructor
public class UserResumeFileServiceImpl extends ServiceImpl<UserResumeFileMapper, UserResumeFileDO>
    implements IUserResumeFileService {
    private final TokenService tokenService;
    /**
     * @param multipartFile@return
     */
    @SneakyThrows
    @Override
    public UserResumeFileResVO addUserResumeFile(MultipartFile multipartFile) {
        LoginUserInfo loginUser = tokenService.getLoginUser();

        UserResumeFileDO userResumeFileDO = new UserResumeFileDO();
        userResumeFileDO.setUserId(loginUser.getUserId());
        userResumeFileDO.setResumeFile(multipartFile.getBytes());
        userResumeFileDO.setFileName(multipartFile.getOriginalFilename());
        userResumeFileDO.setFileType(multipartFile.getContentType());
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

    /**
     * @return
     */
    @Override
    public List<UserResumeFileResVO> getLoginUserResumeFileList() {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        if(loginUser != null){
            List<UserResumeFileDO> userResumeFileDOList = list(new LambdaQueryWrapper<UserResumeFileDO>().eq(UserResumeFileDO::getUserId, loginUser.getUserId()));
            return UserResumeFileConvert.INSTANCE.convert(userResumeFileDOList);
        }
        return Collections.emptyList();
    }
}




