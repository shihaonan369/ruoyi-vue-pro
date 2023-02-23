package cn.iocoder.yudao.module.school.service.classstudent;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 班级学生 Service 接口
 *
 * @author 芋道源码
 */
public interface ClassStudentService {

    /**
     * 创建班级学生
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createClassStudent(@Valid ClassStudentCreateReqVO createReqVO);

    /**
     * 更新班级学生
     *
     * @param updateReqVO 更新信息
     */
    void updateClassStudent(@Valid ClassStudentUpdateReqVO updateReqVO);

    /**
     * 删除班级学生
     *
     * @param id 编号
     */
    void deleteClassStudent(Long id);

    /**
     * 获得班级学生
     *
     * @param id 编号
     * @return 班级学生
     */
    ClassStudentDO getClassStudent(Long id);

    /**
     * 获得班级学生列表
     *
     * @param ids 编号
     * @return 班级学生列表
     */
    List<ClassStudentDO> getClassStudentList(Collection<Long> ids);

    /**
     * 获得班级学生分页
     *
     * @param pageReqVO 分页查询
     * @return 班级学生分页
     */
    PageResult<ClassStudentDO> getClassStudentPage(ClassStudentPageReqVO pageReqVO);

    /**
     * 获得班级学生列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 班级学生列表
     */
    List<ClassStudentDO> getClassStudentList(ClassStudentExportReqVO exportReqVO);

}
