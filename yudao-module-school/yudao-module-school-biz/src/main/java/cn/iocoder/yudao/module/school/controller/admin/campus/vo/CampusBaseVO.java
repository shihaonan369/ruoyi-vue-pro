package cn.iocoder.yudao.module.school.controller.admin.campus.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 校区 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CampusBaseVO {

    @ApiModelProperty(value = "名称", required = true)
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "校区类型", required = true)
    @NotNull(message = "校区类型不能为空")
    private String campusType;

    @ApiModelProperty(value = "电话", required = true)
    @NotNull(message = "电话不能为空")
    private String phone;

    @ApiModelProperty(value = "品牌名称", required = true)
    @NotNull(message = "品牌名称不能为空")
    private String brandName;

    @ApiModelProperty(value = "logoURL", required = true)
    @NotNull(message = "logoURL不能为空")
    private String logoURL;

    @ApiModelProperty(value = "口号", required = true)
    @NotNull(message = "口号不能为空")
    private String slogan;

    @ApiModelProperty(value = "介绍", required = true)
    @NotNull(message = "介绍不能为空")
    private String introduction;

    @ApiModelProperty(value = "地址", required = true)
    @NotNull(message = "地址不能为空")
    private String location;

    @ApiModelProperty(value = "建校时间", required = true)
    @NotNull(message = "建校时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date foundDate;

}
