import { useAxios } from '@/hooks/web/useAxios'
import { SubjectExcelReqVO, SubjectPageReqVO, SubjectVO } from './types'

const request = useAxios()

// 查询科目列表
export const getSubjectPageApi = async (params: SubjectPageReqVO) => {
  return await request.get({ url: '/school/subject/page', params })
}

// 查询科目详情
export const getSubjectApi = async (id: number) => {
  return await request.get({ url: '/school/subject/get?id=' + id })
}

// 新增科目
export const createSubjectApi = async (data: SubjectVO) => {
  return await request.post({ url: '/school/subject/create', data })
}

// 修改科目
export const updateSubjectApi = async (data: SubjectVO) => {
  return await request.put({ url: '/school/subject/update', data })
}

// 删除科目
export const deleteSubjectApi = async (id: number) => {
  return await request.delete({ url: '/school/subject/delete?id=' + id })
}

// 导出科目 Excel
export const exportSubjectApi = async (params: SubjectExcelReqVO) => {
  return await request.download({ url: '/school/subject/export-excel', params })
}

// 查询科目选项
export const getSubjectOptionsApi = async () => {
  return await request.get({ url: '/school/subject/options' })
}
