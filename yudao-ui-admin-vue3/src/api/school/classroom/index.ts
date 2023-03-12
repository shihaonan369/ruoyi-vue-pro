import { useAxios } from '@/hooks/web/useAxios'
import { ClassroomExcelReqVO, ClassroomPageReqVO, ClassroomVO } from './types'

const request = useAxios()

// 查询教室列表
export const getClassroomPageApi = async (params: ClassroomPageReqVO) => {
  return await request.get({ url: '/school/classroom/page', params })
}

// 查询教室详情
export const getClassroomApi = async (id: number) => {
  return await request.get({ url: '/school/classroom/get?id=' + id })
}

// 新增教室
export const createClassroomApi = async (data: ClassroomVO) => {
  return await request.post({ url: '/school/classroom/create', data })
}

// 修改教室
export const updateClassroomApi = async (data: ClassroomVO) => {
  return await request.put({ url: '/school/classroom/update', data })
}

// 删除教室
export const deleteClassroomApi = async (id: number) => {
  return await request.delete({ url: '/school/classroom/delete?id=' + id })
}

// 导出教室 Excel
export const exportClassroomApi = async (params: ClassroomExcelReqVO) => {
  return await request.download({ url: '/school/classroom/export-excel', params })
}

// 查询教室选项
export const getClassroomOptionsApi = async () => {
  return await request.get({ url: '/school/classroom/options' })
}
