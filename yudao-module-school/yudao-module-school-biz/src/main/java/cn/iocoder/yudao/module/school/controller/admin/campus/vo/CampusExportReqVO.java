package cn.iocoder.yudao.module.school.controller.admin.campus.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 校区 Excel 导出 Request VO", description = "参数和 CampusPageReqVO 是一致的")
@Data
public class CampusExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "校区类型")
    private String campusType;

    @ApiModelProperty(value = "地址")
    private String location;

    @ApiModelProperty(value = "建校时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] foundDate;

}
