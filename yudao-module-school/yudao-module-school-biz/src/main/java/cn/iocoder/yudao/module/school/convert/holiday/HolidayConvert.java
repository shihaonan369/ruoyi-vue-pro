package cn.iocoder.yudao.module.school.convert.holiday;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;

/**
 * 假期 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface HolidayConvert {

    HolidayConvert INSTANCE = Mappers.getMapper(HolidayConvert.class);

    HolidayDO convert(HolidayCreateReqVO bean);

    HolidayDO convert(HolidayUpdateReqVO bean);

    HolidayRespVO convert(HolidayDO bean);

    List<HolidayRespVO> convertList(List<HolidayDO> list);

    PageResult<HolidayRespVO> convertPage(PageResult<HolidayDO> page);

    List<HolidayExcelVO> convertList02(List<HolidayDO> list);

    @Mapping(target = "label", source = "name")
    OptionVo convertOption(HolidayDO bean);

    List<OptionVo> convertOptionList(List<HolidayDO> list);

}
