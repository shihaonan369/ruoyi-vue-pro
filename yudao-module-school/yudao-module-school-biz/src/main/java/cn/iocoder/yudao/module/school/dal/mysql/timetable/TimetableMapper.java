package cn.iocoder.yudao.module.school.dal.mysql.timetable;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;

/**
 * 课程 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TimetableMapper extends BaseMapperX<TimetableDO> {

    default PageResult<TimetableDO> selectPage(TimetablePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TimetableDO>()
                .eqIfPresent(TimetableDO::getType, reqVO.getType())
                .betweenIfPresent(TimetableDO::getBeginDate, reqVO.getBeginDate())
                .betweenIfPresent(TimetableDO::getEndDate, reqVO.getEndDate())
                .betweenIfPresent(TimetableDO::getBeginTime, reqVO.getBeginTime())
                .betweenIfPresent(TimetableDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(TimetableDO::getClassId, reqVO.getClassId())
                .eqIfPresent(TimetableDO::getTeacherId, reqVO.getTeacherId())
                .eqIfPresent(TimetableDO::getClassroomId, reqVO.getClassroomId())
                .orderByDesc(TimetableDO::getId));
    }

    default List<TimetableDO> selectList(TimetableExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TimetableDO>()
                .eqIfPresent(TimetableDO::getType, reqVO.getType())
                .betweenIfPresent(TimetableDO::getBeginDate, reqVO.getBeginDate())
                .betweenIfPresent(TimetableDO::getEndDate, reqVO.getEndDate())
                .betweenIfPresent(TimetableDO::getBeginTime, reqVO.getBeginTime())
                .betweenIfPresent(TimetableDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(TimetableDO::getClassId, reqVO.getClassId())
                .eqIfPresent(TimetableDO::getTeacherId, reqVO.getTeacherId())
                .eqIfPresent(TimetableDO::getClassroomId, reqVO.getClassroomId())
                .orderByDesc(TimetableDO::getId));
    }

}
