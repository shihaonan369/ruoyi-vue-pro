import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  remark: [{ required: true, message: '备注不能为空', trigger: 'blur' }],
  isShow: [{ required: true, message: '是否展示不能为空', trigger: 'change' }],
  campusId: [{ required: true, message: '校区编号不能为空', trigger: 'change' }]
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
    label: '是否展示',
    field: 'isShow',
    dictType: DICT_TYPE.INFRA_BOOLEAN_STRING,
    search: {
      show: true
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
