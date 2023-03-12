package cn.iocoder.yudao.module.school.controller.admin.classstudent;

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

import cn.iocoder.yudao.module.school.controller.admin.classstudent.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classstudent.ClassStudentDO;
import cn.iocoder.yudao.module.school.convert.classstudent.ClassStudentConvert;
import cn.iocoder.yudao.module.school.service.classstudent.ClassStudentService;

@Api(tags = "管理后台 - 班级学生")
@RestController
@RequestMapping("/school/class-student")
@Validated
public class ClassStudentController {

    @Resource
    private ClassStudentService classStudentService;

    @PostMapping("/create")
    @ApiOperation("创建班级学生")
    @PreAuthorize("@ss.hasPermission('school:class-student:create')")
    public CommonResult<Long> createClassStudent(@Valid @RequestBody ClassStudentCreateReqVO createReqVO) {
        return success(classStudentService.createClassStudent(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新班级学生")
    @PreAuthorize("@ss.hasPermission('school:class-student:update')")
    public CommonResult<Boolean> updateClassStudent(@Valid @RequestBody ClassStudentUpdateReqVO updateReqVO) {
        classStudentService.updateClassStudent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除班级学生")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:class-student:delete')")
    public CommonResult<Boolean> deleteClassStudent(@RequestParam("id") Long id) {
        classStudentService.deleteClassStudent(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得班级学生")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:class-student:query')")
    public CommonResult<ClassStudentRespVO> getClassStudent(@RequestParam("id") Long id) {
        ClassStudentDO classStudent = classStudentService.getClassStudent(id);
        return success(ClassStudentConvert.INSTANCE.convert(classStudent));
    }

    @GetMapping("/list")
    @ApiOperation("获得班级学生列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:class-student:query')")
    public CommonResult<List<ClassStudentRespVO>> getClassStudentList(@RequestParam("ids") Collection<Long> ids) {
        List<ClassStudentDO> list = classStudentService.getClassStudentList(ids);
        return success(ClassStudentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得班级学生分页")
    @PreAuthorize("@ss.hasPermission('school:class-student:query')")
    public CommonResult<PageResult<ClassStudentRespVO>> getClassStudentPage(@Valid ClassStudentPageReqVO pageVO) {
        PageResult<ClassStudentDO> pageResult = classStudentService.getClassStudentPage(pageVO);
        return success(ClassStudentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出班级学生 Excel")
    @PreAuthorize("@ss.hasPermission('school:class-student:export')")
    @OperateLog(type = EXPORT)
    public void exportClassStudentExcel(@Valid ClassStudentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ClassStudentDO> list = classStudentService.getClassStudentList(exportReqVO);
        // 导出 Excel
        List<ClassStudentExcelVO> datas = ClassStudentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "班级学生.xls", "数据", ClassStudentExcelVO.class, datas);
    }

    @GetMapping("/list-by-filter")
    @ApiOperation("获取班级学生列表")
    @PreAuthorize("@ss.hasPermission('school:class-student:query')")
    public CommonResult<List<ClassStudentRespVO>> getClassStudentList(@Valid ClassStudentBaseVO reqVO) {
        List<ClassStudentDO> list = classStudentService.getClassStudentList(reqVO);
        return success(ClassStudentConvert.INSTANCE.convertList(list));
    }

}
