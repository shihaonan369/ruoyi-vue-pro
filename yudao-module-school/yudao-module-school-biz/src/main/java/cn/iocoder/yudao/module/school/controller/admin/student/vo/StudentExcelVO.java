package cn.iocoder.yudao.module.school.controller.admin.student.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 学生 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StudentExcelVO {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("联系人姓名")
    private String contactName;

    @ExcelProperty("联系人关系")
    private String contactRelationship;

    @ExcelProperty("联系热门电话")
    private String contactPhone;

    @ExcelProperty("入学时间")
    private Date attendanceDate;

    @ExcelProperty("状态")
    private String status;

    @ExcelProperty("过期时间")
    private Date expireDate;

    @ExcelProperty("校区编号")
    private Long campusId;

}
