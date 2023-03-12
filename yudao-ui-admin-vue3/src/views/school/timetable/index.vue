<script setup lang="ts">
import { getClassroomOptionsApi } from '@/api/school/classroom'
import { getClassStudentListApi } from '@/api/school/classStudent'
import { createClzApi, deleteClzApi, getClzListApi, updateClzApi } from '@/api/school/clz'
import { ClzVO } from '@/api/school/clz/types'
import { OptionVO } from '@/api/school/common/types'
import { getCourseOptionsApi } from '@/api/school/course'
import { getStudentOptionsApi } from '@/api/school/student'
import { getTeacherOptionsApi } from '@/api/school/teacher'
import { createTimetableApi, deleteTimetableApi, getTimetableListApi } from '@/api/school/timetable'
import { TimetableVO } from '@/api/school/timetable/types'
import { ContentWrap } from '@/components/ContentWrap'
import { formatTime } from '@/utils'
import { DictDataType, DICT_TYPE, getDictOptions } from '@/utils/dict'
import { nextTick, onMounted, reactive, ref } from 'vue'
import { addTimetableInfo, daysofweek } from './timetable.data'

let courseOptions: OptionVO[] = reactive([])
let teacherOptions: OptionVO[] = reactive([])
let studentOptions: OptionVO[] = reactive([])
let classroomOptions: OptionVO[] = reactive([])
let timeTableTypeOptions: DictDataType[] = reactive([])
let classesInfo: ClzVO[] = reactive([])
const editClassInfo: any = reactive({
  timeTable: {
    items: []
  },
  students: {
    items: []
  }
})
const isAddClass = ref(false)
const showEditClassDlg = ref(false)
const showAddTimeTableDlg = ref(false)
const addTimeTableForm = ref()
const addClassForm = ref()

const listClassTimeTables = async (classId) => {
  let classTimeTables = await getTimetableListApi({
    classId: classId
  })
  classTimeTables.forEach((classTimeTable) => {
    editClassInfo.timeTable.items.push(
      Object.assign(
        {},
        {
          id: classTimeTable.id,
          type: classTimeTable.type,
          classDate: [
            formatTime(classTimeTable.beginDate, 'yyyy-MM-dd hh:mm:ss'),
            formatTime(classTimeTable.endDate, 'yyyy-MM-dd hh:mm:ss')
          ],
          classTime: [
            formatTime(classTimeTable.beginTime, 'yyyy-MM-dd hh:mm:ss'),
            formatTime(classTimeTable.endTime, 'yyyy-MM-dd hh:mm:ss')
          ],
          teacher: classTimeTable.teacherId,
          classroom: classTimeTable.classroomId,
          status: 1
        }
      )
    )
  })
}

const listClassStudents = async (classId) => {
  let students = await getClassStudentListApi({
    classId: classId
  })
  editClassInfo.students.items.splice(0, editClassInfo.students.items.length)
  students.forEach((student) => {
    editClassInfo.students.items.push({
      id: student.id,
      number: student.number,
      name: student.studentId,
      enterdate: student.enterDate
    })
  })
}

const onModifyClass = (index) => {
  editClassInfo.id = classesInfo[index].id
  editClassInfo.name = classesInfo[index].name
  editClassInfo.course = classesInfo[index].course
  editClassInfo.maxstudents = classesInfo[index].maxStudents
  editClassInfo.headteacher = classesInfo[index].headTeacherId
  editClassInfo.status = classesInfo[index].status
  editClassInfo.planopendate = classesInfo[index].planOpenDate
  editClassInfo.opendate = classesInfo[index].openDate
  editClassInfo.remark = classesInfo[index].remark
  listClassTimeTables(classesInfo[index].id)
  listClassStudents(classesInfo[index].id)
  isAddClass.value = false
  showEditClassDlg.value = true
}

const onDelClass = (id) => {
  delClass(id)
}

const onAddStudent = () => {
  editClassInfo.students.others.forEach(() => {
    // TODO 调用添加学生接口
  })
  listClassStudents(editClassInfo.id)
}

const onSelectStudents = (val) => {
  editClassInfo.students.others = val
}

/**添加班级 */
const addClass = () => {
  createClzApi({
    course: editClassInfo.course,
    name: editClassInfo.name,
    maxStudents: editClassInfo.maxStudents,
    status: editClassInfo.status,
    planOpenDate: editClassInfo.planOpenDate,
    openDate: editClassInfo.openDate,
    remark: editClassInfo.remark,
    courseId: editClassInfo.courseId,
    headTeacherId: editClassInfo.headteacherId
  })
}

/**删除课程 */
const delClass = (classId) => {
  deleteClzApi(classId)
}

/**修改课程 */
const modifyClass = () => {
  updateClzApi({
    course: editClassInfo.course,
    name: editClassInfo.name,
    maxStudents: editClassInfo.maxStudents,
    status: editClassInfo.status,
    planOpenDate: editClassInfo.planOpenDate,
    openDate: editClassInfo.openDate,
    remark: editClassInfo.remark,
    courseId: editClassInfo.courseId,
    headTeacherId: editClassInfo.headteacherId
  })
}

/**列举班级 */
const listClasses = async (): Promise<ClzVO[]> => {
  return await getClzListApi({})
}

const onAddTimeTable = () => {
  showAddTimeTableDlg.value = true
}

const onDelTimeTable = (id) => {
  deleteTimetableApi(id)
}

const onSubmitTimeTable = () => {
  addTimeTableForm.value.validate((valid) => {
    if (valid) {
      let param: TimetableVO = {
        type: addTimetableInfo.type,
        beginDate: addTimetableInfo.classDate[0],
        endDate: addTimetableInfo.classDate[1],
        beginTime: addTimetableInfo.classTime[0],
        endTime: addTimetableInfo.classTime[1],
        classId: 0,
        teacherId: addTimetableInfo.teacher,
        classroomId: addTimetableInfo.classroom,
        daysWeekly: Buffer.from(
          Object.entries(daysofweek)
            .filter((v) => addTimetableInfo.checkedDays.includes(v[1]))
            .map((r) => r[0])
            .join('')
        ).readInt8()
      }
      createTimetableApi(param)
      showAddTimeTableDlg.value = false
    }
  })
}

const onSubmitClass = () => {
  addClassForm.value.validate((valid) => {
    if (valid) {
      if (isAddClass.value) {
        addClass()
      } else {
        modifyClass()
      }
    }
  })
}

onMounted(() => {
  nextTick(async () => {
    studentOptions = await getStudentOptionsApi()
    courseOptions = await getCourseOptionsApi()
    teacherOptions = await getTeacherOptionsApi()
    classroomOptions = await getClassroomOptionsApi()
    timeTableTypeOptions = getDictOptions(DICT_TYPE.SCHOOL_TIMETABLE_TYPE)
    classesInfo = await listClasses()
  })
})
</script>
<template>
  <content-wrap />
  <content-wrap>
    <div class="class-manage">
      <el-table :data="classesInfo">
        <el-table-column prop="name" label="名称" />
        <el-table-column prop="course.name" label="课程" />
        <el-table-column prop="opendate" label="开课日期" />
        <el-table-column prop="maxstudents" label="学生人数" />
        <el-table-column prop="headteacher.name" label="班主任" />
        <el-table-column>
          <template #default="scope">
            {{ scope }}
            <!-- <template v-if="scope.row.timeTable != undefined">
              {{ scope.row.timeTable.dayofweek }} + '|' + {{ scope.row.timeTable.time }} + '|' +
              {{ scope.row.timeTable.classroom }} + '|' + {{ scope.row.timeTable.teacher }}
            </template> -->
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button @click="onModifyClass(scope.$index)" type="text">编辑</el-button>
            <el-button @click="onDelClass(scope.row.id)" type="text">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 修改班级对话框 -->
    <div class="class-edit">
      <el-dialog
        :title="isAddClass ? '新增班级' : '修改班级'"
        v-model:visible="showEditClassDlg"
        width="70%"
      >
        <el-form :model="editClassInfo" ref="addClassForm" label-width="120px">
          <el-row>
            <el-col :span="isAddClass ? 24 : 7">
              <div class="class-edit-info">
                <el-form-item label="班级名称" prop="name" required>
                  <el-input type="textarea" v-model="editClassInfo.name" maxlength="16" />
                </el-form-item>
                <el-form-item label="选择课程" prop="course" required>
                  <el-select v-model="editClassInfo.course">
                    <el-option
                      v-for="course in courseOptions"
                      :key="course.id"
                      :label="course.label"
                      :value="course.id"
                    />
                  </el-select>
                </el-form-item>
                <el-form-item label="满班人数" prop="maxstudents" required>
                  <el-input type="number" v-model="editClassInfo.maxStudents" required />
                </el-form-item>
                <el-form-item label="班主任" prop="headteacher">
                  <el-select v-model="editClassInfo.headTeacherId">
                    <el-option
                      v-for="teacher in teacherOptions"
                      :key="teacher.id"
                      :label="teacher.label"
                      :value="teacher.id"
                    />
                  </el-select>
                </el-form-item>
                <el-form-item label="状态" porp="status" required>
                  <el-select label="状态" v-model="editClassInfo.status">
                    <el-option key="0" label="未开班" value="0" />
                    <el-option key="1" label="在读" value="1" />
                  </el-select>
                </el-form-item>
                <el-form-item label="计划开班日期" prop="planopendate">
                  <el-input v-model="editClassInfo.planOpenDate" type="date" />
                </el-form-item>
                <el-form-item label="备注" prop="remark">
                  <el-input v-model="editClassInfo.remark" type="text" maxlength="16" />
                </el-form-item>
              </div>
            </el-col>
            <template v-if="!isAddClass">
              <el-col :span="1">&nbsp;</el-col>
              <el-col :span="16">
                <div class="class-edit-other">
                  <el-tabs v-model="editClassInfo.activeTab">
                    <el-tab-pane label="班级排课" name="timeTable">
                      <el-button type="primary" @click="onAddTimeTable">一键排课</el-button>
                      <el-table
                        class="modify-class"
                        v-model:data="editClassInfo.timeTable.items"
                        :edit-config="{ trigger: 'manual', mode: 'row' }"
                        height="320px"
                        ref="elxEditableTimeTable"
                      >
                        <el-table-column
                          label="排课方式"
                          prop="type"
                          width="120"
                          :edit-render="{
                            name: 'ElSelect',
                            options: timeTableTypeOptions,
                            optionProps: { value: 'id', label: 'label' }
                          }"
                        />
                        <el-table-column
                          :hidden="true"
                          label="上课日期"
                          width="140"
                          prop="classDate"
                          :edit-render="{
                            name: 'ElDatePicker',
                            props: {
                              type: 'daterange',
                              rangeSeparator: '-',
                              startPlaceholde: '开始日期',
                              endPlaceholde: '结束日期',
                              placeholder: '请选择上课日期'
                            }
                          }"
                        />
                        <el-table-column
                          label="上课时间"
                          prop="classTime"
                          width="120"
                          :edit-render="{
                            name: 'ElTimePicker',
                            props: {
                              isRange: true,
                              rangeSeparator: '-',
                              startPlaceholde: '开始时间',
                              endPlaceholde: '结束时间',
                              placeholder: '请选择上课时间'
                            }
                          }"
                        />
                        <el-table-column
                          label="授课老师"
                          prop="teacher"
                          width="120"
                          :edit-render="{
                            name: 'ElSelect',
                            options: teacherOptions,
                            optionProps: { value: 'id', label: 'label' }
                          }"
                        />
                        <el-table-column
                          label="上课教室"
                          prop="classroom"
                          width="120"
                          :edit-render="{
                            name: 'ElSelect',
                            options: classroomOptions,
                            optionProps: { value: 'id', label: 'label' }
                          }"
                        />
                        <el-table-column
                          label="状态"
                          prop="status"
                          width="80"
                          :edit-render="{
                            name: 'ElSelect',
                            options: [
                              { id: 0, name: '正常' },
                              { id: 1, name: '禁用' }
                            ],
                            optionProps: { value: 'id', label: 'name' }
                          }"
                          :filters="[
                            { text: '正常', value: '0' },
                            { text: '禁用', value: '1' }
                          ]"
                          :filterMethod="
                            (value, row, column) => Number(row[column.property]) === value
                          "
                        />
                        <el-table-column label="操作" fixed="right">
                          <template #default="scope">
                            <div style="display: inline-flex; flex-direction: column">
                              <el-button
                                size="small"
                                type="text"
                                style="margin-left: 0px"
                                @click="onDelTimeTable(scope.row.id)"
                                >删除</el-button
                              >
                            </div>
                          </template>
                        </el-table-column>
                      </el-table>
                    </el-tab-pane>
                    <el-tab-pane label="班级学员" name="students">
                      <el-row>
                        <el-col :span="12">
                          <el-table :data="editClassInfo.students.items">
                            <el-table-column prop="number" label="学号" />
                            <el-table-column prop="name" label="姓名" />
                            <el-table-column prop="enterdate" label="入班时间" />
                          </el-table>
                        </el-col>
                        <el-col :span="4">
                          <el-button
                            type="primary"
                            icon="el-icon-arrow-left"
                            @click="onAddStudent"
                            style="align-items: center"
                          />
                        </el-col>
                        <el-col :span="6">
                          <el-table
                            title="未入班学生"
                            :data="studentOptions"
                            @selection-change="onSelectStudents"
                          >
                            <el-table-column type="selection" />
                            <el-table-column label="姓名">
                              <template #default="scope">
                                {{ scope }}
                              </template>
                            </el-table-column>
                          </el-table>
                        </el-col>
                      </el-row>
                    </el-tab-pane>
                  </el-tabs>
                </div>
              </el-col>
            </template>
          </el-row>
        </el-form>
        <div>
          <slot name="footer">
            <el-button type="primary" @click="onSubmitClass()">提交</el-button>
          </slot>
        </div>
      </el-dialog>
    </div>
    <div class="timeTable-add">
      <el-dialog title="排课" v-model:visible="showAddTimeTableDlg">
        <el-form :model="addTimetableInfo" ref="addTimeTableForm" label-width="120px">
          <el-form-item label="排课方式" prop="type" required>
            <el-select v-model="addTimetableInfo.type">
              <el-option
                v-for="type in timeTableTypeOptions"
                :key="type.value"
                :value="type.value"
                :label="type.label"
              />
            </el-select>
          </el-form-item>
          <el-form-item label="周课计划" prop="checkedDays" required>
            <el-checkbox-group v-model="addTimetableInfo.daysWeekly">
              <el-checkbox v-for="(name, id) in daysofweek" :key="id" :label="name" />
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="上课日期" prop="classDate" required>
            <el-date-picker
              type="daterange"
              v-model="addTimetableInfo.classDate"
              range-separator="至"
              start-placeholde="开始日期"
              end-placeholde="结束日期"
              placeholder="请选择上课日期"
            />
          </el-form-item>
          <el-form-item label="上课时间" prop="classTime" required>
            <el-time-picker
              is-range
              v-model="addTimetableInfo.classTime"
              range-separator="至"
              start-placeholde="开始时间"
              end-placeholde="结束时间"
              placeholder="请选择上课时间"
            />
          </el-form-item>
          <el-form-item label="授课老师" prop="teacher" required>
            <el-select v-model="addTimetableInfo.teacher">
              <el-option
                v-for="teacher in teacherOptions"
                :key="teacher.id"
                :value="teacher.id"
                :label="teacher.label"
              />
            </el-select>
          </el-form-item>
          <el-form-item label="上课教室" prop="classroom" required>
            <el-select v-model="addTimetableInfo.classroom">
              <el-option
                v-for="classroom in classroomOptions"
                :key="classroom.id"
                :value="classroom.id"
                :label="classroom.label"
              />
            </el-select>
          </el-form-item>
          <el-form-item label="状态" prop="status" required>
            <el-select v-model="addTimetableInfo.status">
              <el-option key="0" label="正常" value="0" />
              <el-option key="1" label="禁用" value="1" />
            </el-select>
          </el-form-item>
        </el-form>
        <div>
          <slot name="footer">
            <el-button type="primary" @click="onSubmitTimeTable()">确定</el-button>
          </slot>
        </div>
      </el-dialog>
    </div>
  </content-wrap>
</template>
