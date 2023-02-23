package cn.iocoder.yudao.module.school.service.teacher;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;
import cn.iocoder.yudao.module.school.dal.mysql.teacher.TeacherMapper;
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
* {@link TeacherServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(TeacherServiceImpl.class)
public class TeacherServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TeacherServiceImpl teacherService;

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void testCreateTeacher_success() {
        // 准备参数
        TeacherCreateReqVO reqVO = randomPojo(TeacherCreateReqVO.class);

        // 调用
        Long teacherId = teacherService.createTeacher(reqVO);
        // 断言
        assertNotNull(teacherId);
        // 校验记录的属性是否正确
        TeacherDO teacher = teacherMapper.selectById(teacherId);
        assertPojoEquals(reqVO, teacher);
    }

    @Test
    public void testUpdateTeacher_success() {
        // mock 数据
        TeacherDO dbTeacher = randomPojo(TeacherDO.class);
        teacherMapper.insert(dbTeacher);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TeacherUpdateReqVO reqVO = randomPojo(TeacherUpdateReqVO.class, o -> {
            o.setId(dbTeacher.getId()); // 设置更新的 ID
        });

        // 调用
        teacherService.updateTeacher(reqVO);
        // 校验是否更新正确
        TeacherDO teacher = teacherMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, teacher);
    }

    @Test
    public void testUpdateTeacher_notExists() {
        // 准备参数
        TeacherUpdateReqVO reqVO = randomPojo(TeacherUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> teacherService.updateTeacher(reqVO), TEACHER_NOT_EXISTS);
    }

    @Test
    public void testDeleteTeacher_success() {
        // mock 数据
        TeacherDO dbTeacher = randomPojo(TeacherDO.class);
        teacherMapper.insert(dbTeacher);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbTeacher.getId();

        // 调用
        teacherService.deleteTeacher(id);
       // 校验数据不存在了
       assertNull(teacherMapper.selectById(id));
    }

    @Test
    public void testDeleteTeacher_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> teacherService.deleteTeacher(id), TEACHER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTeacherPage() {
       // mock 数据
       TeacherDO dbTeacher = randomPojo(TeacherDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusId(null);
       });
       teacherMapper.insert(dbTeacher);
       // 测试 name 不匹配
       teacherMapper.insert(cloneIgnoreId(dbTeacher, o -> o.setName(null)));
       // 测试 campusId 不匹配
       teacherMapper.insert(cloneIgnoreId(dbTeacher, o -> o.setCampusId(null)));
       // 准备参数
       TeacherPageReqVO reqVO = new TeacherPageReqVO();
       reqVO.setName(null);
       reqVO.setCampusId(null);

       // 调用
       PageResult<TeacherDO> pageResult = teacherService.getTeacherPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTeacher, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTeacherList() {
       // mock 数据
       TeacherDO dbTeacher = randomPojo(TeacherDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusId(null);
       });
       teacherMapper.insert(dbTeacher);
       // 测试 name 不匹配
       teacherMapper.insert(cloneIgnoreId(dbTeacher, o -> o.setName(null)));
       // 测试 campusId 不匹配
       teacherMapper.insert(cloneIgnoreId(dbTeacher, o -> o.setCampusId(null)));
       // 准备参数
       TeacherExportReqVO reqVO = new TeacherExportReqVO();
       reqVO.setName(null);
       reqVO.setCampusId(null);

       // 调用
       List<TeacherDO> list = teacherService.getTeacherList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTeacher, list.get(0));
    }

}
