import { useAxios } from '@/hooks/web/useAxios'
import { CourseExcelReqVO, CoursePageReqVO, CourseVO } from './types'

const request = useAxios()

// 查询课程列表
export const getCoursePageApi = async (params: CoursePageReqVO) => {
  return await request.get({ url: '/school/course/page', params })
}

// 查询课程详情
export const getCourseApi = async (id: number) => {
  return await request.get({ url: '/school/course/get?id=' + id })
}

// 新增课程
export const createCourseApi = async (data: CourseVO) => {
  return await request.post({ url: '/school/course/create', data })
}

// 修改课程
export const updateCourseApi = async (data: CourseVO) => {
  return await request.put({ url: '/school/course/update', data })
}

// 删除课程
export const deleteCourseApi = async (id: number) => {
  return await request.delete({ url: '/school/course/delete?id=' + id })
}

// 导出课程 Excel
export const exportCourseApi = async (params: CourseExcelReqVO) => {
  return await request.download({ url: '/school/course/export-excel', params })
}
