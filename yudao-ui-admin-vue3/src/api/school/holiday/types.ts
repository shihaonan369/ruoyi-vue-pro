export type HolidayVO = {
  id: number
  name: string
  beginDate: Date
  endDate: Date
  campusId: number
}

export type HolidayPageReqVO = {
  name: string
  beginDate: Date
  endDate: Date
  campusId: number
}

export type HolidayExcelReqVO = {
  name: string
  beginDate: Date
  endDate: Date
  campusId: number
}
