package cn.iocoder.yudao.module.school.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode TIMETABLE_NOT_EXISTS = new ErrorCode(2003001000, "课表不存在");
    ErrorCode SUBJECT_NOT_EXISTS = new ErrorCode(2003002000, "科目不存在");
    ErrorCode TEACHER_NOT_EXISTS = new ErrorCode(2003003000, "教室不存在");
    ErrorCode CAMPUS_NOT_EXISTS = new ErrorCode(2003004000, "校区不存在");
    ErrorCode CLASS_NOT_EXISTS = new ErrorCode(2003005000, "班级不存在");
    ErrorCode CLASS_STUDENT_NOT_EXISTS = new ErrorCode(2003006000, "班级学生不存在");
    ErrorCode CLASSROOM_NOT_EXISTS = new ErrorCode(2003007000, "教室不存在");
    ErrorCode COURSE_NOT_EXISTS = new ErrorCode(2003008000, "课程不存在");
    ErrorCode COURSE_FEE_NOT_EXISTS = new ErrorCode(2003009000, "课程收费不存在");
    ErrorCode HOLIDAY_NOT_EXISTS = new ErrorCode(2003010000, "假期不存在");
    ErrorCode STUDENT_NOT_EXISTS = new ErrorCode(2003012000, "学生不存在");
}