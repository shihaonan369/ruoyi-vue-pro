package cn.iocoder.yudao.module.school.dal.dataobject.clz;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 班级 DO
 *
 * @author 芋道源码
 */
@TableName("school_class")
@KeySequence("school_class_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClzDO extends BaseDO {

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
     * 名称
     */
    private Integer maxStudents;
    /**
     * 状态
     */
    private String status;
    /**
     * 计划开班日期
     */
    private Date planOpenDate;
    /**
     * 开班时间
     */
    private Date openDate;
    /**
     * 备注
     */
    private String remark;
    /**
     * 课程编号
     */
    private Long courseId;
    /**
     * 班主任编号
     */
    private Long headTeacherId;

}
