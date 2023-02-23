package cn.iocoder.yudao.module.school.controller.admin.clz;

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

import cn.iocoder.yudao.module.school.controller.admin.clz.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.clz.ClzDO;
import cn.iocoder.yudao.module.school.convert.clz.ClzConvert;
import cn.iocoder.yudao.module.school.service.clz.ClzService;

@Api(tags = "管理后台 - 班级")
@RestController
@RequestMapping("/school/clz")
@Validated
public class ClzController {

    @Resource
    private ClzService clzService;

    @PostMapping("/create")
    @ApiOperation("创建班级")
    @PreAuthorize("@ss.hasPermission('school:clz:create')")
    public CommonResult<Long> createClz(@Valid @RequestBody ClzCreateReqVO createReqVO) {
        return success(clzService.createClz(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新班级")
    @PreAuthorize("@ss.hasPermission('school:clz:update')")
    public CommonResult<Boolean> updateClz(@Valid @RequestBody ClzUpdateReqVO updateReqVO) {
        clzService.updateClz(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除班级")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:clz:delete')")
    public CommonResult<Boolean> deleteClz(@RequestParam("id") Long id) {
        clzService.deleteClz(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得班级")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:clz:query')")
    public CommonResult<ClzRespVO> getClz(@RequestParam("id") Long id) {
        ClzDO clz = clzService.getClz(id);
        return success(ClzConvert.INSTANCE.convert(clz));
    }

    @GetMapping("/list")
    @ApiOperation("获得班级列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:clz:query')")
    public CommonResult<List<ClzRespVO>> getClzList(@RequestParam("ids") Collection<Long> ids) {
        List<ClzDO> list = clzService.getClzList(ids);
        return success(ClzConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得班级分页")
    @PreAuthorize("@ss.hasPermission('school:clz:query')")
    public CommonResult<PageResult<ClzRespVO>> getClzPage(@Valid ClzPageReqVO pageVO) {
        PageResult<ClzDO> pageResult = clzService.getClzPage(pageVO);
        return success(ClzConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出班级 Excel")
    @PreAuthorize("@ss.hasPermission('school:clz:export')")
    @OperateLog(type = EXPORT)
    public void exportClzExcel(@Valid ClzExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ClzDO> list = clzService.getClzList(exportReqVO);
        // 导出 Excel
        List<ClzExcelVO> datas = ClzConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "班级.xls", "数据", ClzExcelVO.class, datas);
    }

}
