























<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="大棚名称" prop="dapengmingcheng" >
					<el-input v-model="ruleForm.dapengmingcheng" placeholder="大棚名称" clearable  :readonly="ro.dapengmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="大棚名称" prop="dapengmingcheng" >
					<el-input v-model="ruleForm.dapengmingcheng" placeholder="大棚名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="作物名称" prop="zuowumingcheng" >
					<el-input v-model="ruleForm.zuowumingcheng" placeholder="作物名称" clearable  :readonly="ro.zuowumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="作物名称" prop="zuowumingcheng" >
					<el-input v-model="ruleForm.zuowumingcheng" placeholder="作物名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="作物类型" prop="zuowuleixing" >
					<el-input v-model="ruleForm.zuowuleixing" placeholder="作物类型" clearable  :readonly="ro.zuowuleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="作物类型" prop="zuowuleixing" >
					<el-input v-model="ruleForm.zuowuleixing" placeholder="作物类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="周期" prop="zhouqi" >
					<el-input v-model="ruleForm.zhouqi" placeholder="周期" clearable  :readonly="ro.zhouqi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="周期" prop="zhouqi" >
					<el-input v-model="ruleForm.zhouqi" placeholder="周期" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.zuowutupian" label="作物图片" prop="zuowutupian" >
					<file-upload
						tip="点击上传作物图片"
						action="file/upload"
						:limit="3"
						:disabled="ro.zuowutupian"
						:multiple="true"
						:fileUrls="ruleForm.zuowutupian?ruleForm.zuowutupian:''"
						@change="zuowutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.zuowutupian" label="作物图片" prop="zuowutupian" >
					<img v-if="ruleForm.zuowutupian.substring(0,4)=='http'&&ruleForm.zuowutupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.zuowutupian" width="100" height="100" @click="imgPreView(ruleForm.tupian)">
					<img v-else-if="ruleForm.zuowutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.zuowutupian.split(',')[0]" width="100" height="100" @click="imgPreView(ruleForm.tupian.split(',')[0])">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.zuowutupian.split(',')" :src="$base.url+item" width="100" height="100" @click="imgPreView($base.url+item)">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="种植面积㎡" prop="zhongzhimianji" >
					<el-input v-model="ruleForm.zhongzhimianji" placeholder="种植面积㎡" clearable  :readonly="ro.zhongzhimianji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="种植面积㎡" prop="zhongzhimianji" >
					<el-input v-model="ruleForm.zhongzhimianji" placeholder="种植面积㎡" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="记录时间" prop="jilushijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.jilushijian" 
						type="date"
						:readonly="ro.jilushijian"
						placeholder="记录时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jilushijian" label="记录时间" prop="jilushijian" >
					<el-input v-model="ruleForm.jilushijian" placeholder="记录时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="生长阶段" prop="shengzhangjieduan" >
					<el-select :disabled="ro.shengzhangjieduan" v-model="ruleForm.shengzhangjieduan" placeholder="请选择生长阶段"  filterable>
						<el-option
							v-for="(item,index) in shengzhangjieduanOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="生长阶段" prop="shengzhangjieduan" >
					<el-input v-model="ruleForm.shengzhangjieduan"
						placeholder="生长阶段" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="叶片数量" prop="yepianshuliang" >
					<el-input v-model="ruleForm.yepianshuliang" placeholder="叶片数量" clearable  :readonly="ro.yepianshuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="叶片数量" prop="yepianshuliang" >
					<el-input v-model="ruleForm.yepianshuliang" placeholder="叶片数量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="作物高度" prop="zuowugaodu" >
					<el-input v-model="ruleForm.zuowugaodu" placeholder="作物高度" clearable  :readonly="ro.zuowugaodu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="作物高度" prop="zuowugaodu" >
					<el-input v-model="ruleForm.zuowugaodu" placeholder="作物高度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农户账号" prop="nonghuzhanghao" >
					<el-input v-model="ruleForm.nonghuzhanghao" placeholder="农户账号" clearable  :readonly="ro.nonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农户账号" prop="nonghuzhanghao" >
					<el-input v-model="ruleForm.nonghuzhanghao" placeholder="农户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农户姓名" prop="nonghuxingming" >
					<el-input v-model="ruleForm.nonghuxingming" placeholder="农户姓名" clearable  :readonly="ro.nonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农户姓名" prop="nonghuxingming" >
					<el-input v-model="ruleForm.nonghuxingming" placeholder="农户姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-queren15"></span>
					确定 
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-guanbi2"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui13"></span>
					返回
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
				type: '',
			
			
				ro:{
					dapengmingcheng : false,
					zuowumingcheng : false,
					zuowuleixing : false,
					zhouqi : false,
					zuowutupian : false,
					zhongzhimianji : false,
					jilushijian : false,
					shengzhangjieduan : false,
					yepianshuliang : false,
					zuowugaodu : false,
					nonghuzhanghao : false,
					nonghuxingming : false,
				},
			
				ruleForm: {
					dapengmingcheng: '',
					zuowumingcheng: '',
					zuowuleixing: '',
					zhouqi: '',
					zuowutupian: '',
					zhongzhimianji: '',
					jilushijian: '',
					shengzhangjieduan: '',
					yepianshuliang: '',
					zuowugaodu: '',
					nonghuzhanghao: '',
					nonghuxingming: '',
				},
				shengzhangjieduanOptions: [],

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
					],
					jilushijian: [
					],
					shengzhangjieduan: [
					],
					yepianshuliang: [
					],
					zuowugaodu: [
					],
					nonghuzhanghao: [
					],
					nonghuxingming: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			sessionForm() {
				return JSON.parse(this.$storage.getObj('userForm'))
			},
			sessionTable() {
				return this.$storage.get('sessionTable')
			},



		},
		components: {
		},
		created() {
			this.ruleForm.jilushijian = this.getCurDate()
		},
		methods: {
			imgPreView(url){
				this.$parent.imgPreView(url)
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type ) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.zuowutupian = obj[o];
							this.ro.zuowutupian = true;
							continue;
						}
						if(o=='zhongzhimianji'){
							this.ruleForm.zhongzhimianji = obj[o];
							this.ro.zhongzhimianji = true;
							continue;
						}
						if(o=='jilushijian'){
							this.ruleForm.jilushijian = obj[o];
							this.ro.jilushijian = true;
							continue;
						}
						if(o=='shengzhangjieduan'){
							this.ruleForm.shengzhangjieduan = obj[o];
							this.ro.shengzhangjieduan = true;
							continue;
						}
						if(o=='yepianshuliang'){
							this.ruleForm.yepianshuliang = obj[o];
							this.ro.yepianshuliang = true;
							continue;
						}
						if(o=='zuowugaodu'){
							this.ruleForm.zuowugaodu = obj[o];
							this.ro.zuowugaodu = true;
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
				}
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.nonghuzhanghao!=''&&json.nonghuzhanghao) || json.nonghuzhanghao==0) && this.sessionTable!="users"){
							this.ruleForm.nonghuzhanghao = json.nonghuzhanghao
							this.ro.nonghuzhanghao = true;
						}
						if(((json.nonghuxingming!=''&&json.nonghuxingming) || json.nonghuxingming==0) && this.sessionTable!="users"){
							this.ruleForm.nonghuxingming = json.nonghuxingming
							this.ro.nonghuxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.shengzhangjieduanOptions = "苗期,生长期,开花期,结果期".split(',')
			
			},
			// 多级联动参数

			async info(id) {
				await this.$http({
					url: `guoshushengzhang/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.zuowutupian!=null) {
						this.ruleForm.zuowutupian = this.ruleForm.zuowutupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							await this.$http({
								url: `guoshushengzhang/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.guoshushengzhangCrossAddOrUpdateFlag = false;
											this.parent.search();
										}
									});
								} else {
									this.$message.error(data.msg);
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
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.guoshushengzhangCrossAddOrUpdateFlag = false;
			},
			zuowutupianUploadChange(fileUrls) {
				this.ruleForm.zuowutupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		border: 0px solid #ddd;
		border-radius: 8px;
		padding: 50px 30px;
		box-shadow: none;
		background: #ffffff;
		display: flex;
		flex-wrap: wrap;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 50%;
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
	.add-update-preview /deep/ .el-form-item.editorBox {
		margin: 0 20px 20px;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 600;
		display: block;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		padding: 0;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor {
		border-radius: 8px;
		box-shadow:  inset 0px 3px 6px 1px rgba(0,0,0,0.16);
		background: #fff;
		display: flex;
		width: 100%;
		border-width: 0;
		flex-wrap: wrap;
		height: auto;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-toolbar {
		border: 0px solid #555555;
		background: none;
		width: 100%;
		border-width: 0;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container {
		border: 0px solid #555555;
		background: none;
		width: 100%;
		min-height: 200px;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container .ql-blank::before {
		color: #999;
	}
	
	.add-update-preview /deep/ .el-form-item.textBox {
		margin: 0 20px 20px;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		padding: 0;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview /deep/.el-form-item.textBox span.text {
		border-radius: 4px;
		padding: 0 12px;
		box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
		outline: none;
		color: #333;
		display: block;
		width: 100%;
		font-size: 16px;
		border-width: 0;
		height: auto;
	}
	
	.add-update-preview .el-input {
		width: 100%;
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
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
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
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
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
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
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
	.add-update-preview .el-date-editor {
		width: 100%;
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
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
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
	.add-update-preview .viewBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #10C17C;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #10C17C;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #10C17C;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
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
	
	.add-update-preview /deep/ .upload .upload-img {
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
	.add-update-preview /deep/ .el-upload__tip {
		padding: 0 10px;
		color: #000000;
		font-size: 15px;
	}
	.add-update-preview /deep/ .el-form-item.fileupload {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 50%;
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-upload-dragger {
		border-radius: 4px;
		box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
		outline: none;
		color: #333;
		display: flex;
		width: 100%;
		font-size: 16px;
		align-items: center;
		flex-wrap: wrap;
		height: 100px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-icon-upload {
		margin: 0;
		color: #206cb480;
		width: 100%;
		font-size: 66px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text {
		color: #606266;
		textalign: center;
		width: 100%;
		fontsize: 14px;
		line-height: 1;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text em {
		fontstyle: normal;
		color: #409EFF;
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
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
		border: 0px solid #555555;
		cursor: not-allowed;
		border-radius: 0;
		padding: 12px;
		box-shadow:  inset 0px 3px 6px 1px rgba(0,0,0,0.16);
		outline: none;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: auto;
	}
	.add-update-preview /deep/ .el-form-item.btn {
		padding: 0 30px;
		margin: 30px  auto 0 auto;
		background: none;
		display: flex;
		width: auto;
		justify-content: center;
		flex-wrap: wrap;
		.btn1 {
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
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
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
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
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
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #000000;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #FAFAFA;
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
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #000000;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #FAFAFA;
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
		.btn5:hover {
			opacity: 0.8;
		}
	}
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
</style>
