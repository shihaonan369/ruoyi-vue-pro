import { useAxios } from '@/hooks/web/useAxios'
import { TeacherExcelReqVO, TeacherPageReqVO, TeacherVO } from './types'

const request = useAxios()

// 查询教室列表
export const getTeacherPageApi = async (params: TeacherPageReqVO) => {
  return await request.get({ url: '/school/teacher/page', params })
}

// 查询教室详情
export const getTeacherApi = async (id: number) => {
  return await request.get({ url: '/school/teacher/get?id=' + id })
}

// 新增教室
export const createTeacherApi = async (data: TeacherVO) => {
  return await request.post({ url: '/school/teacher/create', data })
}

// 修改教室
export const updateTeacherApi = async (data: TeacherVO) => {
  return await request.put({ url: '/school/teacher/update', data })
}

// 删除教室
export const deleteTeacherApi = async (id: number) => {
  return await request.delete({ url: '/school/teacher/delete?id=' + id })
}

// 导出教室 Excel
export const exportTeacherApi = async (params: TeacherExcelReqVO) => {
  return await request.download({ url: '/school/teacher/export-excel', params })
}
