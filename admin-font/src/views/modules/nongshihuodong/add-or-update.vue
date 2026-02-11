<template>
  <div class="farm-activity-container">
    <!-- 一级标题：农事活动 -->
    <h2 class="section-title">农事活动</h2>
    
    <!-- 功能操作区 -->
    <div class="operation-area">
      <el-button type="primary" @click="handleAdd">新增记录</el-button>
      <el-select v-model="recordType" placeholder="选择记录类型">
        <el-option label="种植记录" value="planting"></el-option>
        <el-option label="灌溉记录" value="irrigation"></el-option>
        <el-option label="施肥记录" value="fertilization"></el-option>
      </el-select>
      <el-input v-model="searchKeyword" placeholder="搜索记录" style="width: 200px; margin-left: 10px;"></el-input>
    </div>
    
    <!-- 表格展示区 -->
    <el-table :data="activityList" style="width: 100%; margin-top: 20px;">
      <el-table-column prop="recordType" label="记录类型">
        <template #default="scope">
          {{ formatRecordType(scope.row.recordType) }}
        </template>
      </el-table-column>
      <el-table-column prop="content" label="活动内容"></el-table-column>
      <el-table-column prop="operator" label="操作人"></el-table-column>
      <el-table-column prop="operateTime" label="操作时间">
        <template #default="scope">
          {{ formatDate(scope.row.operateTime) }}
        </template>
      </el-table-column>
      <el-table-column prop="greenhouseName" label="所属大棚"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <!-- 分页组件 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 50]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    ></el-pagination>
    
    <!-- 新增/编辑对话框 -->
    <el-dialog :title="dialogTitle" v-model="dialogVisible">
      <el-form :model="form" label-width="100px">
        <el-form-item label="记录类型">
          <el-select v-model="form.recordType" placeholder="请选择">
            <el-option label="种植记录" value="planting"></el-option>
            <el-option label="灌溉记录" value="irrigation"></el-option>
            <el-option label="施肥记录" value="fertilization"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动内容">
          <el-input type="textarea" v-model="form.content" :rows="3"></el-input>
        </el-form-item>
        <el-form-item label="所属大棚">
          <el-select v-model="form.greenhouseId" placeholder="请选择">
            <el-option 
              v-for="item in greenhouseList" 
              :key="item.id" 
              :label="item.name" 
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="操作时间">
          <el-date-picker
            v-model="form.operateTime"
            type="datetime"
            placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注">
          <el-input type="textarea" v-model="form.remark" :rows="2"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { ref, reactive, onMounted, computed } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { 
  getFarmActivityList, 
  addFarmActivity, 
  updateFarmActivity, 
  deleteFarmActivity 
} from '@/api/farmActivity'

export default {
  name: 'FarmActivityManagement',
  setup() {
    const activityList = ref([])
    const currentPage = ref(1)
    const pageSize = ref(10)
    const total = ref(0)
    const searchKeyword = ref('')
    const recordType = ref('')
    const dialogVisible = ref(false)
    const isEditMode = ref(false)
    const greenhouseList = ref([])
    
    const form = reactive({
      id: null,
      recordType: '',
      content: '',
      greenhouseId: null,
      operateTime: new Date(),
      remark: ''
    })
    
    const dialogTitle = computed(() => {
      return isEditMode.value ? '编辑农事活动' : '新增农事活动'
    })
    
    // 获取农事活动列表
    const fetchActivityList = async () => {
      try {
        const params = {
          page: currentPage.value,
          size: pageSize.value,
          keyword: searchKeyword.value,
          recordType: recordType.value
        }
        const response = await getFarmActivityList(params)
        activityList.value = response.data.list
        total.value = response.data.total
      } catch (error) {
        ElMessage.error('获取数据失败')
      }
    }
    
    // 新增记录
    const handleAdd = () => {
      isEditMode.value = false
      Object.keys(form).forEach(key => {
        if (key === 'operateTime') {
          form[key] = new Date()
        } else if (key === 'id') {
          form[key] = null
        } else {
          form[key] = ''
        }
      })
      dialogVisible.value = true
    }
    
    // 编辑记录
    const handleEdit = (row) => {
      isEditMode.value = true
      Object.assign(form, row)
      dialogVisible.value = true
    }
    
    // 删除记录
    const handleDelete = (id) => {
      ElMessageBox.confirm('确定删除该记录吗？', '提示', {
        type: 'warning'
      }).then(async () => {
        try {
          await deleteFarmActivity(id)
          ElMessage.success('删除成功')
          fetchActivityList()
        } catch (error) {
          ElMessage.error('删除失败')
        }
      })
    }
    
    // 提交表单
    const submitForm = async () => {
      try {
        if (isEditMode.value) {
          await updateFarmActivity(form.id, form)
          ElMessage.success('更新成功')
        } else {
          await addFarmActivity(form)
          ElMessage.success('新增成功')
        }
        dialogVisible.value = false
        fetchActivityList()
      } catch (error) {
        ElMessage.error(isEditMode.value ? '更新失败' : '新增失败')
      }
    }
    
    // 分页处理
    const handleSizeChange = (val) => {
      pageSize.value = val
      fetchActivityList()
    }
    
    const handleCurrentChange = (val) => {
      currentPage.value = val
      fetchActivityList()
    }
    
    // 格式化记录类型
    const formatRecordType = (type) => {
      const typeMap = {
        'planting': '种植记录',
        'irrigation': '灌溉记录',
        'fertilization': '施肥记录'
      }
      return typeMap[type] || type
    }
    
    // 格式化日期
    const formatDate = (dateStr) => {
      if (!dateStr) return ''
      return new Date(dateStr).toLocaleString()
    }
    
    onMounted(() => {
      fetchActivityList()
    })
    
    return {
      activityList,
      currentPage,
      pageSize,
      total,
      searchKeyword,
      recordType,
      dialogVisible,
      dialogTitle,
      form,
      greenhouseList,
      handleAdd,
      handleEdit,
      handleDelete,
      submitForm,
      handleSizeChange,
      handleCurrentChange,
      formatRecordType,
      formatDate
    }
  }
}
</script>

<style scoped>
.farm-activity-container {
  padding: 20px;
}

.section-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
}

.operation-area {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
</style>