package cn.iocoder.yudao.module.school.convert.subject;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.subject.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.subject.SubjectDO;

/**
 * 科目 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SubjectConvert {

    SubjectConvert INSTANCE = Mappers.getMapper(SubjectConvert.class);

    SubjectDO convert(SubjectCreateReqVO bean);

    SubjectDO convert(SubjectUpdateReqVO bean);

    SubjectRespVO convert(SubjectDO bean);

    List<SubjectRespVO> convertList(List<SubjectDO> list);

    PageResult<SubjectRespVO> convertPage(PageResult<SubjectDO> page);

    List<SubjectExcelVO> convertList02(List<SubjectDO> list);

    @Mapping(target = "label", source = "name")
    OptionVo convertOption(SubjectDO bean);

    List<OptionVo> convertOptionList(List<SubjectDO> list);

}
