package cn.iocoder.yudao.module.school.service.classroom;

import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.classroom.ClassroomConvert;
import cn.iocoder.yudao.module.school.dal.mysql.classroom.ClassroomMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 教室 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ClassroomServiceImpl implements ClassroomService {

    @Resource
    private ClassroomMapper classroomMapper;

    @Override
    public Long createClassroom(ClassroomCreateReqVO createReqVO) {
        // 插入
        ClassroomDO classroom = ClassroomConvert.INSTANCE.convert(createReqVO);
        classroomMapper.insert(classroom);
        // 返回
        return classroom.getId();
    }

    @Override
    public void updateClassroom(ClassroomUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateClassroomExists(updateReqVO.getId());
        // 更新
        ClassroomDO updateObj = ClassroomConvert.INSTANCE.convert(updateReqVO);
        classroomMapper.updateById(updateObj);
    }

    @Override
    public void deleteClassroom(Long id) {
        // 校验存在
        this.validateClassroomExists(id);
        // 删除
        classroomMapper.deleteById(id);
    }

    private void validateClassroomExists(Long id) {
        if (classroomMapper.selectById(id) == null) {
            throw exception(CLASSROOM_NOT_EXISTS);
        }
    }

    @Override
    public ClassroomDO getClassroom(Long id) {
        return classroomMapper.selectById(id);
    }

    @Override
    public List<ClassroomDO> getClassroomList(Collection<Long> ids) {
        return classroomMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ClassroomDO> getClassroomPage(ClassroomPageReqVO pageReqVO) {
        return classroomMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ClassroomDO> getClassroomList(ClassroomExportReqVO exportReqVO) {
        return classroomMapper.selectList(exportReqVO);
    }

    @Override
    public List<ClassroomDO> getClassroomOptions() {
        return classroomMapper.selectList(new QueryWrapper<ClassroomDO>().select("id", "name"));
    }

}
