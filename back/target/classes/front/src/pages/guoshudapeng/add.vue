



























<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
			>
			<el-form-item class="add-item" label="大棚编号" prop="dapengbianhao">
				<el-input v-model="ruleForm.dapengbianhao" 
					placeholder="大棚编号" clearable :readonly="ro.dapengbianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="大棚名称" prop="dapengmingcheng">
				<el-input v-model="ruleForm.dapengmingcheng" 
					placeholder="大棚名称" clearable :readonly="ro.dapengmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="大棚图片" v-if="type!='cross' || (type=='cross' && !ro.dapengtupian)" prop="dapengtupian">
				<file-upload
					tip="点击上传大棚图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:disabled="ro.dapengtupian"
					:fileUrls="ruleForm.dapengtupian?ruleForm.dapengtupian:''"
					@change="dapengtupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="大棚图片" prop="dapengtupian">
				<img v-if="ruleForm.dapengtupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.dapengtupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.dapengtupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item"  label="大棚类型" prop="dapengleixing">
				<el-select v-model="ruleForm.dapengleixing" placeholder="请选择大棚类型" :disabled="ro.dapengleixing"  filterable>
					<el-option
						v-for="(item,index) in dapengleixingOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="规格" prop="guige">
				<el-input v-model="ruleForm.guige" 
					placeholder="规格" clearable :readonly="ro.guige"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="特点" prop="tedian">
				<el-input v-model="ruleForm.tedian" 
					placeholder="特点" clearable :readonly="ro.tedian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="面积" prop="mianji">
				<el-input v-model="ruleForm.mianji" 
					placeholder="面积" clearable :readonly="ro.mianji"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="温度" prop="wendu">
				<el-input v-model.number="ruleForm.wendu" 
					placeholder="温度" clearable :readonly="ro.wendu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="湿度" prop="shidu">
				<el-input v-model.number="ruleForm.shidu" 
					placeholder="湿度" clearable :readonly="ro.shidu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="光照" prop="guangzhao">
				<el-input v-model.number="ruleForm.guangzhao" 
					placeholder="光照" clearable :readonly="ro.guangzhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="创建时间" prop="chuangjianshijian">
				<el-date-picker
					:disabled="ro.chuangjianshijian"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.chuangjianshijian" 
					type="date"
					placeholder="创建时间">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="信用代码" prop="xinyongdaima">
				<el-input v-model="ruleForm.xinyongdaima" 
					placeholder="信用代码" clearable :readonly="ro.xinyongdaima"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="合作社名称" prop="hezuoshemingcheng">
				<el-input v-model="ruleForm.hezuoshemingcheng" 
					placeholder="合作社名称" clearable :readonly="ro.hezuoshemingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备设施" prop="shebeisheshi">
				<editor 
					v-model="ruleForm.shebeisheshi" 
					class="editor" 
					myQuillEditor="shebeisheshi"
					action="file/upload">
				</editor>
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
					dapengbianhao : false,
					dapengmingcheng : false,
					dapengtupian : false,
					dapengleixing : false,
					guige : false,
					tedian : false,
					mianji : false,
					wendu : false,
					shidu : false,
					guangzhao : false,
					chuangjianshijian : false,
					shebeisheshi : false,
					xinyongdaima : false,
					hezuoshemingcheng : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					dapengbianhao: '',
					dapengmingcheng: '',
					dapengtupian: '',
					dapengleixing: '',
					guige: '',
					tedian: '',
					mianji: '',
					wendu: '',
					shidu: '',
					guangzhao: '',
					chuangjianshijian: '',
					shebeisheshi: '',
					xinyongdaima: '',
					hezuoshemingcheng: '',
				},
				dapengleixingOptions: [],

				rules: {
					dapengbianhao: [
						{ required: true, message: '大棚编号不能为空', trigger: 'blur' },
					],
					dapengmingcheng: [
						{ required: true, message: '大棚名称不能为空', trigger: 'blur' },
					],
					dapengtupian: [
						{ required: true, message: '大棚图片不能为空', trigger: 'blur' },
					],
					dapengleixing: [
					],
					guige: [
					],
					tedian: [
					],
					mianji: [
					],
					wendu: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					shidu: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					guangzhao: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					chuangjianshijian: [
					],
					shebeisheshi: [
					],
					xinyongdaima: [
					],
					hezuoshemingcheng: [
					],
				},
				centerType: false,
			};
		},
		computed: {
			sessionForm() {
				return JSON.parse(localStorage.getItem('sessionForm'))
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
			this.ruleForm.chuangjianshijian = this.getCurDate()
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
						if(o=='dapengbianhao'){
							this.ruleForm.dapengbianhao = obj[o];
							this.ro.dapengbianhao = true;
							continue;
						}
						if(o=='dapengmingcheng'){
							this.ruleForm.dapengmingcheng = obj[o];
							this.ro.dapengmingcheng = true;
							continue;
						}
						if(o=='dapengtupian'){
							this.ruleForm.dapengtupian = obj[o]?obj[o].split(",")[0]:'';
							this.ro.dapengtupian = true;
							continue;
						}
						if(o=='dapengleixing'){
							this.ruleForm.dapengleixing = obj[o];
							this.ro.dapengleixing = true;
							continue;
						}
						if(o=='guige'){
							this.ruleForm.guige = obj[o];
							this.ro.guige = true;
							continue;
						}
						if(o=='tedian'){
							this.ruleForm.tedian = obj[o];
							this.ro.tedian = true;
							continue;
						}
						if(o=='mianji'){
							this.ruleForm.mianji = obj[o];
							this.ro.mianji = true;
							continue;
						}
						if(o=='wendu'){
							this.ruleForm.wendu = obj[o];
							this.ro.wendu = true;
							continue;
						}
						if(o=='shidu'){
							this.ruleForm.shidu = obj[o];
							this.ro.shidu = true;
							continue;
						}
						if(o=='guangzhao'){
							this.ruleForm.guangzhao = obj[o];
							this.ro.guangzhao = true;
							continue;
						}
						if(o=='chuangjianshijian'){
							this.ruleForm.chuangjianshijian = obj[o];
							this.ro.chuangjianshijian = true;
							continue;
						}
						if(o=='shebeisheshi'){
							this.ruleForm.shebeisheshi = obj[o];
							this.ro.shebeisheshi = true;
							continue;
						}
						if(o=='xinyongdaima'){
							this.ruleForm.xinyongdaima = obj[o];
							this.ro.xinyongdaima = true;
							continue;
						}
						if(o=='hezuoshemingcheng'){
							this.ruleForm.hezuoshemingcheng = obj[o];
							this.ro.hezuoshemingcheng = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.xinyongdaima!=''&&json.xinyongdaima) || json.xinyongdaima==0){
							this.ruleForm.xinyongdaima = json.xinyongdaima;
							this.ro.xinyongdaima = true;
						}
						if((json.hezuoshemingcheng!=''&&json.hezuoshemingcheng) || json.hezuoshemingcheng==0){
							this.ruleForm.hezuoshemingcheng = json.hezuoshemingcheng;
							this.ro.hezuoshemingcheng = true;
						}
					}
				});
				this.dapengleixingOptions = "日光温室,塑料大棚,玻璃温室,连栋温室".split(',')

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
				await this.$http.get(`guoshudapeng/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
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
						}

						await this.$http.post(`guoshudapeng/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
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
			dapengtupianUploadChange(fileUrls) {
				this.ruleForm.dapengtupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
