import { useAxios } from '@/hooks/web/useAxios'
import { HolidayExcelReqVO, HolidayPageReqVO, HolidayVO } from './types'

const request = useAxios()

// 查询假期列表
export const getHolidayPageApi = async (params: HolidayPageReqVO) => {
  return await request.get({ url: '/school/holiday/page', params })
}

// 查询假期详情
export const getHolidayApi = async (id: number) => {
  return await request.get({ url: '/school/holiday/get?id=' + id })
}

// 新增假期
export const createHolidayApi = async (data: HolidayVO) => {
  return await request.post({ url: '/school/holiday/create', data })
}

// 修改假期
export const updateHolidayApi = async (data: HolidayVO) => {
  return await request.put({ url: '/school/holiday/update', data })
}

// 删除假期
export const deleteHolidayApi = async (id: number) => {
  return await request.delete({ url: '/school/holiday/delete?id=' + id })
}

// 导出假期 Excel
export const exportHolidayApi = async (params: HolidayExcelReqVO) => {
  return await request.download({ url: '/school/holiday/export-excel', params })
}

// 查询假期选项
export const getHolidayOptionsApi = async () => {
  return await request.get({ url: '/school/holiday/options' })
}
