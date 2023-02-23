package cn.iocoder.yudao.module.school.convert.teacher;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;

/**
 * 教室 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TeacherConvert {

    TeacherConvert INSTANCE = Mappers.getMapper(TeacherConvert.class);

    TeacherDO convert(TeacherCreateReqVO bean);

    TeacherDO convert(TeacherUpdateReqVO bean);

    TeacherRespVO convert(TeacherDO bean);

    List<TeacherRespVO> convertList(List<TeacherDO> list);

    PageResult<TeacherRespVO> convertPage(PageResult<TeacherDO> page);

    List<TeacherExcelVO> convertList02(List<TeacherDO> list);

}
