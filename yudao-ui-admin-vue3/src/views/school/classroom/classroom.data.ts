import { getCampusOptionsApi } from '@/api/school/campus'
import { OptionVO } from '@/api/school/common/types'
import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { useI18n } from '@/hooks/web/useI18n'
import { reactive } from 'vue'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  name: [{ required: true, message: '名称不能为空', trigger: 'blur' }],
  campusId: [{ required: true, message: '校区编号不能为空', trigger: 'change' }]
})
export const campusOptions: OptionVO[] = await getCampusOptionsApi()
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
    label: '校区编号',
    field: 'campusId',
    form: {
      show: true,
      component: 'Select',
      componentProps: {
        options: campusOptions,
        optionsAlias: {
          valueField: 'id'
        }
      }
    },
    detail: {
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
