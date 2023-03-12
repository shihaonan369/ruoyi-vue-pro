package cn.iocoder.yudao.module.school.convert.coursefee;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;

/**
 * 课程收费 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CourseFeeConvert {

    CourseFeeConvert INSTANCE = Mappers.getMapper(CourseFeeConvert.class);

    CourseFeeDO convert(CourseFeeCreateReqVO bean);

    CourseFeeDO convert(CourseFeeUpdateReqVO bean);

    CourseFeeRespVO convert(CourseFeeDO bean);

    List<CourseFeeRespVO> convertList(List<CourseFeeDO> list);

    PageResult<CourseFeeRespVO> convertPage(PageResult<CourseFeeDO> page);

    List<CourseFeeExcelVO> convertList02(List<CourseFeeDO> list);

    @Mapping(target = "label", source = "remark")
    OptionVo convertOption(CourseFeeDO bean);

    List<OptionVo> convertOptionList(List<CourseFeeDO> list);

}
