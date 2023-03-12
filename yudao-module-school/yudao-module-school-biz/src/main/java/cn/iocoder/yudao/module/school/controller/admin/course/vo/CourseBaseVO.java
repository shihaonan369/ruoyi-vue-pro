package cn.iocoder.yudao.module.school.controller.admin.course.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 课程 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CourseBaseVO {

    @ApiModelProperty(value = "课程编号", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "介绍", required = true)
    @NotNull(message = "介绍不能为空")
    private String introduction;

    @ApiModelProperty(value = "教学模式", required = true)
    @NotNull(message = "教学模式不能为空")
    private Integer teachingMode;

    @ApiModelProperty(value = "科目编号", required = true)
    @NotNull(message = "科目编号不能为空")
    private Long subjectId;

}
