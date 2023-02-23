package cn.iocoder.yudao.module.school.controller.admin.coursefee.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 课程收费分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CourseFeePageReqVO extends PageParam {

    @ApiModelProperty(value = "收费类型")
    private String type;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "课程编号")
    private Long courseId;

}
