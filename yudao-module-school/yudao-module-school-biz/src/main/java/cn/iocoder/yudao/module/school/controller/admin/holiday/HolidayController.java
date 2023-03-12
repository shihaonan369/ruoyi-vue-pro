package cn.iocoder.yudao.module.school.controller.admin.holiday;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.convert.subject.SubjectConvert;
import cn.iocoder.yudao.module.school.dal.dataobject.subject.SubjectDO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.school.controller.admin.holiday.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.holiday.HolidayDO;
import cn.iocoder.yudao.module.school.convert.holiday.HolidayConvert;
import cn.iocoder.yudao.module.school.service.holiday.HolidayService;

@Api(tags = "管理后台 - 假期")
@RestController
@RequestMapping("/school/holiday")
@Validated
public class HolidayController {

    @Resource
    private HolidayService holidayService;

    @PostMapping("/create")
    @ApiOperation("创建假期")
    @PreAuthorize("@ss.hasPermission('school:holiday:create')")
    public CommonResult<Long> createHoliday(@Valid @RequestBody HolidayCreateReqVO createReqVO) {
        return success(holidayService.createHoliday(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新假期")
    @PreAuthorize("@ss.hasPermission('school:holiday:update')")
    public CommonResult<Boolean> updateHoliday(@Valid @RequestBody HolidayUpdateReqVO updateReqVO) {
        holidayService.updateHoliday(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除假期")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:holiday:delete')")
    public CommonResult<Boolean> deleteHoliday(@RequestParam("id") Long id) {
        holidayService.deleteHoliday(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得假期")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:holiday:query')")
    public CommonResult<HolidayRespVO> getHoliday(@RequestParam("id") Long id) {
        HolidayDO holiday = holidayService.getHoliday(id);
        return success(HolidayConvert.INSTANCE.convert(holiday));
    }

    @GetMapping("/list")
    @ApiOperation("获得假期列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:holiday:query')")
    public CommonResult<List<HolidayRespVO>> getHolidayList(@RequestParam("ids") Collection<Long> ids) {
        List<HolidayDO> list = holidayService.getHolidayList(ids);
        return success(HolidayConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得假期分页")
    @PreAuthorize("@ss.hasPermission('school:holiday:query')")
    public CommonResult<PageResult<HolidayRespVO>> getHolidayPage(@Valid HolidayPageReqVO pageVO) {
        PageResult<HolidayDO> pageResult = holidayService.getHolidayPage(pageVO);
        return success(HolidayConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出假期 Excel")
    @PreAuthorize("@ss.hasPermission('school:holiday:export')")
    @OperateLog(type = EXPORT)
    public void exportHolidayExcel(@Valid HolidayExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<HolidayDO> list = holidayService.getHolidayList(exportReqVO);
        // 导出 Excel
        List<HolidayExcelVO> datas = HolidayConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "假期.xls", "数据", HolidayExcelVO.class, datas);
    }

    @GetMapping("/options")
    @ApiOperation("选项")
    @PreAuthorize("@ss.hasPermission('school:holiday:query')")
    public CommonResult<List<OptionVo>> getHolidayOptions() {
        List<HolidayDO> list = holidayService.getHolidayOptions();
        return success(HolidayConvert.INSTANCE.convertOptionList(list));
    }

}
