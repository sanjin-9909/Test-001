<template>
	<div>
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="'>>'">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
	
		<div class="news-preview-pv">
			<el-form :inline="true" :model="formSearch" class="list-form-pv">
				<el-form-item class="search-item">
					<el-input v-model="title" placeholder="标题"></el-input>
				</el-form-item>
				<el-button class="search-btn" type="primary" @click="getNewsList(1)">
					<span class="icon iconfont icon-chakan14"></span>
					搜索
				</el-button>
			</el-form>
			
			<!-- category -->
			<div class="category-list">
				<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
				<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
			</div>
			<!-- 样式五 -->
			<div class="list5 index-pv1">
				<div v-for="item in newsList" :key="item.id" @click="toNewsDetail(item)" class="list-item animation-box">
					<img :src="baseUrl + (item.picture?item.picture.split(',')[0]:'')" >
					<div class="infoBox">
						<div class="name">{{item.title}}</div>
						<div class="desc">{{item.introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{item.addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{item.name}}</span>
						</div>
						<div class="tags">查看更多 →</div>
					</div>
				</div>
			</div>
		
			<el-pagination
				background
				id="pagination" class="pagination"
				:pager-count="7"
				:page-size="pageSize"
				:page-sizes="pageSizes"
				prev-text="<"
				next-text=">"
				:hide-on-single-page="true"
				:layout='["total","prev","pager","next","sizes","jumper"].join()'
				:total="total"
				@current-change="curChange"
				@size-change="sizeChange"
				@prev-click="prevClick"
				@next-click="nextClick"
				></el-pagination>
		</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				baseUrl: this.$config.baseUrl,
				breadcrumbItem: [
				  {
					name: '公告信息'
				  }
				],
				newsList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				layouts: '',
				title: '',
				categoryIndex: 0,
				categoryList: [],
			}
		},
		created() {
			this.getCategoryList()
		},
		watch:{
			$route(newValue){
				this.getCategoryList()
			}
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('newstype/list', {params: {sort: 'typename',order: 'desc'}}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list;
						if(this.$route.query.homeFenlei){
							for(let i=0;i<this.categoryList.length;i++) {
								if(this.$route.query.homeFenlei == this.categoryList[i].typename) {
									this.categoryIndex = i + 1;
									const currentRoute = this.$route;
									const routeWithoutQuery = { ...currentRoute };
									delete routeWithoutQuery.query;
									this.$router.replace(routeWithoutQuery)
									break;
								}
							}
						}
						this.getNewsList(1);
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getNewsList()
			},
			getNewsList(page) {
				let params = {page, limit: this.pageSize,sort:'addtime',order:'desc'};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			curChange(page) {
				this.getNewsList(page);
			},
			sizeChange(size){
				this.pageSize = size
				this.getNewsList(1);
			},
			prevClick(page) {
				this.getNewsList(page);
			},
			nextClick(page) {
				this.getNewsList(page);
			},
			toNewsDetail(item) {
				this.$router.push({path: '/index/newsDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-preview-pv {
				padding: 10px calc((100% - 1200px)/2);
				margin: 0px auto;
				align-content: flex-start;
				background: rgb(245, 245, 245);
				display: flex;
				width: 100%;
				align-items: flex-start;
				position: relative;
				flex-wrap: wrap;
				.list-form-pv {
						padding: 0px;
						margin: 0 0 20px;
						background: none;
						display: flex;
						width: 100%;
						justify-content: flex-end;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 10px;
								.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 1px solid #ddd;
										border-radius: 0px;
										padding: 0 10px;
										margin: 0;
										outline: none;
										color: #333;
										width: 500px;
										font-size: 16px;
										line-height: 42px;
										height: 42px;
									}
			}
			.search-btn {
								cursor: pointer;
								border: 0;
								border-radius: 0px;
								padding: 0px 15px;
								margin: 0 0px 0 0;
								outline: none;
								color: #fff;
								background: #009899;
								width: auto;
								font-size: 16px;
								line-height: 42px;
								height: 42px;
								.icon {
										margin: 0 3px 0 0;
										color: #fff;
										font-size: 16px;
									}
			}
		}
		.category-list {
						border: 0px solid #eee;
						padding: 0;
						margin: 0;
						background: none;
						display: flex;
						width: 100%;
						flex-wrap: wrap;
						height: auto;
						order: 3;
						.item {
								cursor: pointer;
								padding: 0 30px 0 20px;
								margin: 0 10px 10px 0;
								color: #333;
								font-weight: 500;
								font-size: 16px;
								border-color: #eee;
								line-height: 40px;
								border-radius: 0px;
								background: url(http://codegen.caihongy.cn/20250724/a9ae038680ad405ab52959a07a31413f.png) no-repeat 90% center,#fff;
								width: auto;
								border-width: 1px;
								border-style: solid;
								text-align: left;
							}
			
			.item:hover {
								cursor: pointer;
								border-radius: 0px;
								margin: 0 10px 10px 0;
								color: #009899;
								background: url(http://codegen.caihongy.cn/20250724/8387605c6c7141e5b36ccee50437adb2.png) no-repeat 90% center,#fff;
								width: auto;
								font-size: 16px;
								border-color: #00989950;
								line-height: 40px;
								text-align: left;
							}
			
			.item.active {
								cursor: pointer;
								padding: 0 30px 0 20px;
								margin: 0 10px 10px 0;
								color: #009899;
								font-weight: 600;
								font-size: 16px;
								border-color: #00989950;
								line-height: 40px;
								border-radius: 0px;
								background: url(http://codegen.caihongy.cn/20250724/8387605c6c7141e5b36ccee50437adb2.png) no-repeat 90% center,#fff;
								width: auto;
								border-width: 1px;
								border-style: solid;
								text-align: left;
							}
		}
		.list5 {
						padding: 20px 20px 10px;
						margin: 20px 0 0;
						color: #999;
						background: #fff;
						flex: 1;
						display: flex;
						width: calc(100% - 350px);
						font-size: 14px;
						flex-wrap: wrap;
						height: auto;
						order: 4;
						.list-item {
								cursor: pointer;
								padding: 0 0 15px;
								margin: 0 0px 15px;
								background: none;
								display: flex;
								width: calc(100% - 0px);
								border-color: #e5e5e5;
								border-width: 0 0 1px;
								border-style: solid;
								height: auto;
								img {
										object-fit: cover;
										width: 150px;
										height: 150px;
									}
				.infoBox {
										padding: 0 0px 0 20px;
										align-content: center;
										flex: 1;
										display: flex;
										width: 100%;
										align-items: center;
										flex-wrap: wrap;
										height: 100%;
										.name {
												overflow: hidden;
												color: #2b2b2b;
												white-space: nowrap;
												font-weight: 600;
												width: 100%;
												font-size: 15px;
												line-height: 24px;
												text-overflow: ellipsis;
											}
					.desc {
												margin: 0 0 10px;
												overflow: hidden;
												color: #666;
												width: 100%;
												font-size: 14px;
												line-height: 30px;
												height: 60px;
											}
					.time_item {
												padding: 0 10px 0 0;
												.icon {
														margin: 0 2px 0 0;
														line-height: 1.5;
													}
						.label {
														display: none;
														line-height: 1.5;
													}
						.text {
														line-height: 1.5;
													}
					}
					.publisher_item {
												padding: 0 10px 0 0;
												.icon {
														margin: 0 2px 0 0;
														line-height: 1.5;
													}
						.label {
														display: none;
														line-height: 1.5;
													}
						.text {
														line-height: 1.5;
													}
					}
					.like_item {
												padding: 0 10px 0 0;
												.icon {
														margin: 0 2px 0 0;
														line-height: 1.5;
													}
						.label {
														display: none;
														line-height: 1.5;
													}
						.text {
														line-height: 1.5;
													}
					}
					.collect_item {
												padding: 0 10px 0 0;
												.icon {
														margin: 0 2px 0 0;
														line-height: 1.5;
													}
						.label {
														display: none;
														line-height: 1.5;
													}
						.text {
														line-height: 1.5;
													}
					}
					.view_item {
												padding: 0;
												.icon {
														margin: 0 2px 0 0;
														line-height: 1.5;
													}
						.label {
														display: none;
														line-height: 1.5;
													}
						.text {
														line-height: 1.5;
													}
					}
					.tags {
												border-radius: 20px;
												padding: 0 10px;
												margin: 10px 0 0 auto;
												color: #999;
												background: none;
												display: none;
												width: auto;
												font-size: 14px;
												line-height: 32px;
												text-align: center;
											}
				}
			}
		}
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(6px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
</style>
