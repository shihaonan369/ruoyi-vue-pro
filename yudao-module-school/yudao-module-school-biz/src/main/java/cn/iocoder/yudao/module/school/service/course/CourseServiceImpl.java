package cn.iocoder.yudao.module.school.service.course;

import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.course.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.course.CourseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.course.CourseConvert;
import cn.iocoder.yudao.module.school.dal.mysql.course.CourseMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 课程 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public Long createCourse(CourseCreateReqVO createReqVO) {
        // 插入
        CourseDO course = CourseConvert.INSTANCE.convert(createReqVO);
        courseMapper.insert(course);
        // 返回
        return course.getId();
    }

    @Override
    public void updateCourse(CourseUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCourseExists(updateReqVO.getId());
        // 更新
        CourseDO updateObj = CourseConvert.INSTANCE.convert(updateReqVO);
        courseMapper.updateById(updateObj);
    }

    @Override
    public void deleteCourse(Long id) {
        // 校验存在
        this.validateCourseExists(id);
        // 删除
        courseMapper.deleteById(id);
    }

    private void validateCourseExists(Long id) {
        if (courseMapper.selectById(id) == null) {
            throw exception(COURSE_NOT_EXISTS);
        }
    }

    @Override
    public CourseDO getCourse(Long id) {
        return courseMapper.selectById(id);
    }

    @Override
    public List<CourseDO> getCourseList(Collection<Long> ids) {
        return courseMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CourseDO> getCoursePage(CoursePageReqVO pageReqVO) {
        return courseMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CourseDO> getCourseList(CourseExportReqVO exportReqVO) {
        return courseMapper.selectList(exportReqVO);
    }

    @Override
    public List<CourseDO> getCourseOptions() {
        return courseMapper.selectList(new QueryWrapper<CourseDO>().select("id", "name"));
    }

}
