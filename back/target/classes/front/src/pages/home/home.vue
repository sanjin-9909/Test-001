<template>
	<div class="home-preview">




		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告信息</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div v-if="newsList.length" class="list list17 index-pv1">
				<div class="swiper">
					<div class="swiper-container newsSwiper17 new-list-17news">
						<div class="swiper-wrapper">
							<template v-for="(item,index) in newsList">
								<div v-if="index < 3" class="swiper-slide">
									<div class="list-item" @click="toDetail('newsDetail', item)">
										<img :src="baseUrl + (item.picture?item.picture.split(',')[0]:'')">
										<div class="infoBox">
											<div class="name">{{item.title}}</div>
											<div class="time">
												<span class="icon iconfont icon-shijian21"></span>
												<span class="label">发布时间：</span>
												<span class="text">{{item.addtime.split(' ')[0]}}</span>
											</div>
										</div>
									</div>
								</div>
							</template>
						</div>
						<!-- Add Pagination -->
						<div class="swiper-pagination"></div>
					</div>
				</div>
				<div class="right">
					<div class="top-list-item" v-if="newsList.length > 3" @click="toDetail('newsDetail', newsList[3])">
						<div class="name">{{newsList[3].title}}</div>
						<div class="desc">{{newsList[3].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[3].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[3].name}}</span>
						</div>
					</div>
					<div class="list-body">
						<template v-for="(item,index) in newsList">
							<div class="list-item" v-if="index > 3" @click="toDetail('newsDetail', item)">
								<div class="dian"></div>
								<div class="name">{{item.title}}</div>
								<div class="time">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{item.addtime.split(' ')[0]}}</span>
								</div>
							</div>
						</template>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">更多 >></span>
				<i class="icon iconfont icon-zhankai8"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 特价商品 -->
		<div id="animate_listguoshudapeng" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">果蔬大棚展示</span>
				<span class="list_subhead">{{'guoshudapeng'.toUpperCase()}} SHOW</span>
			</div>
			<!-- 样式二 -->
			<div class="list list2 index-pv1">
				<div v-for="(item,index) in guoshudapengList" class="list-item animation-box" :key="index" @click="toDetail('guoshudapengDetail', item)">
					<img v-if="preHttp(item.dapengtupian)" :src="item.dapengtupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (item.dapengtupian?item.dapengtupian.split(',')[0]:'')" alt="" />
					<div class="item-info">
						<div class="name line1">{{item.dapengmingcheng}}</div>
						<div class="name line1">{{item.dapengleixing}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{item.addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{item.xinyongdaima}}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('guoshudapeng')">
				<span class="text">更多 >></span>
				<i class="icon iconfont "></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],

				guoshudapengList: [],

				newListSwiper17news: null,



			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		computed: {
			username() {
				return localStorage.getItem('username')
			}
		},
		//方法集合
		methods: {
			swiperChanges() {
				if (this['newListSwiper17news']) this['newListSwiper17news'].destroy()
				setTimeout(()=>{
					this['newListSwiper17news'] = new Swiper(".new-list-17news", {"pagination":{"el":".swiper-pagination","clickable":true}})
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_listguoshudapeng',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 8,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
			
				data = {
					page: 1,
					limit: 4,
				}

				this.$http.get('guoshudapeng/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.guoshudapengList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id, storeupType: 1}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		padding: 0 calc((100% - 1200px)/2);
		margin: 0 auto;
		display: flex;
		gap: 20px;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		.news {
			padding: 0;
			margin: 20px auto 0;
			background: #fff;
			width: 100%;
			position: relative;
			order: 1;
			.news_title_box {
				padding: 0 12px;
				margin: 0;
				top: 10px;
				width: auto;
				line-height: 44px;
				position: absolute;
				.news_title {
					padding: 0 0 0 10px;
					color: #1d8f7a;
					width: auto;
					font-size: 16px;
					border-color: #1d8f7a;
					border-width: 0 0 0 4px;
					line-height: 1.5;
					border-style: solid;
				}
				.news_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 36px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -4px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list17 {
				background: none;
				display: flex;
				width: 100%;
				justify-content: space-between;
				height: auto;
				.swiper {
					background: #fff;
					width: calc(100% - 370px);
					height: auto;
					order: 2;
					.swiper-slide {
						.list-item {
							width: 100%;
							position: relative;
							height: auto;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								height: 350px;
							}
							.infoBox {
								cursor: pointer;
								left: 0;
								bottom: 0;
								background: rgba(0,0,0,.3);
								display: flex;
								width: 100%;
								align-items: center;
								position: absolute;
								.name {
									padding: 0 10px;
									overflow: hidden;
									color: #fff;
									white-space: nowrap;
									flex: 1;
									font-size: 15px;
									line-height: 44px;
									text-overflow: ellipsis;
								}
								.time {
									padding: 0 10px;
									margin: 0 60px 0 0;
									.icon {
										margin: 0 2px 0 0;
										color: #fff;
										font-size: 12px;
										line-height: 1.5;
									}
									.label {
										color: #fff;
										display: none;
										font-size: 12px;
										line-height: 1.5;
									}
									.text {
										color: #fff;
										font-size: 12px;
										line-height: 1.5;
									}
								}
							}
						}
					}
					/deep/.swiper-pagination {
						left: 0;
						bottom: 10px;
						width: 100%;
						text-align: right;
						/deep/ span.swiper-pagination-bullet {
							border-radius: 100%;
							margin: 0 4px;
							background: #fff;
							display: inline-block;
							width: 10px;
							opacity: .2;
							height: 10px;
						}
						
						/deep/ span.swiper-pagination-bullet:hover {
							background: red;
							opacity: 1;
						}
						
						/deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
							background: red;
							opacity: 1;
						}
					}
				}
				.right {
					border: 1px solid #eee;
					padding: 40px 0 0;
					margin: 0 20px 0 0;
					background: #fff;
					width: 350px;
					height: auto;
					.top-list-item {
						cursor: pointer;
						padding: 10px;
						margin: 0 0 10px 0;
						background: #fff;
						width: 100%;
						height: auto;
						.name {
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 15px;
							line-height: 30px;
							text-overflow: ellipsis;
						}
						.desc {
							margin: 0;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 24px;
							height: 48px;
						}
						.time_item {
							padding: 0;
							margin: 0 15px 0 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0;
							margin: 0 15px 0 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0;
							margin: 0 15px 0 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0;
							margin: 0 15px 0 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0;
							display: none;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
					.list-body {
						padding: 0 10px 10px;
						background: #fff;
						width: 100%;
						height: auto;
						.list-item {
							cursor: pointer;
							display: flex;
							width: 100%;
							align-items: center;
							height: auto;
							.dian {
								border-radius: 100%;
								margin: 0 6px;
								background: red;
								display: none;
								width: 4px;
								height: 4px;
							}
							.name {
								overflow: hidden;
								color: #333;
								white-space: nowrap;
								flex: 1;
								width: 100%;
								font-size: 14px;
								line-height: 44px;
								text-overflow: ellipsis;
								transition: 0.3s;
							}
							.time {
								padding: 0 6px;
								display: none;
								.icon {
									color: #666;
									font-size: 12px;
									line-height: 44px;
								}
								.label {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 12px;
									line-height: 1.5;
								}
							}
						}
						.list-item {
							.name {
								transform: translate3d(10px, 0px, 0px);
							}
						}
					}
				}
			}
			.moreBtn {
				cursor: pointer;
				margin: 0 0 0 280px;
				top: 20px;
				background: none;
				display: block;
				line-height: 24px;
				position: absolute;
				.text {
					margin: 0 5px 0 0;
					color: #999;
					font-size: 15px;
				}
				.icon {
					color: #666;
					display: none;
					font-size: 14px;
				}
			}
		}
		.lists {
			padding: 0;
			margin: 20px 0;
			background: #fff;
			flex: 1;
			width: calc(50% - 10px);
			position: relative;
			order: 5;
			.list_title_box {
				padding: 0;
				margin: 0;
				width: auto;
				.list_title {
					padding: 0 0 0 10px;
					color: #333;
					width: auto;
					font-size: 16px;
					border-color: #1d8f7a;
					border-width: 0 0 0 4px;
					line-height: 24px;
					border-style: solid;
				}
				.list_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 36px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
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
			.list2 {
				border: 0px solid #eee;
				padding: 10px 0px 0;
				margin: 0;
				background: none;
				display: flex;
				width: 100%;
				justify-content: space-between;
				flex-wrap: wrap;
				height: auto;
				.list-item {
					cursor: pointer;
					padding: 10px 0 0;
					margin: 0 0 10px;
					background: #fff;
					display: flex;
					width: 100%;
					border-color: #eee;
					border-width: 1px 0 0;
					position: relative;
					border-style: solid;
					height: auto;
					img {
						object-fit: cover;
						display: inline-block;
						width: 150px;
						height: 150px;
					}
					.item-info {
						padding: 0;
						overflow: hidden;
						align-content: center;
						flex: 1;
						display: flex;
						width: 100%;
						align-items: center;
						flex-wrap: wrap;
						height: 100%;
						.name {
							padding: 0 10px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 500;
							width: 100%;
							font-size: 15px;
							line-height: 24px;
							text-overflow: ellipsis;
						}
						.price {
							padding: 0 10px;
							color: #f00;
							width: 100%;
							font-size: 16px;
							line-height: 2;
						}
						.time_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							.icon {
								margin: 0 2px 0 0;
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								font-size: 12px;
								line-height: 1.5;
							}
							.text {
								color: #666;
								font-size: 12px;
								line-height: 1.5;
							}
						}
					}
				}
			}
			.moreBtn {
				cursor: pointer;
				margin: 0;
				top: 0;
				background: none;
				display: block;
				line-height: 24px;
				position: absolute;
				right: 0;
				.text {
					color: #999;
					font-size: 15px;
				}
				.icon {
					color: #000;
					background: url(http://codegen.caihongy.cn/20250723/f55723c8f503443d88340b22c03f412a.png) no-repeat center center;
					display: none;
					width: 23px;
					font-size: 14px;
					height: 7px;
				}
			}
		}
	}
</style>
