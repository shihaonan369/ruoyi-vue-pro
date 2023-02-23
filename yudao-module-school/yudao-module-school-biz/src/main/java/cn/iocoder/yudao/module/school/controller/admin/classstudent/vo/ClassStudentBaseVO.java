package cn.iocoder.yudao.module.school.controller.admin.classstudent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 班级学生 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ClassStudentBaseVO {

    @ApiModelProperty(value = "学号", required = true)
    @NotNull(message = "学号不能为空")
    private Long number;

    @ApiModelProperty(value = "课时")
    private Integer classHour;

    @ApiModelProperty(value = "总课时")
    private Integer totalClassHour;

    @ApiModelProperty(value = "入班日期", required = true)
    @NotNull(message = "入班日期不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date enterDate;

    @ApiModelProperty(value = "班级编号", required = true)
    @NotNull(message = "班级编号不能为空")
    private Long classId;

    @ApiModelProperty(value = "学生编号", required = true)
    @NotNull(message = "学生编号不能为空")
    private Long studentId;

}
