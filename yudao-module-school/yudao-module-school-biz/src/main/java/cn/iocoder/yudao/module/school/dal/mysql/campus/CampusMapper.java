package cn.iocoder.yudao.module.school.dal.mysql.campus;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;

/**
 * 校区 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CampusMapper extends BaseMapperX<CampusDO> {

    default PageResult<CampusDO> selectPage(CampusPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CampusDO>()
                .likeIfPresent(CampusDO::getName, reqVO.getName())
                .eqIfPresent(CampusDO::getCampusType, reqVO.getCampusType())
                .likeIfPresent(CampusDO::getLocation, reqVO.getLocation())
                .betweenIfPresent(CampusDO::getFoundDate, reqVO.getFoundDate())
                .orderByDesc(CampusDO::getId));
    }

    default List<CampusDO> selectList(CampusExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CampusDO>()
                .likeIfPresent(CampusDO::getName, reqVO.getName())
                .eqIfPresent(CampusDO::getCampusType, reqVO.getCampusType())
                .likeIfPresent(CampusDO::getLocation, reqVO.getLocation())
                .betweenIfPresent(CampusDO::getFoundDate, reqVO.getFoundDate())
                .orderByDesc(CampusDO::getId));
    }

}
