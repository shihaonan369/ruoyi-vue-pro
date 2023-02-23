package cn.iocoder.yudao.module.school.controller.admin.timetable.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 课程 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TimetableBaseVO {

    @ApiModelProperty(value = "类型", required = true)
    @NotNull(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "上课时间", required = true)
    @NotNull(message = "上课时间不能为空")
    private Integer daysWeekly;

    @ApiModelProperty(value = "开始日期", required = true)
    @NotNull(message = "开始日期不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date beginDate;

    @ApiModelProperty(value = "结束日期", required = true)
    @NotNull(message = "结束日期不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date endDate;

    @ApiModelProperty(value = "开始时间", required = true)
    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date beginTime;

    @ApiModelProperty(value = "结束时间", required = true)
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date endTime;

    @ApiModelProperty(value = "班级编号", required = true)
    @NotNull(message = "班级编号不能为空")
    private Long classId;

    @ApiModelProperty(value = "教师编号", required = true)
    @NotNull(message = "教师编号不能为空")
    private Long teacherId;

    @ApiModelProperty(value = "教室编号", required = true)
    @NotNull(message = "教室编号不能为空")
    private Long classroomId;

}
