export type StudentVO = {
  id: number
  name: string
  birthday: Date
  contactName: string
  contactRelationship: string
  contactPhone: string
  attendanceDate: Date
  status: string
  expireDate: Date
  campusId: number
}

export type StudentPageReqVO = {
  name: string
  birthday: Date
  attendanceDate: Date
  status: string
  expireDate: Date
  campusId: number
}

export type StudentExcelReqVO = {
  name: string
  birthday: Date
  attendanceDate: Date
  status: string
  expireDate: Date
  campusId: number
}
