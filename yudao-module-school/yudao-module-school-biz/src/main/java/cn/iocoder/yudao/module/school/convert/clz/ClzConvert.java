package cn.iocoder.yudao.module.school.convert.clz;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;

/**
 * 班级 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ClzConvert {

    ClzConvert INSTANCE = Mappers.getMapper(ClzConvert.class);

    ClzDO convert(ClzCreateReqVO bean);

    ClzDO convert(ClzUpdateReqVO bean);

    ClzRespVO convert(ClzDO bean);

    List<ClzRespVO> convertList(List<ClzDO> list);

    PageResult<ClzRespVO> convertPage(PageResult<ClzDO> page);

    List<ClzExcelVO> convertList02(List<ClzDO> list);

    @Mapping(target = "label", source = "name")
    OptionVo convertOption(ClzDO bean);

    List<OptionVo> convertOptionList(List<ClzDO> list);

}
