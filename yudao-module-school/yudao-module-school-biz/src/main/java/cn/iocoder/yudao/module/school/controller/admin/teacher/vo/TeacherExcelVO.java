package cn.iocoder.yudao.module.school.controller.admin.teacher.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 教师 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class TeacherExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("用户编号")
    private Long userId;

    @ExcelProperty("校区编号")
    private Long campusId;

}
