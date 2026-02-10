<template>
	<div class="forumdetail-preview">
		<div class="forumdetail-title">
			<div>互动交流</div>
		</div>
		<div class="back_box">
			<el-button class="backBtn" size="mini" @click="backClick">
				<span class="icon iconfont icon-jiantou33"></span>
				<span class="text">返回</span>
			</el-button>
		</div>

		<el-carousel class="forumdetail-carousel" v-if="detailBanner.length" trigger="click" indicator-position="inside" arrow="hover" type="default" direction="horizontal" height="400px" :autoplay="false" :interval="3000" :loop="true">
			<el-carousel-item v-for="item in detailBanner" :key="item.id">
				<img :preview-src-list="[item]" v-if="item.substr(0,4)=='http'" :src="item" class="image">
				<img :preview-src-list="[baseUrl + item]" v-else :src="baseUrl + item" class="image">
			</el-carousel-item>
		</el-carousel>
		<div class="section-content">
			<div class="content-title">{{detail.title}}</div>
			<div class="subhead-box">
				<div class="time_item" v-if="detail.addtime">
					<span class="icon iconfont icon-shijian21"></span>
					<span class="label">发布时间：</span>
					<span class="text">{{detail.addtime.split(' ')[0]}}</span>
				</div>
				<div class="publisher_item">
					<span class="icon iconfont icon-geren16"></span>
					<span class="label">发布人：</span>
					<span class="text">{{detail.isanon==1&&detail.userid!=userid?'匿名':detail.username}}</span>
				</div>
			</div>
			<div class="content-detail ql-snow ql-editor" v-html="detail.content"></div>
			<div class="comment-box">
				<div class="comment-top-box">
					<div class="comment-title">评论列表</div>
					<el-button class="pubAdd" type="primary" @click="addComment">
						<span class="icon iconfont icon-tianjia7"></span>
						<span class="text">点击评论</span>
					</el-button>
				</div>
				<div class="comment-list">
					<template v-if="commentList && commentList.length">
						<div  class="comment-item" v-for="item in commentList" :key="item.id" @mouseenter="commentEnter(item.id)" @mouseleave="commentLeave">
							<div class="comment-user">
								<img v-if="item.avatarurl" :src="baseUrl + item.avatarurl">
								<img v-if="!item.avatarurl" :src="require('@/assets/touxiang.png')">
								<div class="name">用户：{{item.username}}</div>
							</div>
							<div class="comment-content ql-snow ql-editor" v-html="item.content"></div>
							<div class="comment-btn">
								<el-button class="replyBtn" v-if="showIndex==item.id&&showIndex1 == -1" @click="replyClick(item.id)">回复</el-button>
								<el-button class="delBtn" v-if="showIndex==item.id&&userid==item.userid&&showIndex1 == -1" @click="commentDel(item.id)">删除</el-button>
							</div>
							
							<template v-if="item.childs && item.childs.length">
								<div class="comment">
									<div class="item" v-for="items in item.childs" :key="items.id" @mouseenter="commentEnter1(items.id)" @mouseleave="commentLeave1">
										<div class="user">
											<img v-if="items.avatarurl" :src="baseUrl + items.avatarurl">
											<img v-if="!items.avatarurl" :src="require('@/assets/touxiang.png')">
											<div class="name">用户：{{items.username}}</div>
										</div>
										<div class="reply ql-snow ql-editor" v-html="items.content"></div>
										<div class="reply-btn">
											<el-button class="delBtn" v-if="showIndex==item.id&&userid==items.userid&&showIndex1==items.id" @click="commentDel(items.id)">删除</el-button>
										</div>
									</div>
								</div>
							</template>
						</div>
					</template>
				</div>
			</div>
		</div>
		<el-dialog title="添加评论" :visible.sync="dialogFormVisible">
			<el-form :model="form" :rules="rules" ref="form">
				<el-form-item label="评论" label-width="60px" prop="content">
					<editor
						myQuillEditor="content"
						style="width: 100%"
						v-model="form.content" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addForum('form')">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import Swiper from "swiper";
	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				id: '',
				detail: {},
				commentList: [],
				dialogFormVisible: false,
				detailBanner: [],
				form: {
					content: '',
					parentid: '',
					userid: Number(localStorage.getItem('frontUserid')),
					username: localStorage.getItem('username'),
					avatarurl: '',
				},
				userid: Number(localStorage.getItem('frontUserid')),
				editorOption: {
					modules: {
						toolbar: [
							["bold", "italic", "underline", "strike"],
							["blockquote", "code-block"],
							[{ header: 1 }, { header: 2 }],
							[{ list: "ordered" }, { list: "bullet" }],
							[{ script: "sub" }, { script: "super" }],
							[{ indent: "-1" }, { indent: "+1" }],
							[{ direction: "rtl" }],
							[{ size: ["small", false, "large", "huge"] }],
							[{ header: [1, 2, 3, 4, 5, 6, false] }],
							[{ color: [] }, { background: [] }],
							[{ font: [] }],
							[{ align: [] }],
							["clean"],
							["image", "video"]
						]
					}
				},
				rules: {
					content: [
						{ required: true, message: '请输入评论', trigger: 'blur' }
					]
				},
				showIndex: -1,
				showIndex1: -1,
			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.id = this.$route.query.id
			this.getDetail()
		},
		mounted() {
		},
		//方法集合
		methods: {
			// 返回按钮
			backClick(){
				history.back()
			},
			onEditorReady(editor) {
				editor.root.setAttribute('data-placeholder', "请输入内容...");
			},
			getDetail() {
				this.$http.get(`forum/list/${this.id}`).then(res => {
					if (res.data.code == 0) {
						this.detailBanner = res.data.data.cover ? res.data.data.cover.split(",") : [];
						res.data.data.content = res.data.data.content.replace(/img src/gi,"img style=\"width:100%;\" src");
						this.detail = res.data.data
						this.commentList = res.data.data.childs;
					}
				});
			},
			// 新增评论
			addComment(){
				this.form.parentid = this.detail.id
				this.dialogFormVisible = true
			},
			// 鼠标移入
			commentEnter(index){
				this.showIndex = index
			},
			// 鼠标移出
			commentLeave(){
				this.showIndex = -1
			},
			// 二级评论鼠标移入
			commentEnter1(index){
				this.showIndex1 = index
			},
			// 二级评论鼠标移出
			commentLeave1(){
				this.showIndex1 = -1
			},
			// 删除评论
			commentDel(id){
				this.$confirm('是否删除此评论？')
				  .then(_ => {
					this.$http.post('forum/delete',[id]).then(res=>{
					  if(res.data&&res.data.code==0){
						  this.$message({
							type: 'success',
							message: '删除成功!',
							duration: 1500,
							onClose: () => {
								this.getDetail();
							}
						  });
					  }
				  })
			  }).catch(_ => {});
			},
			// 回复评论
			replyClick(id){
				this.form.parentid = id
				this.dialogFormVisible = true
			},
			addForum(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
						this.$http.post('forum/add', this.form).then(res => {
							if (res.data.code == 0) {
								this.$message({
									type: 'success',
									message: '评论成功!',
									duration: 1500,
									onClose: () => {
										this.form.content = '';
										this.getDetail();
										this.dialogFormVisible = false;
									}
								});
							}
						});
					} else {
						return false;
					}
				});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.forumdetail-preview {
				padding: 30px calc((100% - 1200px)/2);
				margin: 0px auto;
				background: rgb(245, 245, 245);
				width: 100%;
				position: relative;
				.forumdetail-title {
						width: 100%;
						div {
								padding: 0 0 0 10px;
								color: #333;
								width: 100%;
								font-size: 16px;
								border-color: #1d8f7a;
								border-width: 0 0 0 4px;
								border-style: solid;
								height: auto;
							}
		}
		.el-carousel.forumdetail-carousel {
			padding: 10px 0 0;
			margin: 10px 0 0;
			overflow: hidden;
			background: rgba(255,255,255,1);
			width: 100%;
			height: 400px;
			/deep/ .el-carousel__indicator button {
				width: 0;
				height: 0;
				display: none;
			}
			/deep/ .el-carousel__container {
				.el-carousel__arrow--left {
					display: block;
					width: 36px;
					font-size: 12px;
					height: 36px;
				}
				.el-carousel__arrow--left:hover {
					background: #009899;
				}
				.el-carousel__arrow--right {
					display: block;
					width: 36px;
					font-size: 12px;
					height: 36px;
				}
				.el-carousel__arrow--right:hover {
					background: #009899;
				}
				.el-carousel__item {
					border-radius: 10px;
					width: 100%;
					height: 100%;
					img {
						object-fit: contain;
						width: 100%;
						height: 100%;
					}
				}
			}
		
			/deep/ .el-carousel__indicators {
				padding: 0;
				margin: 0 0 10px;
				z-index: 2;
				position: absolute;
				list-style: none;
				li {
					padding: 0;
					margin: 0 4px;
					background: #fff;
					display: inline-block;
					width: 12px;
					opacity: 0.4;
					transition: 0.3s;
					height: 12px;
				}
				li:hover {
					padding: 0;
					margin: 0 4px;
					background: #fff;
					display: inline-block;
					width: 12px;
					opacity: 0.7;
					height: 12px;
				}
				li.is-active {
					padding: 0;
					margin: 0 4px;
					background: #fff;
					display: inline-block;
					width: 12px;
					opacity: 1;
					height: 12px;
				}
			}
		}
		.section-content {
						padding: 0px 0 0;
						margin: 0px auto;
						background: none;
						width: 100%;
						position: relative;
						.content-title {
								padding: 20px 10px 0;
								color: #333;
								background: #fff;
								font-weight: 600;
								width: 100%;
								font-size: 22px;
								line-height: 50px;
								text-align: center;
								height: auto;
							}
			.subhead-box {
								color: #999;
								background: #fff;
								display: flex;
								width: 100%;
								font-size: 14px;
								justify-content: center;
								align-items: center;
								.time_item {
										padding: 0 10px;
										.icon {
												margin: 0 2px 0 0;
												line-height: 1.5;
											}
					.label {
												line-height: 1.5;
											}
					.text {
												line-height: 1.5;
											}
				}
				.publisher_item {
										padding: 0 10px;
										.icon {
												margin: 0 2px 0 0;
												line-height: 1.5;
											}
					.label {
												line-height: 1.5;
											}
					.text {
												line-height: 1.5;
											}
				}
			}
			.content-detail {
								padding: 20px;
								color: #666;
								background: #fff;
								font-size: 16px;
								line-height: 1.8;
							}
			.comment-box {
								padding: 0;
								box-shadow: none;
								margin: 0px 0 0;
								background: none;
								width: 100%;
								.comment-top-box {
										padding: 10px;
										color: #333;
										background: rgba(255,255,255,1);
										display: flex;
										width: 100%;
										font-size: 26px;
										border-color: #ddd;
										border-width: 0px;
										line-height: 1.5;
										justify-content: flex-end;
										align-items: center;
										border-style: solid;
										.comment-title {
												padding: 0 0 0 10px;
												color: #333;
												flex: 1;
												font-weight: 600;
												font-size: 16px;
											}
					.pubAdd {
												cursor: pointer;
												border: 1px solid rgba(29, 143, 122,.3);
												border-radius: 4px;
												padding: 0px 15px;
												margin: 0 10px 5px 0;
												outline: none;
												color: #fff;
												background: rgba(29, 143, 122,.1);
												width: auto;
												font-size: 14px;
												line-height: 36px;
												height: 36px;
												.icon {
														margin: 0 4px 0 0;
														color: rgba(29, 143, 122,1);
														font-size: 14px;
													}
						.text {
														color: rgba(29, 143, 122,1);
														font-size: 15px;
													}
					}
					.pubAdd:hover {
												opacity: 0.8;
												.icon {
														opacity: 0.8;
													}
						.text {
														opacity: 0.8;
													}
					}
				}
				.comment-list {
										padding: 0 10px 10px;
										margin: 0px 0 0;
										background: #fff;
										width: 100%;
										.comment-item {
												border: 1px solid #eee;
												padding: 0;
												margin: 0 0 20px;
												color: #666;
												background: #fff;
												width: 100%;
												align-items: center;
												height: auto;
												.comment-user {
														padding: 10px;
														background: none;
														display: flex;
														width: 100%;
														border-color: #ddd;
														border-width: 0px 0;
														align-items: center;
														border-style: solid;
														height: auto;
														img {
																border-radius: 100%;
																margin: 0 10px 0 0;
																object-fit: cover;
																width: 40px;
																height: 40px;
															}
							.name {
																color: #333;
																font-size: 16px;
															}
						}
						.comment-content {
														border-radius: 4px;
														padding: 0 10px;
														box-shadow: none;
														margin: 0px 0px 0px;
														color: #666;
														background: none;
														font-size: 15px;
														line-height: 30px;
													}
						.comment-btn {
														margin: 0;
														display: flex;
														width: 100%;
														justify-content: flex-end;
														align-items: center;
														height: auto;
														.replyBtn {
																border: 0;
																cursor: pointer;
																border-radius: 4px;
																padding: 0 20px;
																margin: 0 10px;
																outline: none;
																color: rgba(255, 255, 255, 1);
																background: #009899;
																width: auto;
																font-size: 14px;
																line-height: 36px;
																height: 36px;
															}
							.delBtn {
																border: 0;
																cursor: pointer;
																border-radius: 4px;
																padding: 0 20px;
																margin: 0 10px;
																outline: none;
																color: rgba(255, 255, 255, 1);
																background: rgba(255, 0, 0, 1);
																width: auto;
																font-size: 14px;
																line-height: 36px;
																height: 36px;
															}
						}
						.comment {
														padding: 0 0 0 40px;
														width: 100%;
														.item {
																padding: 8px 0;
																margin: 20px 0 0 0;
																color: #666;
																background: #fff;
																width: 100%;
																border-color: #eee;
																border-width: 1px 0 0 0;
																align-items: center;
																border-style: solid;
																height: auto;
																.user {
																		border: none;
																		padding: 2px 10px;
																		background: none;
																		display: flex;
																		width: 100%;
																		align-items: center;
																		height: auto;
																		img {
																				border-radius: 100%;
																				margin: 0 10px 0 0;
																				object-fit: cover;
																				width: 40px;
																				height: 40px;
																			}
									.name {
																				color: #333;
																				font-size: 16px;
																			}
								}
								.reply {
																		border-radius: 4px;
																		padding: 0px;
																		box-shadow: none;
																		margin: 0px 0 0;
																		color: #666;
																		background: none;
																		font-size: 15px;
																		line-height: 30px;
																	}
								.reply-btn {
																		margin: 8px 0 0 0;
																		display: flex;
																		width: 100%;
																		justify-content: flex-end;
																		align-items: center;
																		height: 40px;
																		.delBtn {
																				border: 0;
																				cursor: pointer;
																				border-radius: 4px;
																				padding: 0 20px;
																				margin: 0 10px;
																				outline: none;
																				color: rgba(255, 255, 255, 1);
																				background: rgba(255, 0, 0, 1);
																				width: auto;
																				font-size: 14px;
																				line-height: 36px;
																				height: 36px;
																			}
								}
							}
						}
					}
				}
			}
		}
	}
	.editor {
				border: 0px solid #ddd;
				border-radius: 0px;
				box-shadow: none;
				outline: none;
				color: #333;
				width: 100%;
				font-size: 14px;
				line-height: 32px;
			}
	.editor /deep/.ql-toolbar {
		background: none;
		width: 100%;
	}
	.editor /deep/.ql-container {
		background: none;
		width: 100%;
		min-height: 200px;
	}
	.editor /deep/.ql-container .ql-blank::before {
		color: #999;
	}
	video {
		border: 0;
		border-radius: 4px;
		margin: 10px auto;
		outline: none;
		display: block;
		width: 100%;
		order: 4;
	}
</style>
