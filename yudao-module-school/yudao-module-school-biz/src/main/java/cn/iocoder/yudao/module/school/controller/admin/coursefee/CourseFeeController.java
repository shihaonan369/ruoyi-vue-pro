package cn.iocoder.yudao.module.school.controller.admin.coursefee;

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

import cn.iocoder.yudao.module.school.controller.admin.coursefee.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.coursefee.CourseFeeDO;
import cn.iocoder.yudao.module.school.convert.coursefee.CourseFeeConvert;
import cn.iocoder.yudao.module.school.service.coursefee.CourseFeeService;

@Api(tags = "管理后台 - 课程收费")
@RestController
@RequestMapping("/school/course-fee")
@Validated
public class CourseFeeController {

    @Resource
    private CourseFeeService courseFeeService;

    @PostMapping("/create")
    @ApiOperation("创建课程收费")
    @PreAuthorize("@ss.hasPermission('school:course-fee:create')")
    public CommonResult<Long> createCourseFee(@Valid @RequestBody CourseFeeCreateReqVO createReqVO) {
        return success(courseFeeService.createCourseFee(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新课程收费")
    @PreAuthorize("@ss.hasPermission('school:course-fee:update')")
    public CommonResult<Boolean> updateCourseFee(@Valid @RequestBody CourseFeeUpdateReqVO updateReqVO) {
        courseFeeService.updateCourseFee(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除课程收费")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:course-fee:delete')")
    public CommonResult<Boolean> deleteCourseFee(@RequestParam("id") Long id) {
        courseFeeService.deleteCourseFee(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得课程收费")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:course-fee:query')")
    public CommonResult<CourseFeeRespVO> getCourseFee(@RequestParam("id") Long id) {
        CourseFeeDO courseFee = courseFeeService.getCourseFee(id);
        return success(CourseFeeConvert.INSTANCE.convert(courseFee));
    }

    @GetMapping("/list")
    @ApiOperation("获得课程收费列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:course-fee:query')")
    public CommonResult<List<CourseFeeRespVO>> getCourseFeeList(@RequestParam("ids") Collection<Long> ids) {
        List<CourseFeeDO> list = courseFeeService.getCourseFeeList(ids);
        return success(CourseFeeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得课程收费分页")
    @PreAuthorize("@ss.hasPermission('school:course-fee:query')")
    public CommonResult<PageResult<CourseFeeRespVO>> getCourseFeePage(@Valid CourseFeePageReqVO pageVO) {
        PageResult<CourseFeeDO> pageResult = courseFeeService.getCourseFeePage(pageVO);
        return success(CourseFeeConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出课程收费 Excel")
    @PreAuthorize("@ss.hasPermission('school:course-fee:export')")
    @OperateLog(type = EXPORT)
    public void exportCourseFeeExcel(@Valid CourseFeeExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CourseFeeDO> list = courseFeeService.getCourseFeeList(exportReqVO);
        // 导出 Excel
        List<CourseFeeExcelVO> datas = CourseFeeConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "课程收费.xls", "数据", CourseFeeExcelVO.class, datas);
    }

}
