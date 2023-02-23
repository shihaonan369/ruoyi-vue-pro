package cn.iocoder.yudao.module.school.dal.mysql.clz;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;

/**
 * 班级 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ClzMapper extends BaseMapperX<ClzDO> {

    default PageResult<ClzDO> selectPage(ClzPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ClzDO>()
                .likeIfPresent(ClzDO::getName, reqVO.getName())
                .eqIfPresent(ClzDO::getMaxStudents, reqVO.getMaxStudents())
                .eqIfPresent(ClzDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ClzDO::getPlanOpenDate, reqVO.getPlanOpenDate())
                .betweenIfPresent(ClzDO::getOpenDate, reqVO.getOpenDate())
                .eqIfPresent(ClzDO::getRemark, reqVO.getRemark())
                .eqIfPresent(ClzDO::getCourseId, reqVO.getCourseId())
                .eqIfPresent(ClzDO::getHeadTeacherId, reqVO.getHeadTeacherId())
                .orderByDesc(ClzDO::getId));
    }

    default List<ClzDO> selectList(ClzExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ClzDO>()
                .likeIfPresent(ClzDO::getName, reqVO.getName())
                .eqIfPresent(ClzDO::getMaxStudents, reqVO.getMaxStudents())
                .eqIfPresent(ClzDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ClzDO::getPlanOpenDate, reqVO.getPlanOpenDate())
                .betweenIfPresent(ClzDO::getOpenDate, reqVO.getOpenDate())
                .eqIfPresent(ClzDO::getRemark, reqVO.getRemark())
                .eqIfPresent(ClzDO::getCourseId, reqVO.getCourseId())
                .eqIfPresent(ClzDO::getHeadTeacherId, reqVO.getHeadTeacherId())
                .orderByDesc(ClzDO::getId));
    }

}
