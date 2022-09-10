-- ----------------------------
-- Table structure for school_campus
-- ----------------------------
DROP TABLE IF EXISTS `school_campus`;
CREATE TABLE `school_campus`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `campus_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '校区类型',
    `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '电话',
    `brand_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '品牌名称', 
    `logoURL` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'logoURL',
    `slogan` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '口号',
    `introduction` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '介绍',
    `location` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '地址',
    `found_date` date NOT NULL COMMENT '建校时间',
    `tenant_id` bigint NOT NULL COMMENT '租户编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_campus_fk_1` FOREIGN KEY (`tenant_id`) REFERENCES `system_tenant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '校区表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_classroom
-- ----------------------------
DROP TABLE IF EXISTS `school_classroom`;
CREATE TABLE `school_classroom`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `campus_id` bigint NOT NULL COMMENT '校区编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_classrrom_fk_1` FOREIGN KEY (`campus_id`) REFERENCES `school_campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_subject
-- ----------------------------
DROP TABLE IF EXISTS `school_subject`;
CREATE TABLE `school_subject`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `class_hour` smallint NULL DEFAULT 0 COMMENT '课时',
    `is_show` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '是否展示',
    `campus_id` bigint NOT NULL COMMENT '校区编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_subject_fk_1` FOREIGN KEY (`campus_id`) REFERENCES `school_campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '科目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_course
-- ----------------------------
DROP TABLE IF EXISTS `school_course`;
CREATE TABLE `school_course`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `introduction` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '介绍',
    `teaching_mode` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1' COMMENT '教学模式',
    `subject_id` bigint NOT NULL COMMENT '科目编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_course_fk_1` FOREIGN KEY (`subject_id`) REFERENCES `school_subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_course_fee
-- ----------------------------
DROP TABLE IF EXISTS `school_course_fee`;
CREATE TABLE `school_course_fee`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '收费类型',
    `class_hour` smallint DEFAULT 0 COMMENT '课时',
    `total_price` int DEFAULT 0 COMMENT '价格',
    `remark` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '状态',
    `course_id` bigint NOT NULL COMMENT '课程编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_course_fee_fk_1` FOREIGN KEY (`course_id`) REFERENCES `school_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程收费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_class
-- ----------------------------
DROP TABLE IF EXISTS `school_class`;
CREATE TABLE `school_class`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `max_students` smallint NOT NULL DEFAULT 0 COMMENT '名称',
    `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '状态',
    `plan_open_date` date NULL COMMENT '计划开班日期',
    `open_date` date NULL COMMENT '开班时间',
    `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `course_id` bigint NOT NULL COMMENT '课程编号',
    `head_teacher_id` bigint NOT NULL COMMENT '班主任编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_class_fk_1` FOREIGN KEY (`course_id`) REFERENCES `school_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_class_fk_2` FOREIGN KEY (`head_teacher_id`) REFERENCES `school_teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_teacher
-- ----------------------------
DROP TABLE IF EXISTS `school_teacher`;
CREATE TABLE `school_teacher`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `user_id` bigint NOT NULL COMMENT '用户编号',
    `campus_id` bigint NOT NULL COMMENT '校区编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_teacher_fk_1` FOREIGN KEY (`user_id`) REFERENCES `system_users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_teacher_fk_2` FOREIGN KEY (`campus_id`) REFERENCES `school_campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_student
-- ----------------------------
DROP TABLE IF EXISTS `school_student`;
CREATE TABLE `school_student`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
    `birthday` date NULL COMMENT '生日',
    `contact_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系人姓名',
    `contact_relationship` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '父母' COMMENT '联系人关系',
    `contact_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系热门电话',
    `attendance_date` date NOT NULL  COMMENT '入学时间',
    `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '状态',
    `expire_date` date NOT NULL COMMENT '过期时间',
    `campus_id` bigint NOT NULL COMMENT '校区编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_student_fk_1` FOREIGN KEY (`campus_id`) REFERENCES `school_campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_class_student
-- ----------------------------
DROP TABLE IF EXISTS `school_class_rollcall`;
CREATE TABLE `school_class_rollcall`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `class_id` bigint NOT NULL COMMENT '班级编号',
    `student_id` bigint NOT NULL COMMENT '学生编号',
    `teacher_id` bigint NOT NULL COMMENT '教师编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_class_rollcall_fk_1` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_class_rollcall_fk_2` FOREIGN KEY (`student_id`) REFERENCES `school_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_class_rollcall_fk_3` FOREIGN KEY (`teacher_id`) REFERENCES `school_teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '点名表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_class_student
-- ----------------------------
DROP TABLE IF EXISTS `school_class_student`;
CREATE TABLE `school_class_student`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `number` bigint NOT NULL DEFAULT 0 COMMENT '学号',
    `class_hour` smallint DEFAULT 0 COMMENT '课时',
    `total_class_hour` smallint DEFAULT 0 COMMENT '总课时',
    `enter_date` date NOT NULL COMMENT '入班日期',
    `class_id` bigint NOT NULL COMMENT '班级编号',
    `student_id` bigint NOT NULL COMMENT '学生编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_class_student_fk_1` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_class_student_fk_2` FOREIGN KEY (`student_id`) REFERENCES `school_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '班级学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_timetable
-- ----------------------------
DROP TABLE IF EXISTS `school_timetable`;
CREATE TABLE `school_timetable`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1' COMMENT '类型',
    `days_weekly` tinyint NOT NULL DEFAULT 0 COMMENT '上课时间',
    `begin_date` date NOT NULL COMMENT '开始日期',
    `end_date` date NOT NULL COMMENT '结束日期',
    `begin_time` date NOT NULL COMMENT '开始时间',
    `end_time` date NOT NULL COMMENT '结束时间',
    `class_id` bigint NOT NULL COMMENT '班级编号',
    `teacher_id` bigint NOT NULL COMMENT '教师编号',
    `classroom_id` bigint NOT NULL COMMENT '教室编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_timetable_fk_1` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_timetable_fk_2` FOREIGN KEY (`teacher_id`) REFERENCES `school_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `school_timetable_fk_3` FOREIGN KEY (`classroom_id`) REFERENCES `school_classroom` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_holiday
-- ----------------------------
DROP TABLE IF EXISTS `school_holiday`;
CREATE TABLE `school_holiday`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(32) NOT NULL DEFAULT '' COMMENT '名称',
    `begin_date` date NOT NULL COMMENT '开始日期',
    `end_date` date NOT NULL COMMENT '结束日期',
    `campus_id` bigint NOT NULL COMMENT '校区编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_holiday_fk_1` FOREIGN KEY (`campus_id`) REFERENCES `school_campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '假期表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_notice
-- ----------------------------
DROP TABLE IF EXISTS `school_notice`;
CREATE TABLE `school_notice`  (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `title` varchar(64) NOT NULL DEFAULT '' COMMENT '标题',
    `summary` varchar(64) NOT NULL DEFAULT '' COMMENT '摘要',
    `detial` varchar(64) NOT NULL DEFAULT '' COMMENT '详情',
    `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1' COMMENT '通知类型',
    `tenant_id` bigint NOT NULL COMMENT '租户编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    CONSTRAINT `school_notice_fk_1` FOREIGN KEY (`tenant_id`) REFERENCES `system_tenant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- 字典
-- ----------------------------
BEGIN;
-- 字典类型
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (201, '校区类型', 'school_campus_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (202, '通知类型', 'school_notice_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (203, '教学模式', 'school_teaching_mode', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (204, '预约方式', 'school_appointment', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (205, '收费方式', 'school_course_fee_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (206, '课表类型', 'school_timetable_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2022-05-16 20:29:32', b'0');

-- 字典数据
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2001, 1, '主校区', '1', 'school_campus_type', 0, 'default', 'A', '主校区', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2002, 2, '直营校区', '2', 'school_campus_type', 0, 'default', 'A', '直营校区', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2003, 3, '加盟校区', '3', 'school_campus_type', 0, 'default', 'A', '加盟校区', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2011, 1, '校内', '1', 'school_notice_type', 0, 'default', 'A', '校内', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2012, 2, '校外', '2', 'school_notice_type', 0, 'default', 'A', '校外', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2021, 1, '一对一', '1', 'school_teaching_mode', 0, 'default', 'A', '一对一', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2022, 2, '一对多', '2', 'school_teaching_mode', 0, 'default', 'A', '一对多', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2031, 1, '不支持', '1', 'school_appointment', 0, 'default', 'A', '不支持', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2032, 2, '支持学员预约', '2', 'school_appointment', 0, 'default', 'A', '支持学员预约', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2033, 3, '支持老师预约', '3', 'school_appointment', 0, 'default', 'A', '支持老师预约', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2041, 1, '按课时', '1', 'school_course_fee_type', 0, 'default', 'A', '按课时', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2042, 2, '按月/年', '2', 'school_course_fee_type', 0, 'default', 'A', '按月/年', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2043, 3, '按期', '3', 'school_course_fee_type', 0, 'default', 'A', '按期', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2044, 4, '按体验课', '4', 'school_course_fee_type', 0, 'default', 'A', '按体验课', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2051, 1, '按周循环', '1', 'school_timetable_type', 0, 'default', 'A', '按周循环', 'admin', '2021-01-05 17:03:48', '1', '2022-03-29 00:14:39', b'0');
COMMIT;

-- ----------------------------
-- 菜单
-- ----------------------------
BEGIN;
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1301, '学校管理', '', 1, 60, 0, '/school', 'ep:school', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1302, '校区', '', 2, 0, 1301, 'campus', 'ep:campus', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1303, '教室', '', 2, 1, 1301, 'classroom', 'ep:classroom', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1304, '科目', '', 2, 2, 1301, 'subject', 'ep:subject', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1305, '课程', '', 2, 3, 1301, 'course', 'ep:course', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1306, '课程收费', '', 2, 4, 1301, 'course_fee', 'ep:course_fee', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1307, '班级', '', 2, 5, 1301, 'class', 'ep:class', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1308, '教室', '', 2, 6, 1301, 'teacher', 'ep:teacher', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1309, '学生', '', 2, 7, 1301, 'student', 'ep:student', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1310, '点名', '', 2, 8, 1301, 'class_rollcall', 'ep:class_rollcall', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1311, '班级学生', '', 2, 9, 1301, 'class_student', 'ep:class_student', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1312, '课程表', '', 2, 10, 1301, 'timetable', 'ep:timetable', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1313, '假期', '', 2, 11, 1301, 'holiday', 'ep:holiday', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `status`, `visible`, `keep_alive`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1314, '通知', '', 2, 12, 1301, 'notice', 'ep:notice', NULL, 0, b'1', b'1', 'admin', '2022-09-03 17:56:22', '1', '2022-09-03 17:56:39', b'0');


COMMIT: