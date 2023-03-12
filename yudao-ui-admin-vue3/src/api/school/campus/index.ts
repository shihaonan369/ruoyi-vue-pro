import { useAxios } from '@/hooks/web/useAxios'
import { CampusExcelReqVO, CampusPageReqVO, CampusVO } from './types'

const request = useAxios()

// 查询校区列表
export const getCampusPageApi = async (params: CampusPageReqVO) => {
  return await request.get({ url: '/school/campus/page', params })
}

// 查询校区详情
export const getCampusApi = async (id: number) => {
  return await request.get({ url: '/school/campus/get?id=' + id })
}

// 新增校区
export const createCampusApi = async (data: CampusVO) => {
  return await request.post({ url: '/school/campus/create', data })
}

// 修改校区
export const updateCampusApi = async (data: CampusVO) => {
  return await request.put({ url: '/school/campus/update', data })
}

// 删除校区
export const deleteCampusApi = async (id: number) => {
  return await request.delete({ url: '/school/campus/delete?id=' + id })
}

// 导出校区 Excel
export const exportCampusApi = async (params: CampusExcelReqVO) => {
  return await request.download({ url: '/school/campus/export-excel', params })
}

// 查询校区选项
export const getCampusOptionsApi = async () => {
  return await request.get({ url: '/school/campus/options' })
}
