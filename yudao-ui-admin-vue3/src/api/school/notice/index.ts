import { useAxios } from '@/hooks/web/useAxios'
import { NoticeExcelReqVO, NoticePageReqVO, NoticeVO } from './types'

const request = useAxios()

// 查询通知列表
export const getNoticePageApi = async (params: NoticePageReqVO) => {
  return await request.get({ url: '/school/notice/page', params })
}

// 查询通知详情
export const getNoticeApi = async (id: number) => {
  return await request.get({ url: '/school/notice/get?id=' + id })
}

// 新增通知
export const createNoticeApi = async (data: NoticeVO) => {
  return await request.post({ url: '/school/notice/create', data })
}

// 修改通知
export const updateNoticeApi = async (data: NoticeVO) => {
  return await request.put({ url: '/school/notice/update', data })
}

// 删除通知
export const deleteNoticeApi = async (id: number) => {
  return await request.delete({ url: '/school/notice/delete?id=' + id })
}

// 导出通知 Excel
export const exportNoticeApi = async (params: NoticeExcelReqVO) => {
  return await request.download({ url: '/school/notice/export-excel', params })
}
