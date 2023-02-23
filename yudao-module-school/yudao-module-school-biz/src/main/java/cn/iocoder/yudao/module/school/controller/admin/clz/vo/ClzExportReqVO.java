package cn.iocoder.yudao.module.school.controller.admin.clz.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 班级 Excel 导出 Request VO", description = "参数和 ClzPageReqVO 是一致的")
@Data
public class ClzExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "名称")
    private Integer maxStudents;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "计划开班日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] planOpenDate;

    @ApiModelProperty(value = "开班时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] openDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "课程编号")
    private Long courseId;

    @ApiModelProperty(value = "班主任编号")
    private Long headTeacherId;

}
