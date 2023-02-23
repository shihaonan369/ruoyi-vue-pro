package cn.iocoder.yudao.module.school.dal.dataobject.classstudent;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 班级学生 DO
 *
 * @author 芋道源码
 */
@TableName("school_class_student")
@KeySequence("school_class_student_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassStudentDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 学号
     */
    private Long number;
    /**
     * 课时
     */
    private Integer classHour;
    /**
     * 总课时
     */
    private Integer totalClassHour;
    /**
     * 入班日期
     */
    private Date enterDate;
    /**
     * 班级编号
     */
    private Long classId;
    /**
     * 学生编号
     */
    private Long studentId;

}
