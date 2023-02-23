import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE, getIntDictOptions } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  maxStudents: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  status: [{ required: true, message: '状态不能为空', trigger: 'blur' }],
  remark: [{ required: true, message: '备注不能为空', trigger: 'blur' }],
  courseId: [{ required: true, message: '课程编号不能为空', trigger: 'blur' }],
  headTeacherId: [{ required: true, message: '班主任编号不能为空', trigger: 'blur' }]
})
const statusOptions = getIntDictOptions(DICT_TYPE.COMMON_STATUS)
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
    label: '名称',
    field: 'name',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '名称',
    field: 'maxStudents',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '状态',
    field: 'status',
    form: {
      show: true
    },
    search: {
      show: true,
      component: 'Select',
      componentProps: {
        option: statusOptions
      }
    }
  },
  {
    label: '计划开班日期',
    field: 'planOpenDate',
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
    label: '开班时间',
    field: 'openDate',
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
    label: '备注',
    field: 'remark',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '课程编号',
    field: 'courseId',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '班主任编号',
    field: 'headTeacherId',
    form: {
      show: true
    },
    search: {
      show: true
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
