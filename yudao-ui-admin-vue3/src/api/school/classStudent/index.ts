import { useAxios } from '@/hooks/web/useAxios'
import { ClassStudentExcelReqVO, ClassStudentPageReqVO, ClassStudentVO } from './types'

const request = useAxios()

// 查询班级学生列表
export const getClassStudentPageApi = async (params: ClassStudentPageReqVO) => {
  return await request.get({ url: '/school/class-student/page', params })
}

// 查询班级学生详情
export const getClassStudentApi = async (id: number) => {
  return await request.get({ url: '/school/class-student/get?id=' + id })
}

// 新增班级学生
export const createClassStudentApi = async (data: ClassStudentVO) => {
  return await request.post({ url: '/school/class-student/create', data })
}

// 修改班级学生
export const updateClassStudentApi = async (data: ClassStudentVO) => {
  return await request.put({ url: '/school/class-student/update', data })
}

// 删除班级学生
export const deleteClassStudentApi = async (id: number) => {
  return await request.delete({ url: '/school/class-student/delete?id=' + id })
}

// 导出班级学生 Excel
export const exportClassStudentApi = async (params: ClassStudentExcelReqVO) => {
  return await request.download({ url: '/school/class-student/export-excel', params })
}
