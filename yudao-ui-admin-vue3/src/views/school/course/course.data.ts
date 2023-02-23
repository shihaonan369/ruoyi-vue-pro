import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { DICT_TYPE } from '@/utils/dict'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  introduction: [{ required: true, message: '介绍不能为空', trigger: 'blur' }],
  teachingMode: [{ required: true, message: '教学模式不能为空', trigger: 'change' }],
  subjectId: [{ required: true, message: '科目编号不能为空', trigger: 'change' }]
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
    label: '教学模式',
    field: 'teachingMode',
    dictType: DICT_TYPE.SCHOOL_TEACHING_MODE,
    search: {
      show: true
    }
  },
  {
    label: '科目编号',
    field: 'subjectId',
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
