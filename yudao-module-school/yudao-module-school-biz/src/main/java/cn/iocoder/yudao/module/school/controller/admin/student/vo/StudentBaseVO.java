package cn.iocoder.yudao.module.school.controller.admin.student.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 学生 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StudentBaseVO {

    @ApiModelProperty(value = "学生编号", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "姓名", required = true)
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "生日")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date birthday;

    @ApiModelProperty(value = "联系人姓名", required = true)
    @NotNull(message = "联系人姓名不能为空")
    private String contactName;

    @ApiModelProperty(value = "联系人关系", required = true)
    @NotNull(message = "联系人关系不能为空")
    private String contactRelationship;

    @ApiModelProperty(value = "联系热门电话", required = true)
    @NotNull(message = "联系热门电话不能为空")
    private String contactPhone;

    @ApiModelProperty(value = "入学时间", required = true)
    @NotNull(message = "入学时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date attendanceDate;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "过期时间", required = true)
    @NotNull(message = "过期时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date expireDate;

    @ApiModelProperty(value = "校区编号", required = true)
    @NotNull(message = "校区编号不能为空")
    private Long campusId;

}
