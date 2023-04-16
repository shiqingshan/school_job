package com.sc.app.convert.job;

import com.sc.model.entity.job.JobDetailDO;
import com.sc.model.entity.job.JobInfoDO;
import com.sc.model.entity.job.vo.JobInfoCreateReqVO;
import com.sc.model.entity.job.vo.JobInfoPageQueryReqVO;
import com.sc.model.entity.job.vo.JobInfoResVO;
import com.sc.model.entity.job.vo.JobInfoUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobInfoConvert {
    JobInfoConvert INSTANCE = Mappers.getMapper(JobInfoConvert.class);

    JobInfoDO convert(JobInfoPageQueryReqVO jobPositionPageQueryReqVO);

    List<JobInfoResVO> convert(List<JobInfoDO> records);

    JobInfoDO convert(JobInfoCreateReqVO jobPositionCreateReqVO);

    JobInfoResVO convert(JobInfoDO jobPositionDO);

    JobInfoDO convert(JobInfoUpdateReqVO jobPositionUpdateReqVO);

    @Mapping(target = "id", source = "jobInfoDO.id")
    @Mapping(target = "createTime", source = "jobInfoDO.createTime")
    JobInfoResVO convert(JobInfoDO jobInfoDO, JobDetailDO jobDetailDO);

    @Mapping(target = "id",source = "jobDetailDO.id",ignore = true)
    void merge(@MappingTarget JobInfoResVO jobInfoResVO, JobDetailDO jobDetailDO);
}
