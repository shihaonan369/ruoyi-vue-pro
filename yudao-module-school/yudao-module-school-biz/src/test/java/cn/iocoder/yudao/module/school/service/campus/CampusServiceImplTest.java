package cn.iocoder.yudao.module.school.service.campus;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.module.school.dal.mysql.campus.CampusMapper;
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
* {@link CampusServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CampusServiceImpl.class)
public class CampusServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CampusServiceImpl campusService;

    @Resource
    private CampusMapper campusMapper;

    @Test
    public void testCreateCampus_success() {
        // 准备参数
        CampusCreateReqVO reqVO = randomPojo(CampusCreateReqVO.class);

        // 调用
        Long campusId = campusService.createCampus(reqVO);
        // 断言
        assertNotNull(campusId);
        // 校验记录的属性是否正确
        CampusDO campus = campusMapper.selectById(campusId);
        assertPojoEquals(reqVO, campus);
    }

    @Test
    public void testUpdateCampus_success() {
        // mock 数据
        CampusDO dbCampus = randomPojo(CampusDO.class);
        campusMapper.insert(dbCampus);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CampusUpdateReqVO reqVO = randomPojo(CampusUpdateReqVO.class, o -> {
            o.setId(dbCampus.getId()); // 设置更新的 ID
        });

        // 调用
        campusService.updateCampus(reqVO);
        // 校验是否更新正确
        CampusDO campus = campusMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, campus);
    }

    @Test
    public void testUpdateCampus_notExists() {
        // 准备参数
        CampusUpdateReqVO reqVO = randomPojo(CampusUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> campusService.updateCampus(reqVO), CAMPUS_NOT_EXISTS);
    }

    @Test
    public void testDeleteCampus_success() {
        // mock 数据
        CampusDO dbCampus = randomPojo(CampusDO.class);
        campusMapper.insert(dbCampus);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCampus.getId();

        // 调用
        campusService.deleteCampus(id);
       // 校验数据不存在了
       assertNull(campusMapper.selectById(id));
    }

    @Test
    public void testDeleteCampus_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> campusService.deleteCampus(id), CAMPUS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCampusPage() {
       // mock 数据
       CampusDO dbCampus = randomPojo(CampusDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusType(null);
           o.setLocation(null);
           o.setFoundDate(null);
       });
       campusMapper.insert(dbCampus);
       // 测试 name 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setName(null)));
       // 测试 campusType 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setCampusType(null)));
       // 测试 location 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setLocation(null)));
       // 测试 foundDate 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setFoundDate(null)));
       // 准备参数
       CampusPageReqVO reqVO = new CampusPageReqVO();
       reqVO.setName(null);
       reqVO.setCampusType(null);
       reqVO.setLocation(null);
       reqVO.setFoundDate((new Date[]{}));

       // 调用
       PageResult<CampusDO> pageResult = campusService.getCampusPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCampus, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCampusList() {
       // mock 数据
       CampusDO dbCampus = randomPojo(CampusDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusType(null);
           o.setLocation(null);
           o.setFoundDate(null);
       });
       campusMapper.insert(dbCampus);
       // 测试 name 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setName(null)));
       // 测试 campusType 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setCampusType(null)));
       // 测试 location 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setLocation(null)));
       // 测试 foundDate 不匹配
       campusMapper.insert(cloneIgnoreId(dbCampus, o -> o.setFoundDate(null)));
       // 准备参数
       CampusExportReqVO reqVO = new CampusExportReqVO();
       reqVO.setName(null);
       reqVO.setCampusType(null);
       reqVO.setLocation(null);
       reqVO.setFoundDate((new Date[]{}));

       // 调用
       List<CampusDO> list = campusService.getCampusList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCampus, list.get(0));
    }

}
