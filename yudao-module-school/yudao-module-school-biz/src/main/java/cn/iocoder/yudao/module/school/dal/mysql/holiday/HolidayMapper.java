package cn.iocoder.yudao.module.school.dal.mysql.holiday;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;

/**
 * 假期 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface HolidayMapper extends BaseMapperX<HolidayDO> {

    default PageResult<HolidayDO> selectPage(HolidayPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HolidayDO>()
                .likeIfPresent(HolidayDO::getName, reqVO.getName())
                .betweenIfPresent(HolidayDO::getBeginDate, reqVO.getBeginDate())
                .betweenIfPresent(HolidayDO::getEndDate, reqVO.getEndDate())
                .eqIfPresent(HolidayDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(HolidayDO::getId));
    }

    default List<HolidayDO> selectList(HolidayExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<HolidayDO>()
                .likeIfPresent(HolidayDO::getName, reqVO.getName())
                .betweenIfPresent(HolidayDO::getBeginDate, reqVO.getBeginDate())
                .betweenIfPresent(HolidayDO::getEndDate, reqVO.getEndDate())
                .eqIfPresent(HolidayDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(HolidayDO::getId));
    }

}
