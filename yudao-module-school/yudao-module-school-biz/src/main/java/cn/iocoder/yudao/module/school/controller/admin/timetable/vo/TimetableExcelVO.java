package cn.iocoder.yudao.module.school.controller.admin.timetable.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 课表 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class TimetableExcelVO {

    @ExcelProperty(value = "类型", converter = DictConvert.class)
    @DictFormat("school_timetable_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String type;

    @ExcelProperty("上课时间")
    private Integer daysWeekly;

    @ExcelProperty("开始日期")
    private Date beginDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("开始时间")
    private Date beginTime;

    @ExcelProperty("结束时间")
    private Date endTime;

    @ExcelProperty("班级编号")
    private Long classId;

    @ExcelProperty("教师编号")
    private Long teacherId;

    @ExcelProperty("教室编号")
    private Long classroomId;

}
