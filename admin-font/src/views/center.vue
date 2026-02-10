<template>
	<div :style='{"padding":"22px 28px"}'>
		<el-form
			:style='{"border":"0px solid #ddd","padding":"50px 30px","boxShadow":"none","borderRadius":"8px","flexWrap":"wrap","background":"#ffffff","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='nonghu'"  label="农户账号" prop="nonghuzhanghao">
					<el-input v-model="ruleForm.nonghuzhanghao" :readonly="ro.nonghuzhanghao" placeholder="农户账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='nonghu'"  label="农户姓名" prop="nonghuxingming">
					<el-input v-model="ruleForm.nonghuxingming" :readonly="ro.nonghuxingming" placeholder="农户姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='nonghu'"  label="性别" prop="xingbie">
					<el-select filterable v-model="ruleForm.xingbie" :disabled="ro.xingbie" placeholder="请选择性别">
						<el-option
							v-for="(item,index) in nonghuxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='nonghu'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="nonghutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='nonghu'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" :readonly="ro.lianxidianhua" placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='nonghu'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion" :readonly="ro.pquestion" placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='nonghu'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer" :readonly="ro.panswer" placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='jishurenyuan'"  label="技术员账号" prop="jishuyuanzhanghao">
					<el-input v-model="ruleForm.jishuyuanzhanghao" :readonly="ro.jishuyuanzhanghao" placeholder="技术员账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='jishurenyuan'"  label="技术员姓名" prop="jishuyuanxingming">
					<el-input v-model="ruleForm.jishuyuanxingming" :readonly="ro.jishuyuanxingming" placeholder="技术员姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='jishurenyuan'"  label="性别" prop="xingbie">
					<el-select filterable v-model="ruleForm.xingbie" :disabled="ro.xingbie" placeholder="请选择性别">
						<el-option
							v-for="(item,index) in jishurenyuanxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='jishurenyuan'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="jishurenyuantouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='jishurenyuan'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" :readonly="ro.lianxidianhua" placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='jishurenyuan'" label="资质证书" prop="zizhizhengshu">
					<file-upload
						tip="点击上传资质证书"
						action="file/upload"
						:limit="1"
						:type="3"
						:multiple="false"
						:fileUrls="ruleForm.zizhizhengshu?ruleForm.zizhizhengshu:''"
						@change="jishurenyuanzizhizhengshuUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='jishurenyuan'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion" :readonly="ro.pquestion" placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='jishurenyuan'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer" :readonly="ro.panswer" placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='jishurenyuan'" label="擅长领域" prop="shanzhanglingyu">
					<editor
						:disabled="ro.shanzhanglingyu"
						myQuillEditor="shanzhanglingyu"
						style="min-width: 200px; max-width: 600px;"
						:style='{"boxShadow":" inset 0px 3px 6px 1px rgba(0,0,0,0.16)","borderRadius":"8px","flexWrap":"wrap","background":"#fff","borderWidth":"0","display":"flex","width":"100%","height":"auto"}'
						v-model="ruleForm.shanzhanglingyu" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="信用代码" prop="xinyongdaima">
					<el-input v-model="ruleForm.xinyongdaima" :readonly="ro.xinyongdaima" placeholder="信用代码" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="合作社名称" prop="hezuoshemingcheng">
					<el-input v-model="ruleForm.hezuoshemingcheng" :readonly="ro.hezuoshemingcheng" placeholder="合作社名称" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='hezuoshe'" label="封面" prop="fengmian">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="hezuoshefengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'  v-if="flag=='hezuoshe'" label="成立日期" prop="chengliriqi">
					<el-date-picker
						:disabled="ro.chengliriqi"
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.chengliriqi" 
						type="date"
						placeholder="成立日期">
					</el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="联系人" prop="lianxiren">
					<el-input v-model="ruleForm.lianxiren" :readonly="ro.lianxiren" placeholder="联系人" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" :readonly="ro.lianxifangshi" placeholder="联系方式" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="主营项目" prop="zhuyingxiangmu">
					<el-input v-model="ruleForm.zhuyingxiangmu" :readonly="ro.zhuyingxiangmu" placeholder="主营项目" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="所在地" prop="suozaidi">
					<el-input v-model="ruleForm.suozaidi" :readonly="ro.suozaidi" placeholder="所在地" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion" :readonly="ro.pquestion" placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}'   v-if="flag=='hezuoshe'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer" :readonly="ro.panswer" placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='hezuoshe'" label="合作社详情" prop="hezuoshexiangqing">
					<editor
						:disabled="ro.hezuoshexiangqing"
						myQuillEditor="hezuoshexiangqing"
						style="min-width: 200px; max-width: 600px;"
						:style='{"boxShadow":" inset 0px 3px 6px 1px rgba(0,0,0,0.16)","borderRadius":"8px","flexWrap":"wrap","background":"#fff","borderWidth":"0","display":"flex","width":"100%","height":"auto"}'
						v-model="ruleForm.hezuoshexiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"10px 0px 10px 0 ","display":"flex"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 30px","margin":"30px  auto 0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"auto","justifyContent":"center"}'>
					<el-button class="btn3" type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-queren15"></span>
						确定 
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
	import { 
		isIntNumer,
		isMobile,
	} from "@/utils/validate";

	export default {
		data() {
			return {
				ruleForm: {},
				flag: '',
				usersFlag: false,
				nonghuxingbieOptions: [],
				jishurenyuanxingbieOptions: [],
			};
		},
		mounted() {
			var table = this.$storage.get("sessionTable");
			this.flag = table;
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(table == 'nonghu') {
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
					if(table == 'jishurenyuan') {
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
					if(table == 'hezuoshe') {
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

					this.ruleForm = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.nonghuxingbieOptions = "男,女".split(',')
			this.jishurenyuanxingbieOptions = "男,女".split(',')
		},
		methods: {
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
			usersimageUploadChange(fileUrls) {
				this.ruleForm.image = fileUrls;
			},
			onUpdateHandler() {
				if((!this.ruleForm.nonghuzhanghao)&& 'nonghu'==this.flag){
					this.$message.error('农户账号不能为空');
					return
				}
				if((!this.ruleForm.mima)&& 'nonghu'==this.flag){
					this.$message.error('密码不能为空');
					return
				}
				if((!this.ruleForm.nonghuxingming)&& 'nonghu'==this.flag){
					this.$message.error('农户姓名不能为空');
					return
				}
				if(this.ruleForm.touxiang!=null) {
					this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
				}
				if('nonghu' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
					this.$message.error(`联系电话应输入手机格式`);
					return
				}
				if('nonghu' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
					this.$message.error(`状态应输入整数`);
					return
				}
				if((!this.ruleForm.jishuyuanzhanghao)&& 'jishurenyuan'==this.flag){
					this.$message.error('技术员账号不能为空');
					return
				}
				if((!this.ruleForm.mima)&& 'jishurenyuan'==this.flag){
					this.$message.error('密码不能为空');
					return
				}
				if((!this.ruleForm.jishuyuanxingming)&& 'jishurenyuan'==this.flag){
					this.$message.error('技术员姓名不能为空');
					return
				}
				if(this.ruleForm.touxiang!=null) {
					this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
				}
				if('jishurenyuan' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
					this.$message.error(`联系电话应输入手机格式`);
					return
				}
				if(this.ruleForm.zizhizhengshu!=null) {
					this.ruleForm.zizhizhengshu = this.ruleForm.zizhizhengshu.replace(new RegExp(this.$base.url,"g"),"");
				}
				if('jishurenyuan' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
					this.$message.error(`状态应输入整数`);
					return
				}
				if((!this.ruleForm.xinyongdaima)&& 'hezuoshe'==this.flag){
					this.$message.error('信用代码不能为空');
					return
				}
				if((!this.ruleForm.mima)&& 'hezuoshe'==this.flag){
					this.$message.error('密码不能为空');
					return
				}
				if((!this.ruleForm.hezuoshemingcheng)&& 'hezuoshe'==this.flag){
					this.$message.error('合作社名称不能为空');
					return
				}
				if(this.ruleForm.fengmian!=null) {
					this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
				}
				if((!this.ruleForm.chengliriqi)&& 'hezuoshe'==this.flag){
					this.$message.error('成立日期不能为空');
					return
				}
				if('hezuoshe' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
					this.$message.error(`联系方式应输入手机格式`);
					return
				}
				if('hezuoshe' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
					this.$message.error(`状态应输入整数`);
					return
				}
				if('users'==this.flag && this.ruleForm.username.trim().length<1) {
					this.$message.error(`用户名不能为空`);
					return	
				}
				if(this.flag=='users'){
					this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
				}
				this.$http({
					url: `${this.$storage.get("sessionTable")}/update`,
					method: "post",
					data: this.ruleForm
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(this.flag=='users'){
							this.$storage.set('headportrait',this.ruleForm.image)
						}else {
							if(this.flag == 'nonghu') {
								this.$storage.set('headportrait',this.ruleForm.touxiang)
							}
							if(this.flag == 'jishurenyuan') {
								this.$storage.set('headportrait',this.ruleForm.touxiang)
							}
						}
						this.$message({
							message: "修改信息成功",
							type: "success",
							duration: 1500,
							onClose: () => {
								window.location.reload();
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
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
				padding: 0 10px;
				color: #000000;
				white-space: nowrap;
				font-weight: 600;
				width: 180px;
				font-size: 16px;
				line-height: 40px;
				text-align: right;
			}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
				border-radius: 4px;
				padding: 0 12px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				outline: none;
				color: #333;
				width: 100%;
				font-size: 16px;
				border-width: 0;
				height: 50px;
			}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
				border-radius: 4px;
				padding: 0 12px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				outline: none;
				color: #333;
				width: 100%;
				font-size: 16px;
				border-width: 0;
				height: 50px;
			}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
				border-radius: 4px;
				padding: 0 30px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				outline: none;
				color: #333;
				width: 100%;
				font-size: 16px;
				border-width: 0;
				height: 50px;
			}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #DADFE6;
				cursor: pointer;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #000000;
				font-weight: 600;
				width: 100px;
				font-size: 30px;
				line-height: 100px;
				text-align: center;
				height: 100px;
			}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
				border: 1px solid #DADFE6;
				cursor: pointer;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #000000;
				font-weight: 600;
				width: 100px;
				font-size: 30px;
				line-height: 100px;
				text-align: center;
				height: 100px;
			}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
				border-radius: 4px;
				padding: 12px;
				box-shadow:  inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				outline: none;
				color: #666;
				background: #fff;
				width: 100%;
				font-size: 16px;
				border-color: #555555;
				border-width: 0;
				border-style: solid;
				height: auto;
			}
	
	.add-update-preview .btn3 {
				border: 0px solid #206cb4;
				cursor: pointer;
				padding: 0 24px;
				margin: 4px;
				color: #fff;
				font-weight: bold;
				font-size: 16px;
				border-radius: 24px  24px  24px  24px;
				outline: none;
				background: #10C17C;
				width: auto;
				min-width: 176px;
				height: 47px;
				.iconfont {
						margin: 0 2px;
						color: #fff;
						display: none;
						font-size: 16px;
						height: 40px;
					}
	}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
