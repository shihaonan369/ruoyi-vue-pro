package cn.iocoder.yudao.module.school.controller.admin.course.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 课程 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CourseExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("介绍")
    private String introduction;

    @ExcelProperty(value = "教学模式", converter = DictConvert.class)
    @DictFormat("school_teaching_mode") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String teachingMode;

    @ExcelProperty("科目编号")
    private Long subjectId;

}
