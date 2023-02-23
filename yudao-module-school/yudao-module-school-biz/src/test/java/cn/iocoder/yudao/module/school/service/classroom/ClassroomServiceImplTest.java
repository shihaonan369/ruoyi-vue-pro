package cn.iocoder.yudao.module.school.service.classroom;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;
import cn.iocoder.yudao.module.school.dal.mysql.classroom.ClassroomMapper;
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
* {@link ClassroomServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ClassroomServiceImpl.class)
public class ClassroomServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ClassroomServiceImpl classroomService;

    @Resource
    private ClassroomMapper classroomMapper;

    @Test
    public void testCreateClassroom_success() {
        // 准备参数
        ClassroomCreateReqVO reqVO = randomPojo(ClassroomCreateReqVO.class);

        // 调用
        Long classroomId = classroomService.createClassroom(reqVO);
        // 断言
        assertNotNull(classroomId);
        // 校验记录的属性是否正确
        ClassroomDO classroom = classroomMapper.selectById(classroomId);
        assertPojoEquals(reqVO, classroom);
    }

    @Test
    public void testUpdateClassroom_success() {
        // mock 数据
        ClassroomDO dbClassroom = randomPojo(ClassroomDO.class);
        classroomMapper.insert(dbClassroom);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ClassroomUpdateReqVO reqVO = randomPojo(ClassroomUpdateReqVO.class, o -> {
            o.setId(dbClassroom.getId()); // 设置更新的 ID
        });

        // 调用
        classroomService.updateClassroom(reqVO);
        // 校验是否更新正确
        ClassroomDO classroom = classroomMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, classroom);
    }

    @Test
    public void testUpdateClassroom_notExists() {
        // 准备参数
        ClassroomUpdateReqVO reqVO = randomPojo(ClassroomUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> classroomService.updateClassroom(reqVO), CLASSROOM_NOT_EXISTS);
    }

    @Test
    public void testDeleteClassroom_success() {
        // mock 数据
        ClassroomDO dbClassroom = randomPojo(ClassroomDO.class);
        classroomMapper.insert(dbClassroom);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbClassroom.getId();

        // 调用
        classroomService.deleteClassroom(id);
       // 校验数据不存在了
       assertNull(classroomMapper.selectById(id));
    }

    @Test
    public void testDeleteClassroom_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> classroomService.deleteClassroom(id), CLASSROOM_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassroomPage() {
       // mock 数据
       ClassroomDO dbClassroom = randomPojo(ClassroomDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusId(null);
       });
       classroomMapper.insert(dbClassroom);
       // 测试 name 不匹配
       classroomMapper.insert(cloneIgnoreId(dbClassroom, o -> o.setName(null)));
       // 测试 campusId 不匹配
       classroomMapper.insert(cloneIgnoreId(dbClassroom, o -> o.setCampusId(null)));
       // 准备参数
       ClassroomPageReqVO reqVO = new ClassroomPageReqVO();
       reqVO.setName(null);
       reqVO.setCampusId(null);

       // 调用
       PageResult<ClassroomDO> pageResult = classroomService.getClassroomPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbClassroom, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassroomList() {
       // mock 数据
       ClassroomDO dbClassroom = randomPojo(ClassroomDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setCampusId(null);
       });
       classroomMapper.insert(dbClassroom);
       // 测试 name 不匹配
       classroomMapper.insert(cloneIgnoreId(dbClassroom, o -> o.setName(null)));
       // 测试 campusId 不匹配
       classroomMapper.insert(cloneIgnoreId(dbClassroom, o -> o.setCampusId(null)));
       // 准备参数
       ClassroomExportReqVO reqVO = new ClassroomExportReqVO();
       reqVO.setName(null);
       reqVO.setCampusId(null);

       // 调用
       List<ClassroomDO> list = classroomService.getClassroomList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbClassroom, list.get(0));
    }

}
