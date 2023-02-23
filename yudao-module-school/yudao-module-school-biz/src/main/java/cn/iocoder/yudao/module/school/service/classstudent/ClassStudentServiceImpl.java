package cn.iocoder.yudao.module.school.service.classstudent;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.classstudent.ClassStudentConvert;
import cn.iocoder.yudao.module.school.dal.mysql.classstudent.ClassStudentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 班级学生 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ClassStudentServiceImpl implements ClassStudentService {

    @Resource
    private ClassStudentMapper classStudentMapper;

    @Override
    public Long createClassStudent(ClassStudentCreateReqVO createReqVO) {
        // 插入
        ClassStudentDO classStudent = ClassStudentConvert.INSTANCE.convert(createReqVO);
        classStudentMapper.insert(classStudent);
        // 返回
        return classStudent.getId();
    }

    @Override
    public void updateClassStudent(ClassStudentUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateClassStudentExists(updateReqVO.getId());
        // 更新
        ClassStudentDO updateObj = ClassStudentConvert.INSTANCE.convert(updateReqVO);
        classStudentMapper.updateById(updateObj);
    }

    @Override
    public void deleteClassStudent(Long id) {
        // 校验存在
        this.validateClassStudentExists(id);
        // 删除
        classStudentMapper.deleteById(id);
    }

    private void validateClassStudentExists(Long id) {
        if (classStudentMapper.selectById(id) == null) {
            throw exception(CLASS_STUDENT_NOT_EXISTS);
        }
    }

    @Override
    public ClassStudentDO getClassStudent(Long id) {
        return classStudentMapper.selectById(id);
    }

    @Override
    public List<ClassStudentDO> getClassStudentList(Collection<Long> ids) {
        return classStudentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ClassStudentDO> getClassStudentPage(ClassStudentPageReqVO pageReqVO) {
        return classStudentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ClassStudentDO> getClassStudentList(ClassStudentExportReqVO exportReqVO) {
        return classStudentMapper.selectList(exportReqVO);
    }

}
