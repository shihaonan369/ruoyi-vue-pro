package cn.iocoder.yudao.module.school.service.coursefee;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 课程收费 Service 接口
 *
 * @author 芋道源码
 */
public interface CourseFeeService {

    /**
     * 创建课程收费
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCourseFee(@Valid CourseFeeCreateReqVO createReqVO);

    /**
     * 更新课程收费
     *
     * @param updateReqVO 更新信息
     */
    void updateCourseFee(@Valid CourseFeeUpdateReqVO updateReqVO);

    /**
     * 删除课程收费
     *
     * @param id 编号
     */
    void deleteCourseFee(Long id);

    /**
     * 获得课程收费
     *
     * @param id 编号
     * @return 课程收费
     */
    CourseFeeDO getCourseFee(Long id);

    /**
     * 获得课程收费列表
     *
     * @param ids 编号
     * @return 课程收费列表
     */
    List<CourseFeeDO> getCourseFeeList(Collection<Long> ids);

    /**
     * 获得课程收费分页
     *
     * @param pageReqVO 分页查询
     * @return 课程收费分页
     */
    PageResult<CourseFeeDO> getCourseFeePage(CourseFeePageReqVO pageReqVO);

    /**
     * 获得课程收费列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 课程收费列表
     */
    List<CourseFeeDO> getCourseFeeList(CourseFeeExportReqVO exportReqVO);

}
