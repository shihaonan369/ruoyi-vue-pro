import { reactive } from 'vue'

export const showEditClassDlg = false
export const isAddClass = true
export const showAddTimeTableDlg = false
export const activeNames = reactive(['1', '2', '3'])
export const daysofweek = reactive({
  0: '周日',
  1: '周一',
  2: '周二',
  3: '周三',
  4: '周四',
  5: '周五',
  6: '周六'
})
export const courses = []
export const teachers = reactive([])
export const classrooms = reactive([])
export const timeTableTypes = reactive([])
export const searchClassName = ''
export const checkedStudents = reactive([])
export const students = reactive([])
export const addTimetableInfo: any = reactive({})
export const editClassInfo = reactive({
  id: 0,
  name: '',
  course: null,
  maxstudents: 100,
  headteacher: null,
  status: null,
  planopendate: null,
  opendate: null,
  remark: '',
  activeTab: 'timeTable',
  timeTable: {
    status: 0,
    items: []
  },
  students: {
    items: [],
    others: []
  }
})
