export type TimetableVO = {
  id: number
  type: string
  daysWeekly: number
  beginDate: Date
  endDate: Date
  beginTime: Date
  endTime: Date
  classId: number
  teacherId: number
  classroomId: number
}

export type TimetablePageReqVO = {
  type: string
  beginDate: Date
  endDate: Date
  beginTime: Date
  endTime: Date
  classId: number
  teacherId: number
  classroomId: number
}

export type TimetableExcelReqVO = {
  type: string
  beginDate: Date
  endDate: Date
  beginTime: Date
  endTime: Date
  classId: number
  teacherId: number
  classroomId: number
}
