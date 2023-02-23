package cn.iocoder.yudao.module.school.dal.mysql.coursefee;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;

/**
 * 课程收费 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CourseFeeMapper extends BaseMapperX<CourseFeeDO> {

    default PageResult<CourseFeeDO> selectPage(CourseFeePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CourseFeeDO>()
                .eqIfPresent(CourseFeeDO::getType, reqVO.getType())
                .eqIfPresent(CourseFeeDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CourseFeeDO::getCourseId, reqVO.getCourseId())
                .orderByDesc(CourseFeeDO::getId));
    }

    default List<CourseFeeDO> selectList(CourseFeeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CourseFeeDO>()
                .eqIfPresent(CourseFeeDO::getType, reqVO.getType())
                .eqIfPresent(CourseFeeDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CourseFeeDO::getCourseId, reqVO.getCourseId())
                .orderByDesc(CourseFeeDO::getId));
    }

}
