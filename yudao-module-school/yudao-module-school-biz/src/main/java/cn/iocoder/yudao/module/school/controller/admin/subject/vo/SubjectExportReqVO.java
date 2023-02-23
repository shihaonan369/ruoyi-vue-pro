package cn.iocoder.yudao.module.school.controller.admin.subject.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 科目 Excel 导出 Request VO", description = "参数和 SubjectPageReqVO 是一致的")
@Data
public class SubjectExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否展示")
    private String isShow;

    @ApiModelProperty(value = "校区编号")
    private Long campusId;

}
