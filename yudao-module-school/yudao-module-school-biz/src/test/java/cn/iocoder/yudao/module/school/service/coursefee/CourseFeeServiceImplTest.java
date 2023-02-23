package cn.iocoder.yudao.module.school.service.coursefee;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;
import cn.iocoder.yudao.module.school.dal.mysql.coursefee.CourseFeeMapper;
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
* {@link CourseFeeServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CourseFeeServiceImpl.class)
public class CourseFeeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CourseFeeServiceImpl courseFeeService;

    @Resource
    private CourseFeeMapper courseFeeMapper;

    @Test
    public void testCreateCourseFee_success() {
        // 准备参数
        CourseFeeCreateReqVO reqVO = randomPojo(CourseFeeCreateReqVO.class);

        // 调用
        Long courseFeeId = courseFeeService.createCourseFee(reqVO);
        // 断言
        assertNotNull(courseFeeId);
        // 校验记录的属性是否正确
        CourseFeeDO courseFee = courseFeeMapper.selectById(courseFeeId);
        assertPojoEquals(reqVO, courseFee);
    }

    @Test
    public void testUpdateCourseFee_success() {
        // mock 数据
        CourseFeeDO dbCourseFee = randomPojo(CourseFeeDO.class);
        courseFeeMapper.insert(dbCourseFee);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CourseFeeUpdateReqVO reqVO = randomPojo(CourseFeeUpdateReqVO.class, o -> {
            o.setId(dbCourseFee.getId()); // 设置更新的 ID
        });

        // 调用
        courseFeeService.updateCourseFee(reqVO);
        // 校验是否更新正确
        CourseFeeDO courseFee = courseFeeMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, courseFee);
    }

    @Test
    public void testUpdateCourseFee_notExists() {
        // 准备参数
        CourseFeeUpdateReqVO reqVO = randomPojo(CourseFeeUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> courseFeeService.updateCourseFee(reqVO), COURSE_FEE_NOT_EXISTS);
    }

    @Test
    public void testDeleteCourseFee_success() {
        // mock 数据
        CourseFeeDO dbCourseFee = randomPojo(CourseFeeDO.class);
        courseFeeMapper.insert(dbCourseFee);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCourseFee.getId();

        // 调用
        courseFeeService.deleteCourseFee(id);
       // 校验数据不存在了
       assertNull(courseFeeMapper.selectById(id));
    }

    @Test
    public void testDeleteCourseFee_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> courseFeeService.deleteCourseFee(id), COURSE_FEE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCourseFeePage() {
       // mock 数据
       CourseFeeDO dbCourseFee = randomPojo(CourseFeeDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setStatus(null);
           o.setCourseId(null);
       });
       courseFeeMapper.insert(dbCourseFee);
       // 测试 type 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setType(null)));
       // 测试 status 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setStatus(null)));
       // 测试 courseId 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setCourseId(null)));
       // 准备参数
       CourseFeePageReqVO reqVO = new CourseFeePageReqVO();
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCourseId(null);

       // 调用
       PageResult<CourseFeeDO> pageResult = courseFeeService.getCourseFeePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCourseFee, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCourseFeeList() {
       // mock 数据
       CourseFeeDO dbCourseFee = randomPojo(CourseFeeDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setStatus(null);
           o.setCourseId(null);
       });
       courseFeeMapper.insert(dbCourseFee);
       // 测试 type 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setType(null)));
       // 测试 status 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setStatus(null)));
       // 测试 courseId 不匹配
       courseFeeMapper.insert(cloneIgnoreId(dbCourseFee, o -> o.setCourseId(null)));
       // 准备参数
       CourseFeeExportReqVO reqVO = new CourseFeeExportReqVO();
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCourseId(null);

       // 调用
       List<CourseFeeDO> list = courseFeeService.getCourseFeeList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCourseFee, list.get(0));
    }

}
