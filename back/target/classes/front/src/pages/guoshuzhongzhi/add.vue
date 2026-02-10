

























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
			<el-form-item class="add-item" label="作物名称" prop="zuowumingcheng">
				<el-input v-model="ruleForm.zuowumingcheng" 
					placeholder="作物名称" clearable :readonly="ro.zuowumingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="作物类型" prop="zuowuleixing">
				<el-select  @change="zuowuleixingChange" v-model="ruleForm.zuowuleixing" placeholder="请选择作物类型" :disabled="ro.zuowuleixing" filterable>
					<el-option
						v-for="(item,index) in zuowuleixingOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="周期" prop="zhouqi">
				<el-input v-model="ruleForm.zhouqi" 
					placeholder="周期" clearable :readonly="ro.zhouqi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="作物图片" v-if="type!='cross' || (type=='cross' && !ro.zuowutupian)" prop="zuowutupian">
				<file-upload
					tip="点击上传作物图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:disabled="ro.zuowutupian"
					:fileUrls="ruleForm.zuowutupian?ruleForm.zuowutupian:''"
					@change="zuowutupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="作物图片" prop="zuowutupian">
				<img v-if="ruleForm.zuowutupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.zuowutupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.zuowutupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="种植面积㎡" prop="zhongzhimianji">
				<el-input v-model="ruleForm.zhongzhimianji" 
					placeholder="种植面积㎡" clearable :readonly="ro.zhongzhimianji"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="适宜温度" prop="shiyiwendu">
				<el-input v-model.number="ruleForm.shiyiwendu" 
					placeholder="适宜温度" clearable :readonly="ro.shiyiwendu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="适宜湿度" prop="shiyishidu">
				<el-input v-model.number="ruleForm.shiyishidu" 
					placeholder="适宜湿度" clearable :readonly="ro.shiyishidu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="光照" prop="guangzhao">
				<el-input v-model.number="ruleForm.guangzhao" 
					placeholder="光照" clearable :readonly="ro.guangzhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="种植时间" prop="zhongzhishijian">
				<el-input v-model="ruleForm.zhongzhishijian" 
					placeholder="种植时间" clearable :readonly="ro.zhongzhishijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农户账号" prop="nonghuzhanghao">
				<el-input v-model="ruleForm.nonghuzhanghao" 
					placeholder="农户账号" clearable :readonly="ro.nonghuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="农户姓名" prop="nonghuxingming">
				<el-input v-model="ruleForm.nonghuxingming" 
					placeholder="农户姓名" clearable :readonly="ro.nonghuxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="种植详情" prop="zhongzhixiangqing">
				<editor 
					v-model="ruleForm.zhongzhixiangqing" 
					class="editor" 
					myQuillEditor="zhongzhixiangqing"
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
					dapengmingcheng : false,
					zuowumingcheng : false,
					zuowuleixing : false,
					zhouqi : false,
					zuowutupian : false,
					zhongzhimianji : false,
					shiyiwendu : false,
					shiyishidu : false,
					guangzhao : false,
					zhongzhishijian : false,
					zhongzhixiangqing : false,
					nonghuzhanghao : false,
					nonghuxingming : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					dapengmingcheng: '',
					zuowumingcheng: '',
					zuowuleixing: '',
					zhouqi: '',
					zuowutupian: '',
					zhongzhimianji: '',
					shiyiwendu: '',
					shiyishidu: '',
					guangzhao: '',
					zhongzhishijian: '',
					zhongzhixiangqing: '',
					nonghuzhanghao: '',
					nonghuxingming: '',
				},
				zuowuleixingOptions: [],

				rules: {
					dapengmingcheng: [
					],
					zuowumingcheng: [
					],
					zuowuleixing: [
					],
					zhouqi: [
					],
					zuowutupian: [
					],
					zhongzhimianji: [
						{ required: true, message: '种植面积㎡不能为空', trigger: 'blur' },
					],
					shiyiwendu: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					shiyishidu: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					guangzhao: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					zhongzhishijian: [
					],
					zhongzhixiangqing: [
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
						if(o=='zuowumingcheng'){
							this.ruleForm.zuowumingcheng = obj[o];
							this.ro.zuowumingcheng = true;
							continue;
						}
						if(o=='zuowuleixing'){
							this.ruleForm.zuowuleixing = obj[o];
							this.ro.zuowuleixing = true;
							continue;
						}
						if(o=='zhouqi'){
							this.ruleForm.zhouqi = obj[o];
							this.ro.zhouqi = true;
							continue;
						}
						if(o=='zuowutupian'){
							this.ruleForm.zuowutupian = obj[o]?obj[o].split(",")[0]:'';
							this.ro.zuowutupian = true;
							continue;
						}
						if(o=='zhongzhimianji'){
							this.ruleForm.zhongzhimianji = obj[o];
							this.ro.zhongzhimianji = true;
							continue;
						}
						if(o=='shiyiwendu'){
							this.ruleForm.shiyiwendu = obj[o];
							this.ro.shiyiwendu = true;
							continue;
						}
						if(o=='shiyishidu'){
							this.ruleForm.shiyishidu = obj[o];
							this.ro.shiyishidu = true;
							continue;
						}
						if(o=='guangzhao'){
							this.ruleForm.guangzhao = obj[o];
							this.ro.guangzhao = true;
							continue;
						}
						if(o=='zhongzhishijian'){
							this.ruleForm.zhongzhishijian = obj[o];
							this.ro.zhongzhishijian = true;
							continue;
						}
						if(o=='zhongzhixiangqing'){
							this.ruleForm.zhongzhixiangqing = obj[o];
							this.ro.zhongzhixiangqing = true;
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
				this.$http.get('option/zuowuleixing/zuowuleixing', {}).then(res => {
					if (res.data.code == 0) {
						this.zuowuleixingOptions = res.data.data;
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},
			// 下二随
			zuowuleixingChange () {
				this.$http.get('follow/zuowuleixing/zuowuleixing?columnValue=' + this.ruleForm.zuowuleixing, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						if(res.data.data.zhouqi){
							this.ruleForm.zhouqi = res.data.data.zhouqi
						}
					}
				});
			},

			// 多级联动参数
			// 多级联动参数
			async info() {
				await this.$http.get(`guoshuzhongzhi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
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

						await this.$http.post(`guoshuzhongzhi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
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
			zuowutupianUploadChange(fileUrls) {
				this.ruleForm.zuowutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
