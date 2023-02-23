package cn.iocoder.yudao.module.school.controller.admin.holiday.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 假期 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class HolidayExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("开始日期")
    private Date beginDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("校区编号")
    private Long campusId;

}
