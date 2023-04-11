package com.sc.app.convert.job;

import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobPositionConvert {
    JobPositionConvert INSTANCE = Mappers.getMapper(JobPositionConvert.class);

    JobPositionDO convert(JobPositionPageQueryReqVO jobPositionPageQueryReqVO);

    List<JobPositionResVO> convert(List<JobPositionDO> records);

    JobPositionDO convert(JobPositionCreateReqVO jobPositionCreateReqVO);

    JobPositionResVO convert(JobPositionDO jobPositionDO);

    JobPositionDO convert(JobPositionUpdateReqVO jobPositionUpdateReqVO);

    JobPositionDO convert(JobPositionQueryReqVO jobPositionQueryReqVO);

}
