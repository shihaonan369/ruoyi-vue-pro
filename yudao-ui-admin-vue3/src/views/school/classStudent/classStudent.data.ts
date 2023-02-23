import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  number: [{ required: true, message: '学号不能为空', trigger: 'blur' }],
  enterDate: [{ required: true, message: '入班日期不能为空', trigger: 'blur' }],
  classId: [{ required: true, message: '班级编号不能为空', trigger: 'change' }],
  studentId: [{ required: true, message: '学生编号不能为空', trigger: 'change' }]
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
    label: '学号',
    field: 'number',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '课时',
    field: 'classHour',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '总课时',
    field: 'totalClassHour',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '入班日期',
    field: 'enterDate',
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
    label: '学生编号',
    field: 'studentId',
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
