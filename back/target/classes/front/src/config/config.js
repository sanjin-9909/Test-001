export default {
	baseUrl: 'http://localhost:8080/springboot584f4022/',
	name: '/springboot584f4022',
	indexNav: [
		// guoshudapeng
		{
			name: '果蔬大棚',
			url: '/index/guoshudapeng',
		},
		// shebeixinxi
		{
			name: '设备信息',
			url: '/index/shebeixinxi',
		},
		// zixunneirong
		{
			name: '资讯内容',
			url: '/index/zixunneirong',
		},
		// news
		{
			name: '公告信息',
			url: '/index/news',
		},
		// forum
		{
			name: '互动交流',
			url: '/index/forum',
		},
		// {
		// 	name: '公告信息',
		// 	url: '/index/news'
		// },
		// {
		// 	name: '互动交流',
		// 	url: '/index/forum'
		// }, 
	],
	cateList: [
		{
			name: '公告信息',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	],
	payList: [
	],
}
