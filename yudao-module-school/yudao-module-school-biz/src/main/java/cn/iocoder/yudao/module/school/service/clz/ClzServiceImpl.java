package cn.iocoder.yudao.module.school.service.clz;

import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.ClassStudentBaseVO;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.clz.ClzConvert;
import cn.iocoder.yudao.module.school.dal.mysql.clz.ClzMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 班级 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ClzServiceImpl implements ClzService {

    @Resource
    private ClzMapper clzMapper;

    @Override
    public Long createClz(ClzCreateReqVO createReqVO) {
        // 插入
        ClzDO clz = ClzConvert.INSTANCE.convert(createReqVO);
        clzMapper.insert(clz);
        // 返回
        return clz.getId();
    }

    @Override
    public void updateClz(ClzUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateClzExists(updateReqVO.getId());
        // 更新
        ClzDO updateObj = ClzConvert.INSTANCE.convert(updateReqVO);
        clzMapper.updateById(updateObj);
    }

    @Override
    public void deleteClz(Long id) {
        // 校验存在
        this.validateClzExists(id);
        // 删除
        clzMapper.deleteById(id);
    }

    private void validateClzExists(Long id) {
        if (clzMapper.selectById(id) == null) {
            throw exception(CLASS_NOT_EXISTS);
        }
    }

    @Override
    public ClzDO getClz(Long id) {
        return clzMapper.selectById(id);
    }

    @Override
    public List<ClzDO> getClzList(Collection<Long> ids) {
        return clzMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ClzDO> getClzPage(ClzPageReqVO pageReqVO) {
        return clzMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ClzDO> getClzList(ClzExportReqVO exportReqVO) {
        return clzMapper.selectList(exportReqVO);
    }

    @Override
    public List<ClzDO> getClzOptions() {
        return clzMapper.selectList(new QueryWrapper<ClzDO>().select("id", "name"));
    }

    @Override
    public List<ClzDO> getClzList(ClzBaseVO entity) {
        return clzMapper.selectList(entity);
    }

}
