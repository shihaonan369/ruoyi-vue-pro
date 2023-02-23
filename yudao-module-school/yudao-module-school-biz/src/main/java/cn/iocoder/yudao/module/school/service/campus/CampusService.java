package cn.iocoder.yudao.module.school.service.campus;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 校区 Service 接口
 *
 * @author 芋道源码
 */
public interface CampusService {

    /**
     * 创建校区
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCampus(@Valid CampusCreateReqVO createReqVO);

    /**
     * 更新校区
     *
     * @param updateReqVO 更新信息
     */
    void updateCampus(@Valid CampusUpdateReqVO updateReqVO);

    /**
     * 删除校区
     *
     * @param id 编号
     */
    void deleteCampus(Long id);

    /**
     * 获得校区
     *
     * @param id 编号
     * @return 校区
     */
    CampusDO getCampus(Long id);

    /**
     * 获得校区列表
     *
     * @param ids 编号
     * @return 校区列表
     */
    List<CampusDO> getCampusList(Collection<Long> ids);

    /**
     * 获得校区分页
     *
     * @param pageReqVO 分页查询
     * @return 校区分页
     */
    PageResult<CampusDO> getCampusPage(CampusPageReqVO pageReqVO);

    /**
     * 获得校区列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 校区列表
     */
    List<CampusDO> getCampusList(CampusExportReqVO exportReqVO);

}
