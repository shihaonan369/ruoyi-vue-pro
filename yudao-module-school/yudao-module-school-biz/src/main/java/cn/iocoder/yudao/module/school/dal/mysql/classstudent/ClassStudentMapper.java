package cn.iocoder.yudao.module.school.dal.mysql.classstudent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;

/**
 * 班级学生 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassStudentMapper extends BaseMapperX<ClassStudentDO> {

    default PageResult<ClassStudentDO> selectPage(ClassStudentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ClassStudentDO>()
                .eqIfPresent(ClassStudentDO::getNumber, reqVO.getNumber())
                .betweenIfPresent(ClassStudentDO::getEnterDate, reqVO.getEnterDate())
                .eqIfPresent(ClassStudentDO::getClassId, reqVO.getClassId())
                .eqIfPresent(ClassStudentDO::getStudentId, reqVO.getStudentId())
                .orderByDesc(ClassStudentDO::getId));
    }

    default List<ClassStudentDO> selectList(ClassStudentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ClassStudentDO>()
                .eqIfPresent(ClassStudentDO::getNumber, reqVO.getNumber())
                .betweenIfPresent(ClassStudentDO::getEnterDate, reqVO.getEnterDate())
                .eqIfPresent(ClassStudentDO::getClassId, reqVO.getClassId())
                .eqIfPresent(ClassStudentDO::getStudentId, reqVO.getStudentId())
                .orderByDesc(ClassStudentDO::getId));
    }

}
