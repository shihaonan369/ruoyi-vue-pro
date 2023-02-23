package cn.iocoder.yudao.module.school.dal.dataobject.coursefee;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 课程收费 DO
 *
 * @author 芋道源码
 */
@TableName("school_course_fee")
@KeySequence("school_course_fee_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseFeeDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 收费类型
     *
     * 枚举 {@link TODO school_course_fee_type 对应的类}
     */
    private String type;
    /**
     * 课时
     */
    private Integer classHour;
    /**
     * 价格
     */
    private Integer totalPrice;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private String status;
    /**
     * 课程编号
     */
    private Long courseId;

}
