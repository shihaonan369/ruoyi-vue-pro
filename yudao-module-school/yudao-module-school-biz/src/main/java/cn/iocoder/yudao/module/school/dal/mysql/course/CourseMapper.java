package cn.iocoder.yudao.module.school.dal.mysql.course;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.course.CourseDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.course.vo.*;

/**
 * 课程 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CourseMapper extends BaseMapperX<CourseDO> {

    default PageResult<CourseDO> selectPage(CoursePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CourseDO>()
                .likeIfPresent(CourseDO::getName, reqVO.getName())
                .eqIfPresent(CourseDO::getIntroduction, reqVO.getIntroduction())
                .eqIfPresent(CourseDO::getTeachingMode, reqVO.getTeachingMode())
                .eqIfPresent(CourseDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CourseDO::getId));
    }

    default List<CourseDO> selectList(CourseExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CourseDO>()
                .likeIfPresent(CourseDO::getName, reqVO.getName())
                .eqIfPresent(CourseDO::getIntroduction, reqVO.getIntroduction())
                .eqIfPresent(CourseDO::getTeachingMode, reqVO.getTeachingMode())
                .eqIfPresent(CourseDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CourseDO::getId));
    }

}
