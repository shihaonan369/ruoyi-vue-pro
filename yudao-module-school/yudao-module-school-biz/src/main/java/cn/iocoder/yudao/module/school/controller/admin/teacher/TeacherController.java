package cn.iocoder.yudao.module.school.controller.admin.teacher;

import cn.iocoder.yudao.module.school.controller.admin.common.vo.OptionVo;
import cn.iocoder.yudao.module.school.convert.campus.CampusConvert;
import cn.iocoder.yudao.module.school.dal.dataobject.campus.CampusDO;
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

import cn.iocoder.yudao.module.school.controller.admin.teacher.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.teacher.TeacherDO;
import cn.iocoder.yudao.module.school.convert.teacher.TeacherConvert;
import cn.iocoder.yudao.module.school.service.teacher.TeacherService;

@Api(tags = "管理后台 - 教师")
@RestController
@RequestMapping("/school/teacher")
@Validated
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @PostMapping("/create")
    @ApiOperation("创建教师")
    @PreAuthorize("@ss.hasPermission('school:teacher:create')")
    public CommonResult<Long> createTeacher(@Valid @RequestBody TeacherCreateReqVO createReqVO) {
        return success(teacherService.createTeacher(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新教师")
    @PreAuthorize("@ss.hasPermission('school:teacher:update')")
    public CommonResult<Boolean> updateTeacher(@Valid @RequestBody TeacherUpdateReqVO updateReqVO) {
        teacherService.updateTeacher(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除教师")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:teacher:delete')")
    public CommonResult<Boolean> deleteTeacher(@RequestParam("id") Long id) {
        teacherService.deleteTeacher(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得教师")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:teacher:query')")
    public CommonResult<TeacherRespVO> getTeacher(@RequestParam("id") Long id) {
        TeacherDO teacher = teacherService.getTeacher(id);
        return success(TeacherConvert.INSTANCE.convert(teacher));
    }

    @GetMapping("/list")
    @ApiOperation("获得教师列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:teacher:query')")
    public CommonResult<List<TeacherRespVO>> getTeacherList(@RequestParam("ids") Collection<Long> ids) {
        List<TeacherDO> list = teacherService.getTeacherList(ids);
        return success(TeacherConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得教师分页")
    @PreAuthorize("@ss.hasPermission('school:teacher:query')")
    public CommonResult<PageResult<TeacherRespVO>> getTeacherPage(@Valid TeacherPageReqVO pageVO) {
        PageResult<TeacherDO> pageResult = teacherService.getTeacherPage(pageVO);
        return success(TeacherConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出教师 Excel")
    @PreAuthorize("@ss.hasPermission('school:teacher:export')")
    @OperateLog(type = EXPORT)
    public void exportTeacherExcel(@Valid TeacherExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TeacherDO> list = teacherService.getTeacherList(exportReqVO);
        // 导出 Excel
        List<TeacherExcelVO> datas = TeacherConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "教师.xls", "数据", TeacherExcelVO.class, datas);
    }


    @GetMapping("/options")
    @ApiOperation("选项")
    @PreAuthorize("@ss.hasPermission('school:teacher:query')")
    public CommonResult<List<OptionVo>> getTeacherOptions() {
        List<TeacherDO> list = teacherService.getTeacherOptions();
        return success(TeacherConvert.INSTANCE.convertOptionList(list));
    }
}
