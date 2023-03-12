package cn.iocoder.yudao.module.school.controller.admin.subject;

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

import cn.iocoder.yudao.module.school.controller.admin.subject.vo.*;
import cn.iocoder.yudao.module.school.dal.dataobject.subject.SubjectDO;
import cn.iocoder.yudao.module.school.convert.subject.SubjectConvert;
import cn.iocoder.yudao.module.school.service.subject.SubjectService;

@Api(tags = "管理后台 - 科目")
@RestController
@RequestMapping("/school/subject")
@Validated
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @PostMapping("/create")
    @ApiOperation("创建科目")
    @PreAuthorize("@ss.hasPermission('school:subject:create')")
    public CommonResult<Long> createSubject(@Valid @RequestBody SubjectCreateReqVO createReqVO) {
        return success(subjectService.createSubject(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新科目")
    @PreAuthorize("@ss.hasPermission('school:subject:update')")
    public CommonResult<Boolean> updateSubject(@Valid @RequestBody SubjectUpdateReqVO updateReqVO) {
        subjectService.updateSubject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除科目")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:subject:delete')")
    public CommonResult<Boolean> deleteSubject(@RequestParam("id") Long id) {
        subjectService.deleteSubject(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得科目")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('school:subject:query')")
    public CommonResult<SubjectRespVO> getSubject(@RequestParam("id") Long id) {
        SubjectDO subject = subjectService.getSubject(id);
        return success(SubjectConvert.INSTANCE.convert(subject));
    }

    @GetMapping("/list")
    @ApiOperation("获得科目列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('school:subject:query')")
    public CommonResult<List<SubjectRespVO>> getSubjectList(@RequestParam("ids") Collection<Long> ids) {
        List<SubjectDO> list = subjectService.getSubjectList(ids);
        return success(SubjectConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得科目分页")
    @PreAuthorize("@ss.hasPermission('school:subject:query')")
    public CommonResult<PageResult<SubjectRespVO>> getSubjectPage(@Valid SubjectPageReqVO pageVO) {
        PageResult<SubjectDO> pageResult = subjectService.getSubjectPage(pageVO);
        return success(SubjectConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出科目 Excel")
    @PreAuthorize("@ss.hasPermission('school:subject:export')")
    @OperateLog(type = EXPORT)
    public void exportSubjectExcel(@Valid SubjectExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SubjectDO> list = subjectService.getSubjectList(exportReqVO);
        // 导出 Excel
        List<SubjectExcelVO> datas = SubjectConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "科目.xls", "数据", SubjectExcelVO.class, datas);
    }

    @GetMapping("/options")
    @ApiOperation("选项")
    @PreAuthorize("@ss.hasPermission('school:subject:query')")
    public CommonResult<List<OptionVo>> getSubjectOptions() {
        List<SubjectDO> list = subjectService.getSubjectOptions();
        return success(SubjectConvert.INSTANCE.convertOptionList(list));
    }
}
