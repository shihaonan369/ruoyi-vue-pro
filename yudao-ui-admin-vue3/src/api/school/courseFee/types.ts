export type CourseFeeVO = {
  id: number
  type: string
  classHour: number
  totalPrice: number
  remark: string
  status: string
  courseId: number
}

export type CourseFeePageReqVO = {
  type: string
  status: string
  courseId: number
}

export type CourseFeeExcelReqVO = {
  type: string
  status: string
  courseId: number
}
