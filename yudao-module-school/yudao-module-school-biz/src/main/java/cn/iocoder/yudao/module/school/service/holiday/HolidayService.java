package cn.iocoder.yudao.module.school.service.holiday;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 假期 Service 接口
 *
 * @author 芋道源码
 */
public interface HolidayService {

    /**
     * 创建假期
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHoliday(@Valid HolidayCreateReqVO createReqVO);

    /**
     * 更新假期
     *
     * @param updateReqVO 更新信息
     */
    void updateHoliday(@Valid HolidayUpdateReqVO updateReqVO);

    /**
     * 删除假期
     *
     * @param id 编号
     */
    void deleteHoliday(Long id);

    /**
     * 获得假期
     *
     * @param id 编号
     * @return 假期
     */
    HolidayDO getHoliday(Long id);

    /**
     * 获得假期列表
     *
     * @param ids 编号
     * @return 假期列表
     */
    List<HolidayDO> getHolidayList(Collection<Long> ids);

    /**
     * 获得假期分页
     *
     * @param pageReqVO 分页查询
     * @return 假期分页
     */
    PageResult<HolidayDO> getHolidayPage(HolidayPageReqVO pageReqVO);

    /**
     * 获得假期列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 假期列表
     */
    List<HolidayDO> getHolidayList(HolidayExportReqVO exportReqVO);

}
