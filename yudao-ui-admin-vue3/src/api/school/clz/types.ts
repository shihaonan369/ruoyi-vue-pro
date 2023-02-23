export type ClzVO = {
  id: number
  name: string
  maxStudents: number
  status: string
  planOpenDate: Date
  openDate: Date
  remark: string
  courseId: number
  headTeacherId: number
}

export type ClzPageReqVO = {
  name: string
  maxStudents: number
  status: string
  planOpenDate: Date
  openDate: Date
  remark: string
  courseId: number
  headTeacherId: number
}

export type ClzExcelReqVO = {
  name: string
  maxStudents: number
  status: string
  planOpenDate: Date
  openDate: Date
  remark: string
  courseId: number
  headTeacherId: number
}
