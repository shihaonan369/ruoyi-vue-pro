package cn.iocoder.yudao.module.school.controller.admin.course.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 课程 Excel 导出 Request VO", description = "参数和 CoursePageReqVO 是一致的")
@Data
public class CourseExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "教学模式")
    private String teachingMode;

    @ApiModelProperty(value = "科目编号")
    private Long subjectId;

}
