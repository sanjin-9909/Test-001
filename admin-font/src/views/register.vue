<template>
	<div>
		<div class="register-container" :style="{'backgroundImage': indexBgUrl?`url(${$base.url + indexBgUrl})`:''}">
			<el-form v-if="pageFlag=='security1'" class="rgs-form animate__animated animate__" :model="forgetForm">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot+Vue的果蔬大棚信息管理系统的设计与实现找回密码</div>
					<el-form-item class="list-item">
						<div class="lable">账号</div>
						<el-input v-model="forgetForm.username" autocomplete="off" placeholder="请您输入账号" />
					</el-form-item>
					<el-form-item class="list-item">
						<div class="lable">角色</div>
						<el-select v-model="tableName" placeholder="请您选择角色">
							<el-option label="技术人员" value="jishurenyuan"></el-option>
							<el-option label="合作社" value="hezuoshe"></el-option>
						</el-select>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="getSecurity()">下一步</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">取消</div>
						</div>
					</div>
				</div>
            </el-form>
			<el-form v-if="pageFlag=='security2'" class="rgs-form animate__animated animate__" :model="ruleForm">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot+Vue的果蔬大棚信息管理系统的设计与实现密码重置</div>
					<el-form-item class="list-item">
						<div class="lable">密保问题</div>
						<el-input v-model="ruleForm.pquestion" readOnly autocomplete="off" placeholder="密保问题" />
					</el-form-item>
					<el-form-item class="list-item">
						<div class="lable">密保答案</div>
						<el-input v-model="ruleForm.myanswer" autocomplete="off" placeholder="请您输入密保答案" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="validateSecurity()">下一步</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">取消</div>
						</div>
					</div>
				</div>
            </el-form>
			<el-form v-if="pageFlag=='security3'" class="rgs-form animate__animated animate__" :model="ruleForm">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot+Vue的果蔬大棚信息管理系统的设计与实现密码重置</div>
					<el-form-item class="list-item">
						<div class="lable">新密码</div>
						<el-input v-model="ruleForm.newpassword" autocomplete="off" type="password" placeholder="请您输入新密码" />
					</el-form-item>
					<el-form-item class="list-item">
						<div class="lable">确认密码</div>
						<el-input v-model="ruleForm.repassword" autocomplete="off" type="password" placeholder="请您确认新密码" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="updatePassword()">修改密码</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">取消</div>
						</div>
					</div>
				</div>
			</el-form>
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot+Vue的果蔬大棚信息管理系统的设计与实现注册</div>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('nonghuzhanghao')?'required':''">农户账号：</div>
						<el-input  v-model="ruleForm.nonghuzhanghao" :readonly="ro.nonghuzhanghao" autocomplete="off" placeholder="农户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima" :readonly="ro.mima" autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" :readonly="ro.mima" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('nonghuxingming')?'required':''">农户姓名：</div>
						<el-input  v-model="ruleForm.nonghuxingming" :readonly="ro.nonghuxingming" autocomplete="off" placeholder="农户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select filterable v-model="ruleForm.xingbie" placeholder="请选择性别" :disabled="ro.xingbie">
							<el-option
								v-for="(item,index) in nonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="nonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua" :readonly="ro.lianxidianhua" autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion" :readonly="ro.pquestion" autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='nonghu'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer" :readonly="ro.panswer" autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('jishuyuanzhanghao')?'required':''">技术员账号：</div>
						<el-input  v-model="ruleForm.jishuyuanzhanghao" :readonly="ro.jishuyuanzhanghao" autocomplete="off" placeholder="技术员账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima" :readonly="ro.mima" autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" :readonly="ro.mima" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('jishuyuanxingming')?'required':''">技术员姓名：</div>
						<el-input  v-model="ruleForm.jishuyuanxingming" :readonly="ro.jishuyuanxingming" autocomplete="off" placeholder="技术员姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select filterable v-model="ruleForm.xingbie" placeholder="请选择性别" :disabled="ro.xingbie">
							<el-option
								v-for="(item,index) in jishurenyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jishurenyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua" :readonly="ro.lianxidianhua" autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('zizhizhengshu')?'required':''">资质证书：</div>
						<file-upload
							tip="点击上传资质证书"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.zizhizhengshu?ruleForm.zizhizhengshu:''"
							@change="jishurenyuanzizhizhengshuUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion" :readonly="ro.pquestion" autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer" :readonly="ro.panswer" autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jishurenyuan'">
						<div class="lable" :class="changeRules('shanzhanglingyu')?'required':''">擅长领域：</div>
						<editor
							:disabled="ro.shanzhanglingyu"
							myQuillEditor="shanzhanglingyu"
							v-model="ruleForm.shanzhanglingyu" 
							class="editor" 
							action="file/upload">
						</editor>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('xinyongdaima')?'required':''">信用代码：</div>
						<el-input  v-model="ruleForm.xinyongdaima" :readonly="ro.xinyongdaima" autocomplete="off" placeholder="信用代码"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima" :readonly="ro.mima" autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" :readonly="ro.mima" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('hezuoshemingcheng')?'required':''">合作社名称：</div>
						<el-input  v-model="ruleForm.hezuoshemingcheng" :readonly="ro.hezuoshemingcheng" autocomplete="off" placeholder="合作社名称"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('fengmian')?'required':''">封面：</div>
						<file-upload
							tip="点击上传封面"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
							@change="hezuoshefengmianUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('chengliriqi')?'required':''">成立日期：</div>
						<el-date-picker
							format="yyyy 年 MM 月 dd 日"
							value-format="yyyy-MM-dd"
							v-model="ruleForm.chengliriqi"
							type="date"
							:disabled="ro.chengliriqi"
							placeholder="成立日期"
						></el-date-picker>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('lianxiren')?'required':''">联系人：</div>
						<el-input  v-model="ruleForm.lianxiren" :readonly="ro.lianxiren" autocomplete="off" placeholder="联系人"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input  v-model="ruleForm.lianxifangshi" :readonly="ro.lianxifangshi" autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('zhuyingxiangmu')?'required':''">主营项目：</div>
						<el-input  v-model="ruleForm.zhuyingxiangmu" :readonly="ro.zhuyingxiangmu" autocomplete="off" placeholder="主营项目"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('suozaidi')?'required':''">所在地：</div>
						<el-input  v-model="ruleForm.suozaidi" :readonly="ro.suozaidi" autocomplete="off" placeholder="所在地"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion" :readonly="ro.pquestion" autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer" :readonly="ro.panswer" autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='hezuoshe'">
						<div class="lable" :class="changeRules('hezuoshexiangqing')?'required':''">合作社详情：</div>
						<editor
							:disabled="ro.hezuoshexiangqing"
							myQuillEditor="hezuoshexiangqing"
							v-model="ruleForm.hezuoshexiangqing" 
							class="editor" 
							action="file/upload">
						</editor>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">取消</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
			ro: {},
            nonghuxingbieOptions: [],
            jishurenyuanxingbieOptions: [],
			indexBgUrl: '',
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='nonghu'){
				this.ruleForm = {
					nonghuzhanghao: '',
					mima: '',
					nonghuxingming: '',
					xingbie: '',
					touxiang: '',
					lianxidianhua: '',
					pquestion: '',
					panswer: '',
					status: '',
				}
				this.ro = {
					nonghuzhanghao: false,
					mima: false,
					nonghuxingming: false,
					xingbie: false,
					touxiang: false,
					lianxidianhua: false,
					pquestion: false,
					panswer: false,
					status: false,
				}
			}
			if(this.tableName=='jishurenyuan'){
				this.ruleForm = {
					jishuyuanzhanghao: '',
					mima: '',
					jishuyuanxingming: '',
					xingbie: '',
					touxiang: '',
					lianxidianhua: '',
					zizhizhengshu: '',
					shanzhanglingyu: '',
					sfsh: '',
					shhf: '',
					pquestion: '',
					panswer: '',
					status: '',
				}
				this.ro = {
					jishuyuanzhanghao: false,
					mima: false,
					jishuyuanxingming: false,
					xingbie: false,
					touxiang: false,
					lianxidianhua: false,
					zizhizhengshu: false,
					shanzhanglingyu: false,
					sfsh: false,
					shhf: false,
					pquestion: false,
					panswer: false,
					status: false,
				}
			}
			if(this.tableName=='hezuoshe'){
				this.ruleForm = {
					xinyongdaima: '',
					mima: '',
					hezuoshemingcheng: '',
					fengmian: '',
					chengliriqi: '',
					lianxiren: '',
					lianxifangshi: '',
					zhuyingxiangmu: '',
					suozaidi: '',
					hezuoshexiangqing: '',
					pquestion: '',
					panswer: '',
					status: '',
				}
				this.ro = {
					xinyongdaima: false,
					mima: false,
					hezuoshemingcheng: false,
					fengmian: false,
					chengliriqi: false,
					lianxiren: false,
					lianxifangshi: false,
					zhuyingxiangmu: false,
					suozaidi: false,
					hezuoshexiangqing: false,
					pquestion: false,
					panswer: false,
					status: false,
				}
			}
			if ('nonghu' == this.tableName) {
				this.rules.nonghuzhanghao = [{ required: true, message: '请输入农户账号', trigger: 'blur' }]
			}
			if ('nonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('nonghu' == this.tableName) {
				this.rules.nonghuxingming = [{ required: true, message: '请输入农户姓名', trigger: 'blur' }]
			}
			if ('jishurenyuan' == this.tableName) {
				this.rules.jishuyuanzhanghao = [{ required: true, message: '请输入技术员账号', trigger: 'blur' }]
			}
			if ('jishurenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jishurenyuan' == this.tableName) {
				this.rules.jishuyuanxingming = [{ required: true, message: '请输入技术员姓名', trigger: 'blur' }]
			}
			if ('hezuoshe' == this.tableName) {
				this.rules.xinyongdaima = [{ required: true, message: '请输入信用代码', trigger: 'blur' }]
			}
			if ('hezuoshe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('hezuoshe' == this.tableName) {
				this.rules.hezuoshemingcheng = [{ required: true, message: '请输入合作社名称', trigger: 'blur' }]
			}
			if ('hezuoshe' == this.tableName) {
				this.rules.chengliriqi = [{ required: true, message: '请输入成立日期', trigger: 'blur' }]
			}
			this.nonghuxingbieOptions = "男,女".split(',')
			this.jishurenyuanxingbieOptions = "男,女".split(',')
			this.ruleForm.chengliriqi = this.getCurDate()
		}
	},
	created() {
		this.$http.get('config/info?name=bRegisterBackgroundImg',).then(rs=>{this.indexBgUrl = rs.data.data?rs.data.data.value:''})
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			if(name == 'pquestion'||name=='panswer') {
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        nonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jishurenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jishurenyuanzizhizhengshuUploadChange(fileUrls) {
            this.ruleForm.zizhizhengshu = fileUrls;
        },
        hezuoshefengmianUploadChange(fileUrls) {
            this.ruleForm.fengmian = fileUrls;
        },

        // 多级联动参数


        //获取密保问题
        getSecurity(){
            if(!this.tableName) {
                this.$message.error("请选择角色");
                return false
            }
            if(!this.forgetForm.username){
                this.$message.error("请输入账号");
                return false
            }
            this.$http({
                url: this.tableName+`/security?username=` + this.forgetForm.username,
                method: "get",
            }).then(({
                data
            }) => {
                if (data.data && data.code === 0) {
                    this.ruleForm = data.data;
                    this.pageFlag="security2"
                } else {
                    if(!data.data) {
                        this.$message.error("用户不存在");
                    } else {
                        this.$message.error(data.msg);
                    }
                }
            });
        },
        //验证密保问题
        validateSecurity(){
            let that = this
            if(this.ruleForm.panswer!=this.ruleForm.myanswer){
                this.$message.error("答案输入不正确");
                return false
            }
            this.$message.success("答案正确");
            setTimeout(()=>{
                this.pageFlag="security3";
            },1000)
        },
        // 修改密码
        updatePassword() {
            if (this.ruleForm.newpassword != this.ruleForm.repassword) {
                this.$message.error("两次密码输入不一致");
                return;
            }
            this.ruleForm.mima = this.ruleForm.newpassword;
            this.ruleForm.password = this.ruleForm.newpassword;
            this.$http({
                url: this.tableName+`/update`,
                method: "post",
                data: this.ruleForm
            }).then(({
                data
            }) => {
                if (data && data.code === 0) {
                    this.$message({
                        message: "修改密码成功",
                        type: "success",
                        duration: 1500,
                        onClose: () => {}
                    });
                    this.close()
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.nonghuzhanghao) && `nonghu` == this.tableName){
				this.$message.error(`农户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `nonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `nonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.nonghuxingming) && `nonghu` == this.tableName){
				this.$message.error(`农户姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`nonghu` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if(`nonghu` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`nonghu` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			  if(this.tableName=='jishurenyuan'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.jishuyuanzhanghao) && `jishurenyuan` == this.tableName){
				this.$message.error(`技术员账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jishurenyuan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jishurenyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.jishuyuanxingming) && `jishurenyuan` == this.tableName){
				this.$message.error(`技术员姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`jishurenyuan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
            if(this.ruleForm.zizhizhengshu!=null) {
                this.ruleForm.zizhizhengshu = this.ruleForm.zizhizhengshu.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`jishurenyuan` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`jishurenyuan` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			if((!this.ruleForm.xinyongdaima) && `hezuoshe` == this.tableName){
				this.$message.error(`信用代码不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `hezuoshe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `hezuoshe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.hezuoshemingcheng) && `hezuoshe` == this.tableName){
				this.$message.error(`合作社名称不能为空`);
				return
			}
            if(this.ruleForm.fengmian!=null) {
                this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.chengliriqi) && `hezuoshe` == this.tableName){
				this.$message.error(`成立日期不能为空`);
				return
			}
			if(`hezuoshe` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
			if(`hezuoshe` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`hezuoshe` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		},
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20250906/6759760eab6d436baf1714deb0fa1dae.png);
	background-repeat: no-repeat;
	background-size: cover !important;
	background: url(http://codegen.caihongy.cn/20250906/6759760eab6d436baf1714deb0fa1dae.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center bottom;
	.rgs-form {
		.rgs-form2 {
		padding: 122px 40px 10px 130px;
		margin: 0  153px 0 0;
		background: rgba(255,255,255,.6);
		display: flex;
		width: 600px;
		position: relative;
		flex-wrap: wrap;
		}
		border-radius: 0;
		padding: 0;
		margin: 30px auto;
		z-index: 1;
		flex-direction: column;
		background: none;
		display: flex;
		width: 100%;
		align-items: flex-end;
		flex-wrap: wrap;
		height: auto;
		.title {
			padding: 0 10px;
			margin: 0px 0 20px 0;
			color: #0D1818;
			font-weight: 600;
			display: flex;
			font-size: 22px;
			line-height: 33px;
			text-shadow: none;
			top: 0;
			align-content: center;
			left: 0;
			background: #F1D36D;
			width: 100%;
			justify-content: center;
			align-items: center;
			position: absolute;
			text-align: center;
			height: 92px;
		}
		.list-item {
			box-shadow:  inset 0px 3px 6px 1px rgba(0,0,0,0.16);
			margin: 0  30px 20px;
			background: none;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				padding: 0 10px 0 0;
				color: #333;
				left: -130px;
				width: 130px;
				font-size: 16px;
				line-height: 60px;
				position: absolute !important;
				text-align: right;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #333;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 30px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 0px solid #DADFE6;
				border-radius: 4px;
				padding: 0 30px;
				color: #333;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 0px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				margin: 0px 0 0;
				color: #999;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 0px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				margin: 0px 0 0;
				color: #999;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 0px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				margin: 0px 0 0;
				color: #999;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				margin: 0 0 0 20px;
				color: #666;
				font-size: 16px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 120px;
				position: absolute;
				content: "*";
			}
			.editor {
				border: 0;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 0px solid #DADFE6;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				color: #333;
				flex: 1;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			input:focus {
				border: 0px solid #DADFE6;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				color: #333;
				flex: 1;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0;
				cursor: pointer;
				padding: 0 10px;
				margin: 0;
				color: #fff;
				font-size: 16px;
				border-color: #d1d1d1;
				border-radius: 0 4px 4px 0;
				box-shadow: none;
				outline: none;
				background: #10C17C;
				width: 130px;
				border-width: 0 0 0px;
				border-style: solid;
				height: 44px;
			}
			button:hover {
				color: #4c7bf5;
				border-color: #4c7bf5;
			}
		}
		.register-btn {
			display: flex;
			width: 100%;
			justify-content: center;
			flex-wrap: wrap;
		}
		.register-btn1 {
			margin: 0 20px 0 0;
			width: auto;
		}
		.register-btn2 {
			width: 176px;
		}
		.r-btn {
			border: 0;
			cursor: pointer;
			border-radius: 24px;
			outline: none;
			color: #fff;
			background: #10C17C;
			font-weight: bold;
			width: 176px;
			font-size: 16px;
			height: 47px;
		}
		.r-btn:hover {
			opacity: 0.5;
		}
		.r-login {
			border: 0;
			cursor: pointer;
			padding: 0 24px;
			margin: 0 0 20px;
			color: #333333;
			font-weight: bold;
			font-size: 16px;
			line-height: 47px;
			border-radius: 24px;
			outline: none;
			background: #FAFAFA;
			width: 176px;
			text-align: center;
			height: 47px;
		}
		.r-login:hover {
			opacity: 0.8;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
