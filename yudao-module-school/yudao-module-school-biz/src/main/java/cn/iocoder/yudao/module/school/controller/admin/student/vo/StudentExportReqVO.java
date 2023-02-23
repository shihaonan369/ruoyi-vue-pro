package cn.iocoder.yudao.module.school.controller.admin.student.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 学生 Excel 导出 Request VO", description = "参数和 StudentPageReqVO 是一致的")
@Data
public class StudentExportReqVO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "入学时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] attendanceDate;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "过期时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] expireDate;

    @ApiModelProperty(value = "校区编号")
    private Long campusId;

}
