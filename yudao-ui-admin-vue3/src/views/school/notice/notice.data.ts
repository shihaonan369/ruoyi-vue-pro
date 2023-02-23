import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  title: [{ required: true, message: '标题不能为空', trigger: 'blur' }],
  summary: [{ required: true, message: '摘要不能为空', trigger: 'blur' }],
  detial: [{ required: true, message: '详情不能为空', trigger: 'blur' }],
  type: [{ required: true, message: '通知类型不能为空', trigger: 'change' }]
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
    label: '标题',
    field: 'title',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '摘要',
    field: 'summary',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '详情',
    field: 'detial',
    form: {
      show: true
    },
    search: {
      show: true
    }
  },
  {
    label: '通知类型',
    field: 'type',
    dictType: DICT_TYPE.SCHOOL_NOTICE_TYPE,
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
