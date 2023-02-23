package cn.iocoder.yudao.module.school.service.clz;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 班级 Service 接口
 *
 * @author 芋道源码
 */
public interface ClzService {

    /**
     * 创建班级
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createClz(@Valid ClzCreateReqVO createReqVO);

    /**
     * 更新班级
     *
     * @param updateReqVO 更新信息
     */
    void updateClz(@Valid ClzUpdateReqVO updateReqVO);

    /**
     * 删除班级
     *
     * @param id 编号
     */
    void deleteClz(Long id);

    /**
     * 获得班级
     *
     * @param id 编号
     * @return 班级
     */
    ClzDO getClz(Long id);

    /**
     * 获得班级列表
     *
     * @param ids 编号
     * @return 班级列表
     */
    List<ClzDO> getClzList(Collection<Long> ids);

    /**
     * 获得班级分页
     *
     * @param pageReqVO 分页查询
     * @return 班级分页
     */
    PageResult<ClzDO> getClzPage(ClzPageReqVO pageReqVO);

    /**
     * 获得班级列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 班级列表
     */
    List<ClzDO> getClzList(ClzExportReqVO exportReqVO);

}
