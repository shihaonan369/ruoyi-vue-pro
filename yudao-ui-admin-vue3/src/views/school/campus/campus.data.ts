import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  campusType: [{ required: true, message: '校区类型不能为空', trigger: 'change' }],
  phone: [{ required: true, message: '电话不能为空', trigger: 'blur' }],
  brandName: [{ required: true, message: '品牌名称不能为空', trigger: 'blur' }],
  logoURL: [{ required: true, message: 'logoURL不能为空', trigger: 'blur' }],
  slogan: [{ required: true, message: '口号不能为空', trigger: 'blur' }],
  introduction: [{ required: true, message: '介绍不能为空', trigger: 'blur' }],
  location: [{ required: true, message: '地址不能为空', trigger: 'blur' }],
  foundDate: [{ required: true, message: '建校时间不能为空', trigger: 'blur' }]
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
    label: '校区类型',
    field: 'campusType',
    dictType: DICT_TYPE.SCHOOL_CAMPUS_TYPE,
    search: {
      show: true
    }
  },
  {
    label: '电话',
    field: 'phone',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '品牌名称',
    field: 'brandName',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: 'logoURL',
    field: 'logoURL',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '口号',
    field: 'slogan',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '介绍',
    field: 'introduction',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '地址',
    field: 'location',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '建校时间',
    field: 'foundDate',
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
