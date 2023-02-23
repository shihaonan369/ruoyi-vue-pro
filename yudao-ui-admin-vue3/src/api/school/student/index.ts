import { useAxios } from '@/hooks/web/useAxios'
import { StudentExcelReqVO, StudentPageReqVO, StudentVO } from './types'

const request = useAxios()

// 查询学生列表
export const getStudentPageApi = async (params: StudentPageReqVO) => {
  return await request.get({ url: '/school/student/page', params })
}

// 查询学生详情
export const getStudentApi = async (id: number) => {
  return await request.get({ url: '/school/student/get?id=' + id })
}

// 新增学生
export const createStudentApi = async (data: StudentVO) => {
  return await request.post({ url: '/school/student/create', data })
}

// 修改学生
export const updateStudentApi = async (data: StudentVO) => {
  return await request.put({ url: '/school/student/update', data })
}

// 删除学生
export const deleteStudentApi = async (id: number) => {
  return await request.delete({ url: '/school/student/delete?id=' + id })
}

// 导出学生 Excel
export const exportStudentApi = async (params: StudentExcelReqVO) => {
  return await request.download({ url: '/school/student/export-excel', params })
}
