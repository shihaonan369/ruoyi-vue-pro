package cn.iocoder.yudao.module.school.controller.admin.timetable;

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

import cn.iocoder.yudao.module.school.controller.admin.timetable.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.timetable.TimetableDO;
import cn.iocoder.yudao.module.school.convert.timetable.TimetableConvert;
import cn.iocoder.yudao.module.school.service.timetable.TimetableService;

@Api(tags = "管理后台 - 课程")
@RestController
@RequestMapping("/school/timetable")
@Validated
public class TimetableController {

    @Resource
    private TimetableService timetableService;

    @PostMapping("/create")
    @ApiOperation("创建课程")
    @PreAuthorize("@ss.hasPermission('school:timetable:create')")
    public CommonResult<Long> createTimetable(@Valid @RequestBody TimetableCreateReqVO createReqVO) {
        return success(timetableService.createTimetable(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新课程")
    @PreAuthorize("@ss.hasPermission('school:timetable:update')")
    public CommonResult<Boolean> updateTimetable(@Valid @RequestBody TimetableUpdateReqVO updateReqVO) {
        timetableService.updateTimetable(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除课程")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:timetable:delete')")
    public CommonResult<Boolean> deleteTimetable(@RequestParam("id") Long id) {
        timetableService.deleteTimetable(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得课程")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:timetable:query')")
    public CommonResult<TimetableRespVO> getTimetable(@RequestParam("id") Long id) {
        TimetableDO timetable = timetableService.getTimetable(id);
        return success(TimetableConvert.INSTANCE.convert(timetable));
    }

    @GetMapping("/list")
    @ApiOperation("获得课程列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:timetable:query')")
    public CommonResult<List<TimetableRespVO>> getTimetableList(@RequestParam("ids") Collection<Long> ids) {
        List<TimetableDO> list = timetableService.getTimetableList(ids);
        return success(TimetableConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得课程分页")
    @PreAuthorize("@ss.hasPermission('school:timetable:query')")
    public CommonResult<PageResult<TimetableRespVO>> getTimetablePage(@Valid TimetablePageReqVO pageVO) {
        PageResult<TimetableDO> pageResult = timetableService.getTimetablePage(pageVO);
        return success(TimetableConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出课程 Excel")
    @PreAuthorize("@ss.hasPermission('school:timetable:export')")
    @OperateLog(type = EXPORT)
    public void exportTimetableExcel(@Valid TimetableExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TimetableDO> list = timetableService.getTimetableList(exportReqVO);
        // 导出 Excel
        List<TimetableExcelVO> datas = TimetableConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "课程.xls", "数据", TimetableExcelVO.class, datas);
    }

}
