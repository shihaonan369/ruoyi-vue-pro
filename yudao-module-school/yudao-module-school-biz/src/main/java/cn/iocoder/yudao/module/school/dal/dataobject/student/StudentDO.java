package cn.iocoder.yudao.module.school.dal.dataobject.student;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 学生 DO
 *
 * @author 芋道源码
 */
@TableName("school_student")
@KeySequence("school_student_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 联系人关系
     */
    private String contactRelationship;
    /**
     * 联系热门电话
     */
    private String contactPhone;
    /**
     * 入学时间
     */
    private Date attendanceDate;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 过期时间
     */
    private Date expireDate;
    /**
     * 校区编号
     */
    private Long campusId;

}
