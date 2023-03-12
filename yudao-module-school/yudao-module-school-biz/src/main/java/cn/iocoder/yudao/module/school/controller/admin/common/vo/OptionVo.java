package cn.iocoder.yudao.module.school.controller.admin.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mapstruct.Mapping;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 选项 Response VO")
@Data
public class OptionVo {
    @ApiModelProperty(value = "Id", required = true)
    @NotNull(message = "Id不能为空")
    private Object id;

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String label;
}
