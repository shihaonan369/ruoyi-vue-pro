package cn.iocoder.yudao.module.school.dal.dataobject.subject;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 科目 DO
 *
 * @author 芋道源码
 */
@TableName("school_subject")
@KeySequence("school_subject_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDO extends BaseDO {

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
     * 备注
     */
    private String remark;
    /**
     * 课时
     */
    private Integer classHour;
    /**
     * 是否展示
     */
    private Integer isShow;
    /**
     * 校区编号
     */
    private Long campusId;

}
