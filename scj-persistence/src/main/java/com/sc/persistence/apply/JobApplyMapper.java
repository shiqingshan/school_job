package com.sc.persistence.apply;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.model.entity.apply.JobApplyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description 针对表【scj_job_apply(应聘信息表)】的数据库操作Mapper
* @createDate 2023-03-25 13:53:02
* @Entity com.sc.persistence.app.dao.dataobject.apply.JobApply
*/
public interface JobApplyMapper extends BaseMapper<JobApplyDO> {

    Page<JobApplyDO> selectPageByCoId(Page<JobApplyDO> page, @Param("coIds") List<String> coIds);
}




