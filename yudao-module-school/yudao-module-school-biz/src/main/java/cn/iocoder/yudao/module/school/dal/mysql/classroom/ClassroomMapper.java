package cn.iocoder.yudao.module.school.dal.mysql.classroom;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;

/**
 * 教室 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassroomMapper extends BaseMapperX<ClassroomDO> {

    default PageResult<ClassroomDO> selectPage(ClassroomPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ClassroomDO>()
                .likeIfPresent(ClassroomDO::getName, reqVO.getName())
                .eqIfPresent(ClassroomDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(ClassroomDO::getId));
    }

    default List<ClassroomDO> selectList(ClassroomExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ClassroomDO>()
                .likeIfPresent(ClassroomDO::getName, reqVO.getName())
                .eqIfPresent(ClassroomDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(ClassroomDO::getId));
    }

}
