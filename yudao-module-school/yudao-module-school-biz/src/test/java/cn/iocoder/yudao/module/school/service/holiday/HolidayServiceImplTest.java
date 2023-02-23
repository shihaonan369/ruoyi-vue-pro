package cn.iocoder.yudao.module.school.service.holiday;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;
import cn.iocoder.yudao.module.school.dal.mysql.holiday.HolidayMapper;
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
* {@link HolidayServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(HolidayServiceImpl.class)
public class HolidayServiceImplTest extends BaseDbUnitTest {

    @Resource
    private HolidayServiceImpl holidayService;

    @Resource
    private HolidayMapper holidayMapper;

    @Test
    public void testCreateHoliday_success() {
        // 准备参数
        HolidayCreateReqVO reqVO = randomPojo(HolidayCreateReqVO.class);

        // 调用
        Long holidayId = holidayService.createHoliday(reqVO);
        // 断言
        assertNotNull(holidayId);
        // 校验记录的属性是否正确
        HolidayDO holiday = holidayMapper.selectById(holidayId);
        assertPojoEquals(reqVO, holiday);
    }

    @Test
    public void testUpdateHoliday_success() {
        // mock 数据
        HolidayDO dbHoliday = randomPojo(HolidayDO.class);
        holidayMapper.insert(dbHoliday);// @Sql: 先插入出一条存在的数据
        // 准备参数
        HolidayUpdateReqVO reqVO = randomPojo(HolidayUpdateReqVO.class, o -> {
            o.setId(dbHoliday.getId()); // 设置更新的 ID
        });

        // 调用
        holidayService.updateHoliday(reqVO);
        // 校验是否更新正确
        HolidayDO holiday = holidayMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, holiday);
    }

    @Test
    public void testUpdateHoliday_notExists() {
        // 准备参数
        HolidayUpdateReqVO reqVO = randomPojo(HolidayUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> holidayService.updateHoliday(reqVO), HOLIDAY_NOT_EXISTS);
    }

    @Test
    public void testDeleteHoliday_success() {
        // mock 数据
        HolidayDO dbHoliday = randomPojo(HolidayDO.class);
        holidayMapper.insert(dbHoliday);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbHoliday.getId();

        // 调用
        holidayService.deleteHoliday(id);
       // 校验数据不存在了
       assertNull(holidayMapper.selectById(id));
    }

    @Test
    public void testDeleteHoliday_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> holidayService.deleteHoliday(id), HOLIDAY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHolidayPage() {
       // mock 数据
       HolidayDO dbHoliday = randomPojo(HolidayDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setBeginDate(null);
           o.setEndDate(null);
           o.setCampusId(null);
       });
       holidayMapper.insert(dbHoliday);
       // 测试 name 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setName(null)));
       // 测试 beginDate 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setBeginDate(null)));
       // 测试 endDate 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setEndDate(null)));
       // 测试 campusId 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setCampusId(null)));
       // 准备参数
       HolidayPageReqVO reqVO = new HolidayPageReqVO();
       reqVO.setName(null);
       reqVO.setBeginDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setCampusId(null);

       // 调用
       PageResult<HolidayDO> pageResult = holidayService.getHolidayPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbHoliday, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHolidayList() {
       // mock 数据
       HolidayDO dbHoliday = randomPojo(HolidayDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setBeginDate(null);
           o.setEndDate(null);
           o.setCampusId(null);
       });
       holidayMapper.insert(dbHoliday);
       // 测试 name 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setName(null)));
       // 测试 beginDate 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setBeginDate(null)));
       // 测试 endDate 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setEndDate(null)));
       // 测试 campusId 不匹配
       holidayMapper.insert(cloneIgnoreId(dbHoliday, o -> o.setCampusId(null)));
       // 准备参数
       HolidayExportReqVO reqVO = new HolidayExportReqVO();
       reqVO.setName(null);
       reqVO.setBeginDate((new Date[]{}));
       reqVO.setEndDate((new Date[]{}));
       reqVO.setCampusId(null);

       // 调用
       List<HolidayDO> list = holidayService.getHolidayList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbHoliday, list.get(0));
    }

}
