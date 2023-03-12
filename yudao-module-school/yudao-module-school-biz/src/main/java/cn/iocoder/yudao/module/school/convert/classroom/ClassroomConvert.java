package cn.iocoder.yudao.module.school.convert.classroom;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;

/**
 * 教室 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassroomConvert {

    ClassroomConvert INSTANCE = Mappers.getMapper(ClassroomConvert.class);

    ClassroomDO convert(ClassroomCreateReqVO bean);

    ClassroomDO convert(ClassroomUpdateReqVO bean);

    ClassroomRespVO convert(ClassroomDO bean);

    List<ClassroomRespVO> convertList(List<ClassroomDO> list);

    PageResult<ClassroomRespVO> convertPage(PageResult<ClassroomDO> page);

    List<ClassroomExcelVO> convertList02(List<ClassroomDO> list);

    @Mapping(target = "label", source = "name")
    OptionVo convertOption(ClassroomDO bean);

    List<OptionVo> convertOptionList(List<ClassroomDO> list);

}
