





















<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
			>
			<el-form-item class="add-item" label="大棚名称" prop="dapengmingcheng">
				<el-input v-model="ruleForm.dapengmingcheng" 
					placeholder="大棚名称" clearable :readonly="ro.dapengmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备名称" prop="shebeimingcheng">
				<el-input v-model="ruleForm.shebeimingcheng" 
					placeholder="设备名称" clearable :readonly="ro.shebeimingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备类型" prop="shebeileixing">
				<el-input v-model="ruleForm.shebeileixing" 
					placeholder="设备类型" clearable :readonly="ro.shebeileixing"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备图片" v-if="type!='cross' || (type=='cross' && !ro.shebeitupian)" prop="shebeitupian">
				<file-upload
					tip="点击上传设备图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:disabled="ro.shebeitupian"
					:fileUrls="ruleForm.shebeitupian?ruleForm.shebeitupian:''"
					@change="shebeitupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="设备图片" prop="shebeitupian">
				<img v-if="ruleForm.shebeitupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.shebeitupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.shebeitupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="设备型号" prop="shebeixinghao">
				<el-input v-model="ruleForm.shebeixinghao" 
					placeholder="设备型号" clearable :readonly="ro.shebeixinghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="购买时间" prop="goumaishijian">
				<el-date-picker
					:disabled="ro.goumaishijian"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.goumaishijian" 
					type="date"
					placeholder="购买时间">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="购买数量" prop="shuliang">
				<el-input v-model.number="ruleForm.shuliang" 
					placeholder="购买数量" clearable :readonly="ro.shuliang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="价格" prop="jiage">
				<el-input-number v-model="ruleForm.jiage" placeholder="价格" :disabled="ro.jiage"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="购买金额" prop="goumaijine">
				<el-input v-model="goumaijine" placeholder="购买金额" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农户账号" prop="nonghuzhanghao">
				<el-input v-model="ruleForm.nonghuzhanghao" 
					placeholder="农户账号" clearable :readonly="ro.nonghuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农户姓名" prop="nonghuxingming">
				<el-input v-model="ruleForm.nonghuxingming" 
					placeholder="农户姓名" clearable :readonly="ro.nonghuxingming"></el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-xiugai2"></span>
					<span class="text">立即提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu7"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					dapengmingcheng : false,
					shebeimingcheng : false,
					shebeileixing : false,
					shebeitupian : false,
					shebeixinghao : false,
					goumaishijian : false,
					shuliang : false,
					jiage : false,
					goumaijine : false,
					nonghuzhanghao : false,
					nonghuxingming : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					dapengmingcheng: '',
					shebeimingcheng: '',
					shebeileixing: '',
					shebeitupian: '',
					shebeixinghao: '',
					goumaishijian: '',
					shuliang: '',
					jiage: '',
					goumaijine: '',
					nonghuzhanghao: '',
					nonghuxingming: '',
				},

				rules: {
					dapengmingcheng: [
					],
					shebeimingcheng: [
					],
					shebeileixing: [
					],
					shebeitupian: [
					],
					shebeixinghao: [
					],
					goumaishijian: [
					],
					shuliang: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					jiage: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					goumaijine: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					nonghuzhanghao: [
					],
					nonghuxingming: [
					],
				},
				centerType: false,
			};
		},
		computed: {
			sessionForm() {
				return JSON.parse(localStorage.getItem('sessionForm'))
			},
			goumaijine : {
				get: function () {
					let c = this.ruleForm
					let a = c.shuliang*c.jiage
					this.ruleForm.goumaijine = a?Number(Number(a).toFixed(2)):0
					return a?Number(Number(a).toFixed(2)):0
				}
				
			},



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.goumaishijian = this.getCurDate()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file ){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='dapengmingcheng'){
							this.ruleForm.dapengmingcheng = obj[o];
							this.ro.dapengmingcheng = true;
							continue;
						}
						if(o=='shebeimingcheng'){
							this.ruleForm.shebeimingcheng = obj[o];
							this.ro.shebeimingcheng = true;
							continue;
						}
						if(o=='shebeileixing'){
							this.ruleForm.shebeileixing = obj[o];
							this.ro.shebeileixing = true;
							continue;
						}
						if(o=='shebeitupian'){
							this.ruleForm.shebeitupian = obj[o]?obj[o].split(",")[0]:'';
							this.ro.shebeitupian = true;
							continue;
						}
						if(o=='shebeixinghao'){
							this.ruleForm.shebeixinghao = obj[o];
							this.ro.shebeixinghao = true;
							continue;
						}
						if(o=='goumaishijian'){
							this.ruleForm.goumaishijian = obj[o];
							this.ro.goumaishijian = true;
							continue;
						}
						if(o=='shuliang'){
							this.ruleForm.shuliang = obj[o];
							this.ro.shuliang = true;
							continue;
						}
						if(o=='jiage'){
							this.ruleForm.jiage = obj[o];
							this.ro.jiage = true;
							continue;
						}
						if(o=='goumaijine'){
							this.ruleForm.goumaijine = obj[o];
							this.ro.goumaijine = true;
							continue;
						}
						if(o=='nonghuzhanghao'){
							this.ruleForm.nonghuzhanghao = obj[o];
							this.ro.nonghuzhanghao = true;
							continue;
						}
						if(o=='nonghuxingming'){
							this.ruleForm.nonghuxingming = obj[o];
							this.ro.nonghuxingming = true;
							continue;
						}
					}
					this.ruleForm.shuliang = 0
					this.ro.shuliang = false
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.nonghuzhanghao!=''&&json.nonghuzhanghao) || json.nonghuzhanghao==0){
							this.ruleForm.nonghuzhanghao = json.nonghuzhanghao;
							this.ro.nonghuzhanghao = true;
						}
						if((json.nonghuxingming!=''&&json.nonghuxingming) || json.nonghuxingming==0){
							this.ruleForm.nonghuxingming = json.nonghuxingming;
							this.ro.nonghuxingming = true;
						}
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			async info() {
				await this.$http.get(`shebeigoumai/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(this.ruleForm.goumaijine==0){
					this.$message.error('购买金额不能为空')
					return false
				}
				if(!this.ruleForm.shuliang&&this.ruleForm.shuliang!=0){
					this.$message.error("购买数量不能为空");
					return
				}
				var obj = JSON.parse(localStorage.getItem('crossObj'));
				if(obj.shuliang<this.ruleForm.shuliang){
					this.$message.error("购买数量不足");
					return
				}
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
							// 跨表计算
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							var table = localStorage.getItem('crossTable');
							obj.shuliang = Number((parseFloat(obj.shuliang) - parseFloat(this.ruleForm.shuliang)).toFixed(2))
							await this.$http.post(table+`/update`,obj).then(res => {});
						}

						await this.$http.post(`shebeigoumai/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								await this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			shebeitupianUploadChange(fileUrls) {
				this.ruleForm.shebeitupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 10px calc((100% - 1200px)/2) 30px;
		margin: 0px auto;
		background: rgb(245, 245, 245);
		width: 100%;
		position: relative;
		.add-update-form {
			border-radius: 0px;
			padding: 40px 10% 20px 7%;
			background: #fff;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 0;
				margin: 0 0 20px;
				background: none;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #333;
					font-weight: 500;
					width: 200px;
					font-size: 16px;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 200px;
				}
				.el-input {
					width: 100%;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 10px;
					box-shadow: none;
					outline: none;
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 14px;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					background: #eee;
					width: 100%;
					font-size: 14px;
					height: 40px;
				}
				.el-date-editor {
					width: 100%;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					outline: none;
					color: #666;
					background: #eee;
					width: 100%;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 6px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
				}
				/deep/ .el-upload__tip {
					color: #666;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: #123;
					font-size: 16px;
				}
				/deep/ textarea::placeholder {
					color: #123;
					font-size: 16px;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					border-color: #ccc;
					border-width: 0;
					border-style: solid;
					height: auto;
				}
				.editor /deep/.ql-toolbar {
					background: none;
				}
				.editor /deep/.ql-container {
					background: none;
					min-height: 200px;
				}
				.editor /deep/.ql-container .ql-blank::before {
					color: #999;
				}
				.upload-img {
					object-fit: cover;
					width: 120px;
					height: 120px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #009899;
					width: auto;
					height: 34px;
				}
				.viewBtn:hover {
					opacity: 0.7;
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #999;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					opacity: 0.8;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px auto;
				width: 100%;
				text-align: center;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					outline: none;
					background: #009899;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: rgba(255, 255, 255, 1);
					}
					.text {
						color: rgba(255, 255, 255, 1);
						font-size: 16px;
					}
				}
				.submitBtn:hover {
					opacity: 0.7;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn {
					border: 0;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 0px;
					outline: none;
					background: #999;
					width: auto;
					min-width: 100px;
					height: 40px;
					.icon {
						color: #fff;
						font-size: 18px;
					}
					.text {
						color: #fff;
						font-size: 16px;
					}
				}
				.closeBtn:hover {
					opacity: 0.7;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
