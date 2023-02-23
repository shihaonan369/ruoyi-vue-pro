package cn.iocoder.yudao.module.school.service.classroom;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 教室 Service 接口
 *
 * @author 芋道源码
 */
public interface ClassroomService {

    /**
     * 创建教室
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createClassroom(@Valid ClassroomCreateReqVO createReqVO);

    /**
     * 更新教室
     *
     * @param updateReqVO 更新信息
     */
    void updateClassroom(@Valid ClassroomUpdateReqVO updateReqVO);

    /**
     * 删除教室
     *
     * @param id 编号
     */
    void deleteClassroom(Long id);

    /**
     * 获得教室
     *
     * @param id 编号
     * @return 教室
     */
    ClassroomDO getClassroom(Long id);

    /**
     * 获得教室列表
     *
     * @param ids 编号
     * @return 教室列表
     */
    List<ClassroomDO> getClassroomList(Collection<Long> ids);

    /**
     * 获得教室分页
     *
     * @param pageReqVO 分页查询
     * @return 教室分页
     */
    PageResult<ClassroomDO> getClassroomPage(ClassroomPageReqVO pageReqVO);

    /**
     * 获得教室列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 教室列表
     */
    List<ClassroomDO> getClassroomList(ClassroomExportReqVO exportReqVO);

}
