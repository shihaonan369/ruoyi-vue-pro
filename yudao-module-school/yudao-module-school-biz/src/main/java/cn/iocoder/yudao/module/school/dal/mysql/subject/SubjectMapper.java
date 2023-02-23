package cn.iocoder.yudao.module.school.dal.mysql.subject;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.subject.SubjectDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.subject.vo.*;

/**
 * 科目 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SubjectMapper extends BaseMapperX<SubjectDO> {

    default PageResult<SubjectDO> selectPage(SubjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SubjectDO>()
                .likeIfPresent(SubjectDO::getName, reqVO.getName())
                .eqIfPresent(SubjectDO::getIsShow, reqVO.getIsShow())
                .eqIfPresent(SubjectDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(SubjectDO::getId));
    }

    default List<SubjectDO> selectList(SubjectExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SubjectDO>()
                .likeIfPresent(SubjectDO::getName, reqVO.getName())
                .eqIfPresent(SubjectDO::getIsShow, reqVO.getIsShow())
                .eqIfPresent(SubjectDO::getCampusId, reqVO.getCampusId())
                .orderByDesc(SubjectDO::getId));
    }

}
