package cn.iocoder.yudao.module.school.service.clz;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import cn.iocoder.yudao.module.school.dal.mysql.clz.ClzMapper;
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
* {@link ClzServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ClzServiceImpl.class)
public class ClzServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ClzServiceImpl clzService;

    @Resource
    private ClzMapper clzMapper;

    @Test
    public void testCreateClz_success() {
        // 准备参数
        ClzCreateReqVO reqVO = randomPojo(ClzCreateReqVO.class);

        // 调用
        Long clzId = clzService.createClz(reqVO);
        // 断言
        assertNotNull(clzId);
        // 校验记录的属性是否正确
        ClzDO clz = clzMapper.selectById(clzId);
        assertPojoEquals(reqVO, clz);
    }

    @Test
    public void testUpdateClz_success() {
        // mock 数据
        ClzDO dbClz = randomPojo(ClzDO.class);
        clzMapper.insert(dbClz);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ClzUpdateReqVO reqVO = randomPojo(ClzUpdateReqVO.class, o -> {
            o.setId(dbClz.getId()); // 设置更新的 ID
        });

        // 调用
        clzService.updateClz(reqVO);
        // 校验是否更新正确
        ClzDO clz = clzMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, clz);
    }

    @Test
    public void testUpdateClz_notExists() {
        // 准备参数
        ClzUpdateReqVO reqVO = randomPojo(ClzUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> clzService.updateClz(reqVO), CLASS_NOT_EXISTS);
    }

    @Test
    public void testDeleteClz_success() {
        // mock 数据
        ClzDO dbClz = randomPojo(ClzDO.class);
        clzMapper.insert(dbClz);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbClz.getId();

        // 调用
        clzService.deleteClz(id);
       // 校验数据不存在了
       assertNull(clzMapper.selectById(id));
    }

    @Test
    public void testDeleteClz_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> clzService.deleteClz(id), CLASS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClzPage() {
       // mock 数据
       ClzDO dbClz = randomPojo(ClzDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setMaxStudents(null);
           o.setStatus(null);
           o.setPlanOpenDate(null);
           o.setOpenDate(null);
           o.setRemark(null);
           o.setCourseId(null);
           o.setHeadTeacherId(null);
       });
       clzMapper.insert(dbClz);
       // 测试 name 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setName(null)));
       // 测试 maxStudents 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setMaxStudents(null)));
       // 测试 status 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setStatus(null)));
       // 测试 planOpenDate 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setPlanOpenDate(null)));
       // 测试 openDate 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setOpenDate(null)));
       // 测试 remark 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setRemark(null)));
       // 测试 courseId 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setCourseId(null)));
       // 测试 headTeacherId 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setHeadTeacherId(null)));
       // 准备参数
       ClzPageReqVO reqVO = new ClzPageReqVO();
       reqVO.setName(null);
       reqVO.setMaxStudents(null);
       reqVO.setStatus(null);
       reqVO.setPlanOpenDate((new Date[]{}));
       reqVO.setOpenDate((new Date[]{}));
       reqVO.setRemark(null);
       reqVO.setCourseId(null);
       reqVO.setHeadTeacherId(null);

       // 调用
       PageResult<ClzDO> pageResult = clzService.getClzPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbClz, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClzList() {
       // mock 数据
       ClzDO dbClz = randomPojo(ClzDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setMaxStudents(null);
           o.setStatus(null);
           o.setPlanOpenDate(null);
           o.setOpenDate(null);
           o.setRemark(null);
           o.setCourseId(null);
           o.setHeadTeacherId(null);
       });
       clzMapper.insert(dbClz);
       // 测试 name 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setName(null)));
       // 测试 maxStudents 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setMaxStudents(null)));
       // 测试 status 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setStatus(null)));
       // 测试 planOpenDate 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setPlanOpenDate(null)));
       // 测试 openDate 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setOpenDate(null)));
       // 测试 remark 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setRemark(null)));
       // 测试 courseId 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setCourseId(null)));
       // 测试 headTeacherId 不匹配
       clzMapper.insert(cloneIgnoreId(dbClz, o -> o.setHeadTeacherId(null)));
       // 准备参数
       ClzExportReqVO reqVO = new ClzExportReqVO();
       reqVO.setName(null);
       reqVO.setMaxStudents(null);
       reqVO.setStatus(null);
       reqVO.setPlanOpenDate((new Date[]{}));
       reqVO.setOpenDate((new Date[]{}));
       reqVO.setRemark(null);
       reqVO.setCourseId(null);
       reqVO.setHeadTeacherId(null);

       // 调用
       List<ClzDO> list = clzService.getClzList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbClz, list.get(0));
    }

}
