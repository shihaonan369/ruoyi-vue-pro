package cn.iocoder.yudao.module.school.controller.admin.campus.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 校区 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CampusExcelVO {

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty(value = "校区类型", converter = DictConvert.class)
    @DictFormat("school_campus_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String campusType;

    @ExcelProperty("电话")
    private String phone;

    @ExcelProperty("品牌名称")
    private String brandName;

    @ExcelProperty("logoUrl")
    private String logoUrl;

    @ExcelProperty("口号")
    private String slogan;

    @ExcelProperty("介绍")
    private String introduction;

    @ExcelProperty("地址")
    private String location;

    @ExcelProperty("建校时间")
    private Date foundDate;

}
