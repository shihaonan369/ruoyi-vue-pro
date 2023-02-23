export type ClassStudentVO = {
  id: number
  number: number
  classHour: number
  totalClassHour: number
  enterDate: Date
  classId: number
  studentId: number
}

export type ClassStudentPageReqVO = {
  number: number
  enterDate: Date
  classId: number
  studentId: number
}

export type ClassStudentExcelReqVO = {
  number: number
  enterDate: Date
  classId: number
  studentId: number
}
