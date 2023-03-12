package cn.iocoder.yudao.module.school.controller.admin.subject.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 科目 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SubjectBaseVO {

    @ApiModelProperty(value = "科目编号", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "备注", required = true)
    @NotNull(message = "备注不能为空")
    private String remark;

    @ApiModelProperty(value = "课时")
    private Integer classHour;

    @ApiModelProperty(value = "是否展示", required = true)
    @NotNull(message = "是否展示不能为空")
    private Integer isShow;

    @ApiModelProperty(value = "校区编号", required = true)
    @NotNull(message = "校区编号不能为空")
    private Long campusId;

}
