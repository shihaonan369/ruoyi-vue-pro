import { useAxios } from '@/hooks/web/useAxios'
import { TimetableExcelReqVO, TimetablePageReqVO, TimetableVO } from './types'

const request = useAxios()

// 查询课程列表
export const getTimetablePageApi = async (params: TimetablePageReqVO) => {
  return await request.get({ url: '/school/timetable/page', params })
}

// 查询课程详情
export const getTimetableApi = async (id: number) => {
  return await request.get({ url: '/school/timetable/get?id=' + id })
}

// 新增课程
export const createTimetableApi = async (data: TimetableVO) => {
  return await request.post({ url: '/school/timetable/create', data })
}

// 修改课程
export const updateTimetableApi = async (data: TimetableVO) => {
  return await request.put({ url: '/school/timetable/update', data })
}

// 删除课程
export const deleteTimetableApi = async (id: number) => {
  return await request.delete({ url: '/school/timetable/delete?id=' + id })
}

// 导出课程 Excel
export const exportTimetableApi = async (params: TimetableExcelReqVO) => {
  return await request.download({ url: '/school/timetable/export-excel', params })
}

// 查询课表列表
export const getTimetableListApi = async (params: TimetableVO) => {
  return await request.get({ url: '/school/timetable/list-by-filter', params })
}
