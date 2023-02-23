package cn.iocoder.yudao.module.school.convert.classstudent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;

/**
 * 班级学生 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassStudentConvert {

    ClassStudentConvert INSTANCE = Mappers.getMapper(ClassStudentConvert.class);

    ClassStudentDO convert(ClassStudentCreateReqVO bean);

    ClassStudentDO convert(ClassStudentUpdateReqVO bean);

    ClassStudentRespVO convert(ClassStudentDO bean);

    List<ClassStudentRespVO> convertList(List<ClassStudentDO> list);

    PageResult<ClassStudentRespVO> convertPage(PageResult<ClassStudentDO> page);

    List<ClassStudentExcelVO> convertList02(List<ClassStudentDO> list);

}
