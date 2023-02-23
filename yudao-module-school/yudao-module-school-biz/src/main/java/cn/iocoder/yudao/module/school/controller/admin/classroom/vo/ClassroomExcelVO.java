package cn.iocoder.yudao.module.school.controller.admin.classroom.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 教室 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ClassroomExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("校区编号")
    private Long campusId;

}
