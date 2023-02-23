package cn.iocoder.yudao.module.school.controller.admin.teacher.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 教室 Excel 导出 Request VO", description = "参数和 TeacherPageReqVO 是一致的")
@Data
public class TeacherExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "校区编号")
    private Long campusId;

}
