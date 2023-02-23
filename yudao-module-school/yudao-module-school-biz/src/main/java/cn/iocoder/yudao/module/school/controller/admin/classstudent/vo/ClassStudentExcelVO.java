package cn.iocoder.yudao.module.school.controller.admin.classstudent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 班级学生 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ClassStudentExcelVO {

    @ExcelProperty("学号")
    private Long number;

    @ExcelProperty("课时")
    private Integer classHour;

    @ExcelProperty("总课时")
    private Integer totalClassHour;

    @ExcelProperty("入班日期")
    private Date enterDate;

    @ExcelProperty("班级编号")
    private Long classId;

    @ExcelProperty("学生编号")
    private Long studentId;

}
