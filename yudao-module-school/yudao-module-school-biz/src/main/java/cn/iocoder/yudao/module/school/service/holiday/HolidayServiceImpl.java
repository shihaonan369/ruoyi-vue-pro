package cn.iocoder.yudao.module.school.service.holiday;

import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.school.convert.holiday.HolidayConvert;
import cn.iocoder.yudao.module.school.dal.mysql.holiday.HolidayMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.school.enums.ErrorCodeConstants.*;

/**
 * 假期 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class HolidayServiceImpl implements HolidayService {

    @Resource
    private HolidayMapper holidayMapper;

    @Override
    public Long createHoliday(HolidayCreateReqVO createReqVO) {
        // 插入
        HolidayDO holiday = HolidayConvert.INSTANCE.convert(createReqVO);
        holidayMapper.insert(holiday);
        // 返回
        return holiday.getId();
    }

    @Override
    public void updateHoliday(HolidayUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateHolidayExists(updateReqVO.getId());
        // 更新
        HolidayDO updateObj = HolidayConvert.INSTANCE.convert(updateReqVO);
        holidayMapper.updateById(updateObj);
    }

    @Override
    public void deleteHoliday(Long id) {
        // 校验存在
        this.validateHolidayExists(id);
        // 删除
        holidayMapper.deleteById(id);
    }

    private void validateHolidayExists(Long id) {
        if (holidayMapper.selectById(id) == null) {
            throw exception(HOLIDAY_NOT_EXISTS);
        }
    }

    @Override
    public HolidayDO getHoliday(Long id) {
        return holidayMapper.selectById(id);
    }

    @Override
    public List<HolidayDO> getHolidayList(Collection<Long> ids) {
        return holidayMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<HolidayDO> getHolidayPage(HolidayPageReqVO pageReqVO) {
        return holidayMapper.selectPage(pageReqVO);
    }

    @Override
    public List<HolidayDO> getHolidayList(HolidayExportReqVO exportReqVO) {
        return holidayMapper.selectList(exportReqVO);
    }

    @Override
    public List<HolidayDO> getHolidayOptions() {
        return holidayMapper.selectList(new QueryWrapper<HolidayDO>().select("id", "name"));
    }

}
