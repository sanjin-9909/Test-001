



























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
				<el-form-item class="input" v-if="type!='info'"  label="大棚编号" prop="dapengbianhao" >
					<el-input v-model="ruleForm.dapengbianhao" placeholder="大棚编号" clearable  :readonly="ro.dapengbianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="大棚编号" prop="dapengbianhao" >
					<el-input v-model="ruleForm.dapengbianhao" placeholder="大棚编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="大棚名称" prop="dapengmingcheng" >
					<el-input v-model="ruleForm.dapengmingcheng" placeholder="大棚名称" clearable  :readonly="ro.dapengmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="大棚名称" prop="dapengmingcheng" >
					<el-input v-model="ruleForm.dapengmingcheng" placeholder="大棚名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.dapengtupian" label="大棚图片" prop="dapengtupian" >
					<file-upload
						tip="点击上传大棚图片"
						action="file/upload"
						:limit="3"
						:disabled="ro.dapengtupian"
						:multiple="true"
						:fileUrls="ruleForm.dapengtupian?ruleForm.dapengtupian:''"
						@change="dapengtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.dapengtupian" label="大棚图片" prop="dapengtupian" >
					<img v-if="ruleForm.dapengtupian.substring(0,4)=='http'&&ruleForm.dapengtupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dapengtupian" width="100" height="100" @click="imgPreView(ruleForm.tupian)">
					<img v-else-if="ruleForm.dapengtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dapengtupian.split(',')[0]" width="100" height="100" @click="imgPreView(ruleForm.tupian.split(',')[0])">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.dapengtupian.split(',')" :src="$base.url+item" width="100" height="100" @click="imgPreView($base.url+item)">
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="大棚类型" prop="dapengleixing" >
					<el-select :disabled="ro.dapengleixing" v-model="ruleForm.dapengleixing" placeholder="请选择大棚类型"  filterable>
						<el-option
							v-for="(item,index) in dapengleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="大棚类型" prop="dapengleixing" >
					<el-input v-model="ruleForm.dapengleixing"
						placeholder="大棚类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="规格" prop="guige" >
					<el-input v-model="ruleForm.guige" placeholder="规格" clearable  :readonly="ro.guige"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="规格" prop="guige" >
					<el-input v-model="ruleForm.guige" placeholder="规格" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="特点" prop="tedian" >
					<el-input v-model="ruleForm.tedian" placeholder="特点" clearable  :readonly="ro.tedian"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="特点" prop="tedian" >
					<el-input v-model="ruleForm.tedian" placeholder="特点" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="面积" prop="mianji" >
					<el-input v-model="ruleForm.mianji" placeholder="面积" clearable  :readonly="ro.mianji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="面积" prop="mianji" >
					<el-input v-model="ruleForm.mianji" placeholder="面积" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="温度" prop="wendu" >
					<el-input v-model.number="ruleForm.wendu" placeholder="温度" clearable  :readonly="ro.wendu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="温度" prop="wendu" >
					<el-input v-model="ruleForm.wendu" placeholder="温度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="湿度" prop="shidu" >
					<el-input v-model.number="ruleForm.shidu" placeholder="湿度" clearable  :readonly="ro.shidu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="湿度" prop="shidu" >
					<el-input v-model="ruleForm.shidu" placeholder="湿度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="光照" prop="guangzhao" >
					<el-input v-model.number="ruleForm.guangzhao" placeholder="光照" clearable  :readonly="ro.guangzhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="光照" prop="guangzhao" >
					<el-input v-model="ruleForm.guangzhao" placeholder="光照" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="创建时间" prop="chuangjianshijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.chuangjianshijian" 
						type="date"
						:readonly="ro.chuangjianshijian"
						placeholder="创建时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.chuangjianshijian" label="创建时间" prop="chuangjianshijian" >
					<el-input v-model="ruleForm.chuangjianshijian" placeholder="创建时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用代码" prop="xinyongdaima" >
					<el-input v-model="ruleForm.xinyongdaima" placeholder="信用代码" clearable  :readonly="ro.xinyongdaima"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="信用代码" prop="xinyongdaima" >
					<el-input v-model="ruleForm.xinyongdaima" placeholder="信用代码" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="合作社名称" prop="hezuoshemingcheng" >
					<el-input v-model="ruleForm.hezuoshemingcheng" placeholder="合作社名称" clearable  :readonly="ro.hezuoshemingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="合作社名称" prop="hezuoshemingcheng" >
					<el-input v-model="ruleForm.hezuoshemingcheng" placeholder="合作社名称" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'" class="editorBox" label="设备设施" prop="shebeisheshi" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.shebeisheshi" 
					class="editor"
					myQuillEditor="shebeisheshi"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shebeisheshi" label="设备设施" prop="shebeisheshi"  class="textBox">
				<span class="text ql-snow ql-editor" v-html="ruleForm.shebeisheshi"></span>
			</el-form-item>
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
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
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
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					shidu: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					guangzhao: [
						{ validator: validateIntNumber, trigger: 'blur' },
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
			this.ruleForm.chuangjianshijian = this.getCurDate()
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
							this.ruleForm.dapengtupian = obj[o];
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
				}
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.xinyongdaima!=''&&json.xinyongdaima) || json.xinyongdaima==0) && this.sessionTable!="users"){
							this.ruleForm.xinyongdaima = json.xinyongdaima
							this.ro.xinyongdaima = true;
						}
						if(((json.hezuoshemingcheng!=''&&json.hezuoshemingcheng) || json.hezuoshemingcheng==0) && this.sessionTable!="users"){
							this.ruleForm.hezuoshemingcheng = json.hezuoshemingcheng
							this.ro.hezuoshemingcheng = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.dapengleixingOptions = "日光温室,塑料大棚,玻璃温室,连栋温室".split(',')
			
			},
			// 多级联动参数

			async info(id) {
				await this.$http({
					url: `guoshudapeng/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.shebeisheshi = this.ruleForm.shebeisheshi.replace(reg,'../../../springboot584f4022/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.dapengtupian!=null) {
						this.ruleForm.dapengtupian = this.ruleForm.dapengtupian.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `guoshudapeng/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.guoshudapengCrossAddOrUpdateFlag = false;
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
				this.parent.guoshudapengCrossAddOrUpdateFlag = false;
			},
			dapengtupianUploadChange(fileUrls) {
				this.ruleForm.dapengtupian = fileUrls;
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
