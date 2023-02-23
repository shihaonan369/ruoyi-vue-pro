package cn.iocoder.yudao.module.school.service.classstudent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import cn.iocoder.yudao.module.school.dal.mysql.classstudent.ClassStudentMapper;
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
* {@link ClassStudentServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ClassStudentServiceImpl.class)
public class ClassStudentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ClassStudentServiceImpl classStudentService;

    @Resource
    private ClassStudentMapper classStudentMapper;

    @Test
    public void testCreateClassStudent_success() {
        // 准备参数
        ClassStudentCreateReqVO reqVO = randomPojo(ClassStudentCreateReqVO.class);

        // 调用
        Long classStudentId = classStudentService.createClassStudent(reqVO);
        // 断言
        assertNotNull(classStudentId);
        // 校验记录的属性是否正确
        ClassStudentDO classStudent = classStudentMapper.selectById(classStudentId);
        assertPojoEquals(reqVO, classStudent);
    }

    @Test
    public void testUpdateClassStudent_success() {
        // mock 数据
        ClassStudentDO dbClassStudent = randomPojo(ClassStudentDO.class);
        classStudentMapper.insert(dbClassStudent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ClassStudentUpdateReqVO reqVO = randomPojo(ClassStudentUpdateReqVO.class, o -> {
            o.setId(dbClassStudent.getId()); // 设置更新的 ID
        });

        // 调用
        classStudentService.updateClassStudent(reqVO);
        // 校验是否更新正确
        ClassStudentDO classStudent = classStudentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, classStudent);
    }

    @Test
    public void testUpdateClassStudent_notExists() {
        // 准备参数
        ClassStudentUpdateReqVO reqVO = randomPojo(ClassStudentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> classStudentService.updateClassStudent(reqVO), CLASS_STUDENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteClassStudent_success() {
        // mock 数据
        ClassStudentDO dbClassStudent = randomPojo(ClassStudentDO.class);
        classStudentMapper.insert(dbClassStudent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbClassStudent.getId();

        // 调用
        classStudentService.deleteClassStudent(id);
       // 校验数据不存在了
       assertNull(classStudentMapper.selectById(id));
    }

    @Test
    public void testDeleteClassStudent_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> classStudentService.deleteClassStudent(id), CLASS_STUDENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassStudentPage() {
       // mock 数据
       ClassStudentDO dbClassStudent = randomPojo(ClassStudentDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setEnterDate(null);
           o.setClassId(null);
           o.setStudentId(null);
       });
       classStudentMapper.insert(dbClassStudent);
       // 测试 number 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setNumber(null)));
       // 测试 enterDate 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setEnterDate(null)));
       // 测试 classId 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setClassId(null)));
       // 测试 studentId 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setStudentId(null)));
       // 准备参数
       ClassStudentPageReqVO reqVO = new ClassStudentPageReqVO();
       reqVO.setNumber(null);
       reqVO.setEnterDate((new Date[]{}));
       reqVO.setClassId(null);
       reqVO.setStudentId(null);

       // 调用
       PageResult<ClassStudentDO> pageResult = classStudentService.getClassStudentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbClassStudent, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassStudentList() {
       // mock 数据
       ClassStudentDO dbClassStudent = randomPojo(ClassStudentDO.class, o -> { // 等会查询到
           o.setNumber(null);
           o.setEnterDate(null);
           o.setClassId(null);
           o.setStudentId(null);
       });
       classStudentMapper.insert(dbClassStudent);
       // 测试 number 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setNumber(null)));
       // 测试 enterDate 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setEnterDate(null)));
       // 测试 classId 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setClassId(null)));
       // 测试 studentId 不匹配
       classStudentMapper.insert(cloneIgnoreId(dbClassStudent, o -> o.setStudentId(null)));
       // 准备参数
       ClassStudentExportReqVO reqVO = new ClassStudentExportReqVO();
       reqVO.setNumber(null);
       reqVO.setEnterDate((new Date[]{}));
       reqVO.setClassId(null);
       reqVO.setStudentId(null);

       // 调用
       List<ClassStudentDO> list = classStudentService.getClassStudentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbClassStudent, list.get(0));
    }

}
