package cn.iocoder.yudao.module.school.controller.admin.classroom;

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

import cn.iocoder.yudao.module.school.controller.admin.classroom.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.classroom.ClassroomDO;
import cn.iocoder.yudao.module.school.convert.classroom.ClassroomConvert;
import cn.iocoder.yudao.module.school.service.classroom.ClassroomService;

@Api(tags = "管理后台 - 教室")
@RestController
@RequestMapping("/school/classroom")
@Validated
public class ClassroomController {

    @Resource
    private ClassroomService classroomService;

    @PostMapping("/create")
    @ApiOperation("创建教室")
    @PreAuthorize("@ss.hasPermission('school:classroom:create')")
    public CommonResult<Long> createClassroom(@Valid @RequestBody ClassroomCreateReqVO createReqVO) {
        return success(classroomService.createClassroom(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新教室")
    @PreAuthorize("@ss.hasPermission('school:classroom:update')")
    public CommonResult<Boolean> updateClassroom(@Valid @RequestBody ClassroomUpdateReqVO updateReqVO) {
        classroomService.updateClassroom(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除教室")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:classroom:delete')")
    public CommonResult<Boolean> deleteClassroom(@RequestParam("id") Long id) {
        classroomService.deleteClassroom(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得教室")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:classroom:query')")
    public CommonResult<ClassroomRespVO> getClassroom(@RequestParam("id") Long id) {
        ClassroomDO classroom = classroomService.getClassroom(id);
        return success(ClassroomConvert.INSTANCE.convert(classroom));
    }

    @GetMapping("/list")
    @ApiOperation("获得教室列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:classroom:query')")
    public CommonResult<List<ClassroomRespVO>> getClassroomList(@RequestParam("ids") Collection<Long> ids) {
        List<ClassroomDO> list = classroomService.getClassroomList(ids);
        return success(ClassroomConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得教室分页")
    @PreAuthorize("@ss.hasPermission('school:classroom:query')")
    public CommonResult<PageResult<ClassroomRespVO>> getClassroomPage(@Valid ClassroomPageReqVO pageVO) {
        PageResult<ClassroomDO> pageResult = classroomService.getClassroomPage(pageVO);
        return success(ClassroomConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出教室 Excel")
    @PreAuthorize("@ss.hasPermission('school:classroom:export')")
    @OperateLog(type = EXPORT)
    public void exportClassroomExcel(@Valid ClassroomExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ClassroomDO> list = classroomService.getClassroomList(exportReqVO);
        // 导出 Excel
        List<ClassroomExcelVO> datas = ClassroomConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "教室.xls", "数据", ClassroomExcelVO.class, datas);
    }

    @GetMapping("/options")
    @ApiOperation("选项")
    @PreAuthorize("@ss.hasPermission('school:classroom:query')")
    public CommonResult<List<OptionVo>> getClassroomOptions() {
        List<ClassroomDO> list = classroomService.getClassroomOptions();
        return success(ClassroomConvert.INSTANCE.convertOptionList(list));
    }

}
