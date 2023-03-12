package cn.iocoder.yudao.module.school.service.teacher;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 教师 Service 接口
 *
 * @author 芋道源码
 */
public interface TeacherService {

    /**
     * 创建教师
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTeacher(@Valid TeacherCreateReqVO createReqVO);

    /**
     * 更新教师
     *
     * @param updateReqVO 更新信息
     */
    void updateTeacher(@Valid TeacherUpdateReqVO updateReqVO);

    /**
     * 删除教师
     *
     * @param id 编号
     */
    void deleteTeacher(Long id);

    /**
     * 获得教师
     *
     * @param id 编号
     * @return 教师
     */
    TeacherDO getTeacher(Long id);

    /**
     * 获得教师列表
     *
     * @param ids 编号
     * @return 教师列表
     */
    List<TeacherDO> getTeacherList(Collection<Long> ids);

    /**
     * 获得教师分页
     *
     * @param pageReqVO 分页查询
     * @return 教师分页
     */
    PageResult<TeacherDO> getTeacherPage(TeacherPageReqVO pageReqVO);

    /**
     * 获得教师列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 教师列表
     */
    List<TeacherDO> getTeacherList(TeacherExportReqVO exportReqVO);

    /**
     * 获取教师选项
     *
     * @return 教师选项
     */
    List<TeacherDO> getTeacherOptions();

}
