package cn.iocoder.yudao.module.school.service.campus;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.campus.CampusConvert;
import cn.iocoder.yudao.module.school.dal.mysql.campus.CampusMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 校区 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CampusServiceImpl implements CampusService {

    @Resource
    private CampusMapper campusMapper;

    @Override
    public Long createCampus(CampusCreateReqVO createReqVO) {
        // 插入
        CampusDO campus = CampusConvert.INSTANCE.convert(createReqVO);
        campusMapper.insert(campus);
        // 返回
        return campus.getId();
    }

    @Override
    public void updateCampus(CampusUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCampusExists(updateReqVO.getId());
        // 更新
        CampusDO updateObj = CampusConvert.INSTANCE.convert(updateReqVO);
        campusMapper.updateById(updateObj);
    }

    @Override
    public void deleteCampus(Long id) {
        // 校验存在
        this.validateCampusExists(id);
        // 删除
        campusMapper.deleteById(id);
    }

    private void validateCampusExists(Long id) {
        if (campusMapper.selectById(id) == null) {
            throw exception(CAMPUS_NOT_EXISTS);
        }
    }

    @Override
    public CampusDO getCampus(Long id) {
        return campusMapper.selectById(id);
    }

    @Override
    public List<CampusDO> getCampusList(Collection<Long> ids) {
        return campusMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CampusDO> getCampusPage(CampusPageReqVO pageReqVO) {
        return campusMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CampusDO> getCampusList(CampusExportReqVO exportReqVO) {
        return campusMapper.selectList(exportReqVO);
    }

}
