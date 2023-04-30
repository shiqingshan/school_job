package com.sc.app.convert.job;

import com.sc.model.entity.job.JobDetailDO;
import com.sc.model.entity.job.vo.JobDetailCreateReqVO;
import com.sc.model.entity.job.vo.JobDetailResVO;
import com.sc.model.entity.job.vo.JobDetailUpdateReqVO;
import com.sc.model.entity.job.vo.JobInfoCreateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobDetailConvert {
    JobDetailConvert INSTANCE = Mappers.getMapper(JobDetailConvert.class);

    List<JobDetailResVO> convert(List<JobDetailDO> records);

    JobDetailDO convert(JobDetailCreateReqVO jobPositionCreateReqVO);

    JobDetailResVO convert(JobDetailDO jobPositionDO);

    JobDetailDO convert(JobDetailUpdateReqVO jobPositionUpdateReqVO);

    JobDetailDO convert(JobInfoCreateReqVO jobInfoCreateReqVO);

    JobDetailDO convert(JobDetailResVO jobDetail);
}
