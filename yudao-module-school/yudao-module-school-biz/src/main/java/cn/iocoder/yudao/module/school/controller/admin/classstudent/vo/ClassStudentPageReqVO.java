package cn.iocoder.yudao.module.school.controller.admin.classstudent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 班级学生分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClassStudentPageReqVO extends PageParam {

    @ApiModelProperty(value = "学号")
    private Long number;

    @ApiModelProperty(value = "入班日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] enterDate;

    @ApiModelProperty(value = "班级编号")
    private Long classId;

    @ApiModelProperty(value = "学生编号")
    private Long studentId;

}
