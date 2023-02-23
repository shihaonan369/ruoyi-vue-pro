package cn.iocoder.yudao.module.school.service.course;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.course.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.course.CourseDO;
import cn.iocoder.yudao.module.school.dal.mysql.course.CourseMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CourseServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CourseServiceImpl.class)
public class CourseServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CourseServiceImpl courseService;

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void testCreateCourse_success() {
        // 准备参数
        CourseCreateReqVO reqVO = randomPojo(CourseCreateReqVO.class);

        // 调用
        Long courseId = courseService.createCourse(reqVO);
        // 断言
        assertNotNull(courseId);
        // 校验记录的属性是否正确
        CourseDO course = courseMapper.selectById(courseId);
        assertPojoEquals(reqVO, course);
    }

    @Test
    public void testUpdateCourse_success() {
        // mock 数据
        CourseDO dbCourse = randomPojo(CourseDO.class);
        courseMapper.insert(dbCourse);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CourseUpdateReqVO reqVO = randomPojo(CourseUpdateReqVO.class, o -> {
            o.setId(dbCourse.getId()); // 设置更新的 ID
        });

        // 调用
        courseService.updateCourse(reqVO);
        // 校验是否更新正确
        CourseDO course = courseMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, course);
    }

    @Test
    public void testUpdateCourse_notExists() {
        // 准备参数
        CourseUpdateReqVO reqVO = randomPojo(CourseUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> courseService.updateCourse(reqVO), COURSE_NOT_EXISTS);
    }

    @Test
    public void testDeleteCourse_success() {
        // mock 数据
        CourseDO dbCourse = randomPojo(CourseDO.class);
        courseMapper.insert(dbCourse);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCourse.getId();

        // 调用
        courseService.deleteCourse(id);
       // 校验数据不存在了
       assertNull(courseMapper.selectById(id));
    }

    @Test
    public void testDeleteCourse_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> courseService.deleteCourse(id), COURSE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCoursePage() {
       // mock 数据
       CourseDO dbCourse = randomPojo(CourseDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setIntroduction(null);
           o.setTeachingMode(null);
           o.setSubjectId(null);
       });
       courseMapper.insert(dbCourse);
       // 测试 name 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setName(null)));
       // 测试 introduction 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setIntroduction(null)));
       // 测试 teachingMode 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setTeachingMode(null)));
       // 测试 subjectId 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setSubjectId(null)));
       // 准备参数
       CoursePageReqVO reqVO = new CoursePageReqVO();
       reqVO.setName(null);
       reqVO.setIntroduction(null);
       reqVO.setTeachingMode(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<CourseDO> pageResult = courseService.getCoursePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCourse, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCourseList() {
       // mock 数据
       CourseDO dbCourse = randomPojo(CourseDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setIntroduction(null);
           o.setTeachingMode(null);
           o.setSubjectId(null);
       });
       courseMapper.insert(dbCourse);
       // 测试 name 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setName(null)));
       // 测试 introduction 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setIntroduction(null)));
       // 测试 teachingMode 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setTeachingMode(null)));
       // 测试 subjectId 不匹配
       courseMapper.insert(cloneIgnoreId(dbCourse, o -> o.setSubjectId(null)));
       // 准备参数
       CourseExportReqVO reqVO = new CourseExportReqVO();
       reqVO.setName(null);
       reqVO.setIntroduction(null);
       reqVO.setTeachingMode(null);
       reqVO.setSubjectId(null);

       // 调用
       List<CourseDO> list = courseService.getCourseList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCourse, list.get(0));
    }

}
