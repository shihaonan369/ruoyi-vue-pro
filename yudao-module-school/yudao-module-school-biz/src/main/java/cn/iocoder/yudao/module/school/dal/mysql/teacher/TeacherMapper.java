package cn.iocoder.yudao.module.school.dal.mysql.teacher;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;

/**
 * 教室 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TeacherMapper extends BaseMapperX<TeacherDO> {

    default PageResult<TeacherDO> selectPage(TeacherPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TeacherDO>()
                .likeIfPresent(TeacherDO::getName, reqVO.getName())
                .eqIfPresent(TeacherDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(TeacherDO::getId));
    }

    default List<TeacherDO> selectList(TeacherExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TeacherDO>()
                .likeIfPresent(TeacherDO::getName, reqVO.getName())
                .eqIfPresent(TeacherDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(TeacherDO::getId));
    }

}
