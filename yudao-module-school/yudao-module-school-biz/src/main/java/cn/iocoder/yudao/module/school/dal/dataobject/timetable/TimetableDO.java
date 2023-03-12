package cn.iocoder.yudao.module.school.dal.dataobject.timetable;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 课程 DO
 *
 * @author 芋道源码
 */
@TableName("school_timetable")
@KeySequence("school_timetable_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimetableDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 上课时间
     */
    private Integer daysWeekly;
    /**
     * 开始日期
     */
    private Date beginDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 班级编号
     */
    private Long classId;
    /**
     * 教师编号
     */
    private Long teacherId;
    /**
     * 教室编号
     */
    private Long classroomId;

}
