package com.sc.app.convert.apply;

import com.sc.model.entity.apply.JobApplyDO;
import com.sc.model.entity.apply.vo.JobApplyCreateReqVO;
import com.sc.model.entity.apply.vo.JobApplyPageQueryReqVO;
import com.sc.model.entity.apply.vo.JobApplyResVO;
import com.sc.model.entity.apply.vo.JobApplyUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobApplyConvert {
    JobApplyConvert INSTANCE = Mappers.getMapper(JobApplyConvert.class);

    JobApplyDO convert(JobApplyPageQueryReqVO jobApplyPageQueryReqVO);

    List<JobApplyResVO> convert(List<JobApplyDO> records);

    JobApplyDO convert(JobApplyCreateReqVO jobApplyCreateReqVO);

    JobApplyResVO convert(JobApplyDO jobApplyDO);

    JobApplyDO convert(JobApplyUpdateReqVO jobApplyUpdateReqVO);
}
