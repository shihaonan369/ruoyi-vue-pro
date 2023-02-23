import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  type: [{ required: true, message: '类型不能为空', trigger: 'change' }],
  daysWeekly: [{ required: true, message: '上课时间不能为空', trigger: 'blur' }],
  beginDate: [{ required: true, message: '开始日期不能为空', trigger: 'blur' }],
  endDate: [{ required: true, message: '结束日期不能为空', trigger: 'blur' }],
  beginTime: [{ required: true, message: '开始时间不能为空', trigger: 'blur' }],
  endTime: [{ required: true, message: '结束时间不能为空', trigger: 'blur' }],
  classId: [{ required: true, message: '班级编号不能为空', trigger: 'change' }],
  teacherId: [{ required: true, message: '教师编号不能为空', trigger: 'change' }],
  classroomId: [{ required: true, message: '教室编号不能为空', trigger: 'change' }]
})
// CrudSchema
const crudSchemas = reactive<CrudSchema[]>([
  {
    label: '编号',
    field: 'id',
    type: 'index',
    form: {
      show: false
    },
    detail: {
      show: false
    }
  },
  {
    label: '类型',
    field: 'type',
    dictType: DICT_TYPE.SCHOOL_TIMETABLE_TYPE,
    search: {
      show: true
    }
  },
  {
    label: '上课时间',
    field: 'daysWeekly',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '开始日期',
    field: 'beginDate',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    },
    search: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetimerange',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    }
  },
  {
    label: '结束日期',
    field: 'endDate',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    },
    search: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetimerange',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    }
  },
  {
    label: '开始时间',
    field: 'beginTime',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    },
    search: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetimerange',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    }
  },
  {
    label: '结束时间',
    field: 'endTime',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    },
    search: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetimerange',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    }
  },
  {
    label: '班级编号',
    field: 'classId',
    form: {
      show: true
    },
    search: {
      show: false
    }
  },
  {
    label: '教师编号',
    field: 'teacherId',
    form: {
      show: true
    },
    search: {
      show: false
    }
  },
  {
    label: '教室编号',
    field: 'classroomId',
    form: {
      show: true
    },
    search: {
      show: false
    }
  },
  {
    label: t('table.action'),
    field: 'action',
    width: '240px',
    form: {
      show: false
    },
    detail: {
      show: false
    }
  }
])

export const { allSchemas } = useCrudSchemas(crudSchemas)
