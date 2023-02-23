import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  type: [{ required: true, message: '收费类型不能为空', trigger: 'change' }],
  remark: [{ required: true, message: '备注不能为空', trigger: 'blur' }],
  status: [{ required: true, message: '状态不能为空', trigger: 'blur' }],
  courseId: [{ required: true, message: '课程编号不能为空', trigger: 'change' }]
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
    label: '收费类型',
    field: 'type',
    dictType: DICT_TYPE.SCHOOL_COURSE_FEE_TYPE,
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
    label: '价格',
    field: 'totalPrice',
    form: {
      show: true
    },
    search: {
      show: true
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
    label: '状态',
    field: 'status',
    form: {
      show: true
    },
    search: {
      show: false
    }
  },
  {
    label: '课程编号',
    field: 'courseId',
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
