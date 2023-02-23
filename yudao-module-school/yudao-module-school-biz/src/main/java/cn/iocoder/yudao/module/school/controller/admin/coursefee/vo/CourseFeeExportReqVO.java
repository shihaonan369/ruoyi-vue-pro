package cn.iocoder.yudao.module.school.controller.admin.coursefee.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 课程收费 Excel 导出 Request VO", description = "参数和 CourseFeePageReqVO 是一致的")
@Data
public class CourseFeeExportReqVO {

    @ApiModelProperty(value = "收费类型")
    private String type;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "课程编号")
    private Long courseId;

}
