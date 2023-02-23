package cn.iocoder.yudao.module.school.service.timetable;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.timetable.TimetableConvert;
import cn.iocoder.yudao.module.school.dal.mysql.timetable.TimetableMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 课程 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TimetableServiceImpl implements TimetableService {

    @Resource
    private TimetableMapper timetableMapper;

    @Override
    public Long createTimetable(TimetableCreateReqVO createReqVO) {
        // 插入
        TimetableDO timetable = TimetableConvert.INSTANCE.convert(createReqVO);
        timetableMapper.insert(timetable);
        // 返回
        return timetable.getId();
    }

    @Override
    public void updateTimetable(TimetableUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTimetableExists(updateReqVO.getId());
        // 更新
        TimetableDO updateObj = TimetableConvert.INSTANCE.convert(updateReqVO);
        timetableMapper.updateById(updateObj);
    }

    @Override
    public void deleteTimetable(Long id) {
        // 校验存在
        this.validateTimetableExists(id);
        // 删除
        timetableMapper.deleteById(id);
    }

    private void validateTimetableExists(Long id) {
        if (timetableMapper.selectById(id) == null) {
            throw exception(TIMETABLE_NOT_EXISTS);
        }
    }

    @Override
    public TimetableDO getTimetable(Long id) {
        return timetableMapper.selectById(id);
    }

    @Override
    public List<TimetableDO> getTimetableList(Collection<Long> ids) {
        return timetableMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TimetableDO> getTimetablePage(TimetablePageReqVO pageReqVO) {
        return timetableMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TimetableDO> getTimetableList(TimetableExportReqVO exportReqVO) {
        return timetableMapper.selectList(exportReqVO);
    }

}
