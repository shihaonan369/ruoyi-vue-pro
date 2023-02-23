package cn.iocoder.yudao.module.school.controller.admin.subject.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 科目 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SubjectExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("课时")
    private Integer classHour;

    @ExcelProperty(value = "是否展示", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String isShow;

    @ExcelProperty("校区编号")
    private Long campusId;

}
