package cn.iocoder.yudao.module.school.controller.admin.clz.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 班级 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ClzExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("名称")
    private Integer maxStudents;

    @ExcelProperty("状态")
    private String status;

    @ExcelProperty("计划开班日期")
    private Date planOpenDate;

    @ExcelProperty("开班时间")
    private Date openDate;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("课程编号")
    private Long courseId;

    @ExcelProperty("班主任编号")
    private Long headTeacherId;

}
