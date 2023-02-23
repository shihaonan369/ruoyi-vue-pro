package cn.iocoder.yudao.module.school.service.timetable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;
import cn.iocoder.yudao.module.school.dal.mysql.timetable.TimetableMapper;
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
* {@link TimetableServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(TimetableServiceImpl.class)
public class TimetableServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TimetableServiceImpl timetableService;

    @Resource
    private TimetableMapper timetableMapper;

    @Test
    public void testCreateTimetable_success() {
        // 准备参数
        TimetableCreateReqVO reqVO = randomPojo(TimetableCreateReqVO.class);

        // 调用
        Long timetableId = timetableService.createTimetable(reqVO);
        // 断言
        assertNotNull(timetableId);
        // 校验记录的属性是否正确
        TimetableDO timetable = timetableMapper.selectById(timetableId);
        assertPojoEquals(reqVO, timetable);
    }

    @Test
    public void testUpdateTimetable_success() {
        // mock 数据
        TimetableDO dbTimetable = randomPojo(TimetableDO.class);
        timetableMapper.insert(dbTimetable);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TimetableUpdateReqVO reqVO = randomPojo(TimetableUpdateReqVO.class, o -> {
            o.setId(dbTimetable.getId()); // 设置更新的 ID
        });

        // 调用
        timetableService.updateTimetable(reqVO);
        // 校验是否更新正确
        TimetableDO timetable = timetableMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, timetable);
    }

    @Test
    public void testUpdateTimetable_notExists() {
        // 准备参数
        TimetableUpdateReqVO reqVO = randomPojo(TimetableUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> timetableService.updateTimetable(reqVO), TIMETABLE_NOT_EXISTS);
    }

    @Test
    public void testDeleteTimetable_success() {
        // mock 数据
        TimetableDO dbTimetable = randomPojo(TimetableDO.class);
        timetableMapper.insert(dbTimetable);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbTimetable.getId();

        // 调用
        timetableService.deleteTimetable(id);
       // 校验数据不存在了
       assertNull(timetableMapper.selectById(id));
    }

    @Test
    public void testDeleteTimetable_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> timetableService.deleteTimetable(id), TIMETABLE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTimetablePage() {
       // mock 数据
       TimetableDO dbTimetable = randomPojo(TimetableDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setBeginDate(null);
           o.setEndDate(null);
           o.setBeginTime(null);
           o.setEndTime(null);
           o.setClassId(null);
           o.setTeacherId(null);
           o.setClassroomId(null);
       });
       timetableMapper.insert(dbTimetable);
       // 测试 type 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setType(null)));
       // 测试 beginDate 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setBeginDate(null)));
       // 测试 endDate 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setEndDate(null)));
       // 测试 beginTime 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setBeginTime(null)));
       // 测试 endTime 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setEndTime(null)));
       // 测试 classId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setClassId(null)));
       // 测试 teacherId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setTeacherId(null)));
       // 测试 classroomId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setClassroomId(null)));
       // 准备参数
       TimetablePageReqVO reqVO = new TimetablePageReqVO();
       reqVO.setType(null);
       reqVO.setBeginDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setBeginTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setClassId(null);
       reqVO.setTeacherId(null);
       reqVO.setClassroomId(null);

       // 调用
       PageResult<TimetableDO> pageResult = timetableService.getTimetablePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTimetable, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTimetableList() {
       // mock 数据
       TimetableDO dbTimetable = randomPojo(TimetableDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setBeginDate(null);
           o.setEndDate(null);
           o.setBeginTime(null);
           o.setEndTime(null);
           o.setClassId(null);
           o.setTeacherId(null);
           o.setClassroomId(null);
       });
       timetableMapper.insert(dbTimetable);
       // 测试 type 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setType(null)));
       // 测试 beginDate 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setBeginDate(null)));
       // 测试 endDate 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setEndDate(null)));
       // 测试 beginTime 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setBeginTime(null)));
       // 测试 endTime 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setEndTime(null)));
       // 测试 classId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setClassId(null)));
       // 测试 teacherId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setTeacherId(null)));
       // 测试 classroomId 不匹配
       timetableMapper.insert(cloneIgnoreId(dbTimetable, o -> o.setClassroomId(null)));
       // 准备参数
       TimetableExportReqVO reqVO = new TimetableExportReqVO();
       reqVO.setType(null);
       reqVO.setBeginDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setBeginTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setClassId(null);
       reqVO.setTeacherId(null);
       reqVO.setClassroomId(null);

       // 调用
       List<TimetableDO> list = timetableService.getTimetableList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTimetable, list.get(0));
    }

}
