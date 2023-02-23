package cn.iocoder.yudao.module.school.controller.admin.coursefee.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 课程收费 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CourseFeeBaseVO {

    @ApiModelProperty(value = "收费类型", required = true)
    @NotNull(message = "收费类型不能为空")
    private String type;

    @ApiModelProperty(value = "课时")
    private Integer classHour;

    @ApiModelProperty(value = "价格")
    private Integer totalPrice;

    @ApiModelProperty(value = "备注", required = true)
    @NotNull(message = "备注不能为空")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private String status;

    @ApiModelProperty(value = "课程编号", required = true)
    @NotNull(message = "课程编号不能为空")
    private Long courseId;

}
