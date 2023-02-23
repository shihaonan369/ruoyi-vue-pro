package cn.iocoder.yudao.module.school.controller.admin.coursefee.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 课程收费 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CourseFeeExcelVO {

    @ExcelProperty(value = "收费类型", converter = DictConvert.class)
    @DictFormat("school_course_fee_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String type;

    @ExcelProperty("课时")
    private Integer classHour;

    @ExcelProperty("价格")
    private Integer totalPrice;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("状态")
    private String status;

    @ExcelProperty("课程编号")
    private Long courseId;

}
