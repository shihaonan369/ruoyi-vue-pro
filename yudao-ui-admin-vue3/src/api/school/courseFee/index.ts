import { useAxios } from '@/hooks/web/useAxios'
import { CourseFeeExcelReqVO, CourseFeePageReqVO, CourseFeeVO } from './types'

const request = useAxios()

// 查询课程收费列表
export const getCourseFeePageApi = async (params: CourseFeePageReqVO) => {
  return await request.get({ url: '/school/course-fee/page', params })
}

// 查询课程收费详情
export const getCourseFeeApi = async (id: number) => {
  return await request.get({ url: '/school/course-fee/get?id=' + id })
}

// 新增课程收费
export const createCourseFeeApi = async (data: CourseFeeVO) => {
  return await request.post({ url: '/school/course-fee/create', data })
}

// 修改课程收费
export const updateCourseFeeApi = async (data: CourseFeeVO) => {
  return await request.put({ url: '/school/course-fee/update', data })
}

// 删除课程收费
export const deleteCourseFeeApi = async (id: number) => {
  return await request.delete({ url: '/school/course-fee/delete?id=' + id })
}

// 导出课程收费 Excel
export const exportCourseFeeApi = async (params: CourseFeeExcelReqVO) => {
  return await request.download({ url: '/school/course-fee/export-excel', params })
}
