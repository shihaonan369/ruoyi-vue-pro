package cn.iocoder.yudao.module.school.service.coursefee;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.coursefee.CourseFeeConvert;
import cn.iocoder.yudao.module.school.dal.mysql.coursefee.CourseFeeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 课程收费 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CourseFeeServiceImpl implements CourseFeeService {

    @Resource
    private CourseFeeMapper courseFeeMapper;

    @Override
    public Long createCourseFee(CourseFeeCreateReqVO createReqVO) {
        // 插入
        CourseFeeDO courseFee = CourseFeeConvert.INSTANCE.convert(createReqVO);
        courseFeeMapper.insert(courseFee);
        // 返回
        return courseFee.getId();
    }

    @Override
    public void updateCourseFee(CourseFeeUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCourseFeeExists(updateReqVO.getId());
        // 更新
        CourseFeeDO updateObj = CourseFeeConvert.INSTANCE.convert(updateReqVO);
        courseFeeMapper.updateById(updateObj);
    }

    @Override
    public void deleteCourseFee(Long id) {
        // 校验存在
        this.validateCourseFeeExists(id);
        // 删除
        courseFeeMapper.deleteById(id);
    }

    private void validateCourseFeeExists(Long id) {
        if (courseFeeMapper.selectById(id) == null) {
            throw exception(COURSE_FEE_NOT_EXISTS);
        }
    }

    @Override
    public CourseFeeDO getCourseFee(Long id) {
        return courseFeeMapper.selectById(id);
    }

    @Override
    public List<CourseFeeDO> getCourseFeeList(Collection<Long> ids) {
        return courseFeeMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CourseFeeDO> getCourseFeePage(CourseFeePageReqVO pageReqVO) {
        return courseFeeMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CourseFeeDO> getCourseFeeList(CourseFeeExportReqVO exportReqVO) {
        return courseFeeMapper.selectList(exportReqVO);
    }

}
