package cn.iocoder.yudao.module.school.convert.timetable;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;

/**
 * 课表 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TimetableConvert {

    TimetableConvert INSTANCE = Mappers.getMapper(TimetableConvert.class);

    TimetableDO convert(TimetableCreateReqVO bean);

    TimetableDO convert(TimetableUpdateReqVO bean);

    TimetableRespVO convert(TimetableDO bean);

    List<TimetableRespVO> convertList(List<TimetableDO> list);

    PageResult<TimetableRespVO> convertPage(PageResult<TimetableDO> page);

    List<TimetableExcelVO> convertList02(List<TimetableDO> list);

}
