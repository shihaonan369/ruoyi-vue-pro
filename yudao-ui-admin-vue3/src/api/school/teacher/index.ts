import { useAxios } from '@/hooks/web/useAxios'
import { TeacherExcelReqVO, TeacherPageReqVO, TeacherVO } from './types'

const request = useAxios()

// 查询教师列表
export const getTeacherPageApi = async (params: TeacherPageReqVO) => {
  return await request.get({ url: '/school/teacher/page', params })
}

// 查询教师详情
export const getTeacherApi = async (id: number) => {
  return await request.get({ url: '/school/teacher/get?id=' + id })
}

// 新增教师
export const createTeacherApi = async (data: TeacherVO) => {
  return await request.post({ url: '/school/teacher/create', data })
}

// 修改教师
export const updateTeacherApi = async (data: TeacherVO) => {
  return await request.put({ url: '/school/teacher/update', data })
}

// 删除教师
export const deleteTeacherApi = async (id: number) => {
  return await request.delete({ url: '/school/teacher/delete?id=' + id })
}

// 导出教师 Excel
export const exportTeacherApi = async (params: TeacherExcelReqVO) => {
  return await request.download({ url: '/school/teacher/export-excel', params })
}

// 查询教师选项
export const getTeacherOptionsApi = async () => {
  return await request.get({ url: '/school/teacher/options' })
}
