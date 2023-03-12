package cn.iocoder.yudao.module.school.dal.dataobject.campus;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 校区 DO
 *
 * @author 芋道源码
 */
@TableName("school_campus")
@KeySequence("school_campus_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampusDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 校区类型
     */
    private Integer campusType;
    /**
     * 电话
     */
    private String phone;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * logoUrl
     */
    private String logoUrl;
    /**
     * 口号
     */
    private String slogan;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 地址
     */
    private String location;
    /**
     * 建校时间
     */
    private Date foundDate;

}
