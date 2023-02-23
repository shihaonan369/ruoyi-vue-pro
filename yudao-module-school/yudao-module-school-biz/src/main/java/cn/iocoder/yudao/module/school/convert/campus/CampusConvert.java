package cn.iocoder.yudao.module.school.convert.campus;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;

/**
 * 校区 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CampusConvert {

    CampusConvert INSTANCE = Mappers.getMapper(CampusConvert.class);

    CampusDO convert(CampusCreateReqVO bean);

    CampusDO convert(CampusUpdateReqVO bean);

    CampusRespVO convert(CampusDO bean);

    List<CampusRespVO> convertList(List<CampusDO> list);

    PageResult<CampusRespVO> convertPage(PageResult<CampusDO> page);

    List<CampusExcelVO> convertList02(List<CampusDO> list);

}
