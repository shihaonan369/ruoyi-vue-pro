package cn.iocoder.yudao.module.school.controller.admin.classstudent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 班级学生 Excel 导出 Request VO", description = "参数和 ClassStudentPageReqVO 是一致的")
@Data
public class ClassStudentExportReqVO {

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
