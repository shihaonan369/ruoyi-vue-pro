import { useAxios } from '@/hooks/web/useAxios'
import { ClzExcelReqVO, ClzPageReqVO, ClzVO } from './types'

const request = useAxios()

// 查询班级列表
export const getClzPageApi = async (params: ClzPageReqVO) => {
  return await request.get({ url: '/school/clz/page', params })
}

// 查询班级详情
export const getClzApi = async (id: number) => {
  return await request.get({ url: '/school/clz/get?id=' + id })
}

// 新增班级
export const createClzApi = async (data: ClzVO) => {
  return await request.post({ url: '/school/clz/create', data })
}

// 修改班级
export const updateClzApi = async (data: ClzVO) => {
  return await request.put({ url: '/school/clz/update', data })
}

// 删除班级
export const deleteClzApi = async (id: number) => {
  return await request.delete({ url: '/school/clz/delete?id=' + id })
}

// 导出班级 Excel
export const exportClzApi = async (params: ClzExcelReqVO) => {
  return await request.download({ url: '/school/clz/export-excel', params })
}

// 查询班级选项
export const getClzOptionsApi = async () => {
  return await request.get({ url: '/school/clz/options' })
}

// 查询班级列表
export const getClzListApi = async (params: ClzVO) => {
  return await request.get({ url: '/school/clz/list-by-filter', params })
}
