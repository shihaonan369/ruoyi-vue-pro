package cn.iocoder.yudao.module.school.service.teacher;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.teacher.TeacherConvert;
import cn.iocoder.yudao.module.school.dal.mysql.teacher.TeacherMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 教室 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Long createTeacher(TeacherCreateReqVO createReqVO) {
        // 插入
        TeacherDO teacher = TeacherConvert.INSTANCE.convert(createReqVO);
        teacherMapper.insert(teacher);
        // 返回
        return teacher.getId();
    }

    @Override
    public void updateTeacher(TeacherUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTeacherExists(updateReqVO.getId());
        // 更新
        TeacherDO updateObj = TeacherConvert.INSTANCE.convert(updateReqVO);
        teacherMapper.updateById(updateObj);
    }

    @Override
    public void deleteTeacher(Long id) {
        // 校验存在
        this.validateTeacherExists(id);
        // 删除
        teacherMapper.deleteById(id);
    }

    private void validateTeacherExists(Long id) {
        if (teacherMapper.selectById(id) == null) {
            throw exception(TEACHER_NOT_EXISTS);
        }
    }

    @Override
    public TeacherDO getTeacher(Long id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public List<TeacherDO> getTeacherList(Collection<Long> ids) {
        return teacherMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TeacherDO> getTeacherPage(TeacherPageReqVO pageReqVO) {
        return teacherMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TeacherDO> getTeacherList(TeacherExportReqVO exportReqVO) {
        return teacherMapper.selectList(exportReqVO);
    }

}
