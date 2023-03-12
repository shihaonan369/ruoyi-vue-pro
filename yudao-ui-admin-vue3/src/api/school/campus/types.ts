export type CampusVO = {
  id: number
  name: string
  campusType: string
  phone: string
  brandName: string
  logoUrl: string
  slogan: string
  introduction: string
  location: string
  foundDate: Date
}

export type CampusPageReqVO = {
  name: string
  campusType: string
  location: string
  foundDate: Date
}

export type CampusExcelReqVO = {
  name: string
  campusType: string
  location: string
  foundDate: Date
}
