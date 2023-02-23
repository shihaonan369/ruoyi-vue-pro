export type SubjectVO = {
  id: number
  name: string
  remark: string
  classHour: number
  isShow: string
  campusId: number
}

export type SubjectPageReqVO = {
  name: string
  isShow: string
  campusId: number
}

export type SubjectExcelReqVO = {
  name: string
  isShow: string
  campusId: number
}
