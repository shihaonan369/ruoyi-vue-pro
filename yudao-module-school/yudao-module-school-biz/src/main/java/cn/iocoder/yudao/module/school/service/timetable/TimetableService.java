package cn.iocoder.yudao.module.school.service.timetable;

import java.util.*;
import javax.validation.*;

import cn.iocoder.yudao.module.school.controller.admin.clz.vo.ClzBaseVO;
import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 课表 Service 接口
 *
 * @author 芋道源码
 */
public interface TimetableService {

    /**
     * 创建课表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTimetable(@Valid TimetableCreateReqVO createReqVO);

    /**
     * 更新课表
     *
     * @param updateReqVO 更新信息
     */
    void updateTimetable(@Valid TimetableUpdateReqVO updateReqVO);

    /**
     * 删除课表
     *
     * @param id 编号
     */
    void deleteTimetable(Long id);

    /**
     * 获得课表
     *
     * @param id 编号
     * @return 课表
     */
    TimetableDO getTimetable(Long id);

    /**
     * 获得课表列表
     *
     * @param ids 编号
     * @return 课表列表
     */
    List<TimetableDO> getTimetableList(Collection<Long> ids);

    /**
     * 获得课表分页
     *
     * @param pageReqVO 分页查询
     * @return 课表分页
     */
    PageResult<TimetableDO> getTimetablePage(TimetablePageReqVO pageReqVO);

    /**
     * 获得课表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 课表列表
     */
    List<TimetableDO> getTimetableList(TimetableExportReqVO exportReqVO);

    /**
     * 获取课表选项
     *
     * @return 课表选项
     */
    List<TimetableDO> getTimetableOptions();

    /**
     * 获取课表列表
     *
     * @param reqVO 查询条件
     * @return 课表列表
     */
    List<TimetableDO> getTimetableList(TimetableBaseVO reqVO);

}
