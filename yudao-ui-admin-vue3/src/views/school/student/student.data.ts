import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE, getIntDictOptions } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '姓名不能为空', trigger: 'blur' }],
  contactName: [{ required: true, message: '联系人姓名不能为空', trigger: 'blur' }],
  contactRelationship: [{ required: true, message: '联系人关系不能为空', trigger: 'blur' }],
  contactPhone: [{ required: true, message: '联系热门电话不能为空', trigger: 'blur' }],
  attendanceDate: [{ required: true, message: '入学时间不能为空', trigger: 'blur' }],
  status: [{ required: true, message: '状态不能为空', trigger: 'blur' }],
  expireDate: [{ required: true, message: '过期时间不能为空', trigger: 'blur' }],
  campusId: [{ required: true, message: '校区编号不能为空', trigger: 'change' }]
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
    label: '姓名',
    field: 'name',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '生日',
    field: 'birthday',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '联系人姓名',
    field: 'contactName',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '联系人关系',
    field: 'contactRelationship',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '联系热门电话',
    field: 'contactPhone',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '入学时间',
    field: 'attendanceDate',
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
    label: '过期时间',
    field: 'expireDate',
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
    label: '校区编号',
    field: 'campusId',
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
