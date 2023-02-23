package cn.iocoder.yudao.module.school.controller.admin.campus;

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

import cn.iocoder.yudao.module.school.controller.admin.campus.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
import cn.iocoder.yudao.module.school.convert.campus.CampusConvert;
import cn.iocoder.yudao.module.school.service.campus.CampusService;

@Api(tags = "管理后台 - 校区")
@RestController
@RequestMapping("/school/campus")
@Validated
public class CampusController {

    @Resource
    private CampusService campusService;

    @PostMapping("/create")
    @ApiOperation("创建校区")
    @PreAuthorize("@ss.hasPermission('school:campus:create')")
    public CommonResult<Long> createCampus(@Valid @RequestBody CampusCreateReqVO createReqVO) {
        return success(campusService.createCampus(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新校区")
    @PreAuthorize("@ss.hasPermission('school:campus:update')")
    public CommonResult<Boolean> updateCampus(@Valid @RequestBody CampusUpdateReqVO updateReqVO) {
        campusService.updateCampus(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除校区")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:campus:delete')")
    public CommonResult<Boolean> deleteCampus(@RequestParam("id") Long id) {
        campusService.deleteCampus(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得校区")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:campus:query')")
    public CommonResult<CampusRespVO> getCampus(@RequestParam("id") Long id) {
        CampusDO campus = campusService.getCampus(id);
        return success(CampusConvert.INSTANCE.convert(campus));
    }

    @GetMapping("/list")
    @ApiOperation("获得校区列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:campus:query')")
    public CommonResult<List<CampusRespVO>> getCampusList(@RequestParam("ids") Collection<Long> ids) {
        List<CampusDO> list = campusService.getCampusList(ids);
        return success(CampusConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得校区分页")
    @PreAuthorize("@ss.hasPermission('school:campus:query')")
    public CommonResult<PageResult<CampusRespVO>> getCampusPage(@Valid CampusPageReqVO pageVO) {
        PageResult<CampusDO> pageResult = campusService.getCampusPage(pageVO);
        return success(CampusConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出校区 Excel")
    @PreAuthorize("@ss.hasPermission('school:campus:export')")
    @OperateLog(type = EXPORT)
    public void exportCampusExcel(@Valid CampusExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CampusDO> list = campusService.getCampusList(exportReqVO);
        // 导出 Excel
        List<CampusExcelVO> datas = CampusConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "校区.xls", "数据", CampusExcelVO.class, datas);
    }

}
