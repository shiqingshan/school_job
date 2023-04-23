package com.sc.web.controller.resume;

import com.sc.app.service.resume.IUserResumeFileService;
import com.sc.common.base.Result;
import com.sc.common.exception.ServiceException;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.resume.vo.UserResumeFileDownloadVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 用户简历文件
 */
@Api(tags = "用户简历文件")
@RequiredArgsConstructor
@RequestMapping("/user/resume/file")
@RestController
public class UserResumeFileController {
    private final IUserResumeFileService userResumeFileService;


    /**
     * 获取登录用户简历文件列表
     */
    @ApiOperation("获取用户简历文件列表")
    @GetMapping("/list")
    public Result<List<UserResumeFileResVO>> getLoginUserResumeFileList(){
        return ResultUtils.success("获取用户简历文件列表成功！",userResumeFileService.getLoginUserResumeFileList());
    }

    /**
     * 添加用户简历文件
     */
    @ApiOperation("添加用户简历文件")
    @PostMapping("/add")
    public Result<UserResumeFileResVO> addUserResumeFile(@RequestPart("file") MultipartFile multipartFile){
        return ResultUtils.success("添加用户简历文件成功！",userResumeFileService.addUserResumeFile(multipartFile));
    }

    /**
     * 更新用户简历文件
     * @param userResumeFileUpdateReqVO
     * @return
     */
    @ApiOperation("更新用户简历文件")
    @PostMapping("/update")
    public Result<UserResumeFileResVO> updateUserResumeFile(@RequestBody UserResumeFileUpdateReqVO userResumeFileUpdateReqVO){
        return ResultUtils.success("更新用户简历文件成功！",userResumeFileService.updateUserResumeFile(userResumeFileUpdateReqVO));
    }

    /**
     * 删除用户简历文件
     * @param id
     * @return
     */
    @ApiOperation("删除用户简历文件")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除用户简历文件成功！",userResumeFileService.removeById(id));
    }
    /**
     * 下载用户简历文件
     */
    @ApiOperation("下载用户简历文件")
    @PostMapping("/download")
    public void downloadUserResumeFile(String id, HttpServletResponse response) throws IOException, ServiceException {
        UserResumeFileDownloadVO userResumeFileResVO=userResumeFileService.downloadUserResumeFile(id);
        // 清空response
        response.reset();
        // 设置response的Header
        response.setCharacterEncoding("UTF-8");
        //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
        //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
        // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(userResumeFileResVO.getFileName(), "UTF-8"));
        // 告知浏览器文件的大小
        response.addHeader("Content-Length", "" + userResumeFileResVO.getResumeFile().length);
        @Cleanup OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        outputStream.write(userResumeFileResVO.getResumeFile());
        outputStream.flush();
    }
}
