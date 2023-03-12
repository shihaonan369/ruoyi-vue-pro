package cn.iocoder.yudao.module.school.controller.admin.teacher.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 教师 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TeacherBaseVO {

    @ApiModelProperty(value = "教师编号", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "用户编号", required = true)
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @ApiModelProperty(value = "校区编号", required = true)
    @NotNull(message = "校区编号不能为空")
    private Long campusId;

}
