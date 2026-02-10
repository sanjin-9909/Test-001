import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import nonghu from '@/views/modules/nonghu/list'
	import jishurenyuan from '@/views/modules/jishurenyuan/list'
	import hezuoshe from '@/views/modules/hezuoshe/list'
	import guoshudapeng from '@/views/modules/guoshudapeng/list'
	import dapengshenqing from '@/views/modules/dapengshenqing/list'
	import shujuchakan from '@/views/modules/shujuchakan/list'
	import zuowuleixing from '@/views/modules/zuowuleixing/list'
	import guoshuzhongzhi from '@/views/modules/guoshuzhongzhi/list'
	import guangaijilu from '@/views/modules/guangaijilu/list'
	import shifeijilu from '@/views/modules/shifeijilu/list'
	import guoshushengzhang from '@/views/modules/guoshushengzhang/list'
	import chanliangxinxi from '@/views/modules/chanliangxinxi/list'
	import shebeileixing from '@/views/modules/shebeileixing/list'
	import shebeixinxi from '@/views/modules/shebeixinxi/list'
	import shebeicaigou from '@/views/modules/shebeicaigou/list'
	import shebeigoumai from '@/views/modules/shebeigoumai/list'
	import shebeianzhuang from '@/views/modules/shebeianzhuang/list'
	import yujingxinxi from '@/views/modules/yujingxinxi/list'
	import yujingxiezhu from '@/views/modules/yujingxiezhu/list'
	import dapengxunjian from '@/views/modules/dapengxunjian/list'
	import tixingjianxiu from '@/views/modules/tixingjianxiu/list'
	import guzhangbaoxiu from '@/views/modules/guzhangbaoxiu/list'
	import shebeiweixiu from '@/views/modules/shebeiweixiu/list'
	import tousujilu from '@/views/modules/tousujilu/list'
	import genghuanjilu from '@/views/modules/genghuanjilu/list'
	import baofeishenqing from '@/views/modules/baofeishenqing/list'
	import zixunleixing from '@/views/modules/zixunleixing/list'
	import zixunneirong from '@/views/modules/zixunneirong/list'
	import newstype from '@/views/modules/newstype/list'
	import news from '@/views/modules/news/list'
	import forum from '@/views/modules/forum/list'
	import chatmessage from '@/views/modules/chatmessage/list'
	import friend from '@/views/modules/friend/list'
	import chat from '@/views/modules/chat/list'
	import syslog from '@/views/modules/syslog/list'
	import users from '@/views/modules/users/list'
import config from '@/views/modules/config/list'

//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/nonghu',
		name: '农户',
		component: nonghu
	}
	,{
		path: '/nonghustat',
		name: '农户统计',
		component: nonghu
	}
	,{
		path: '/jishurenyuan',
		name: '技术人员',
		component: jishurenyuan
	}
	,{
		path: '/hezuoshe',
		name: '合作社',
		component: hezuoshe
	}
	,{
		path: '/guoshudapeng',
		name: '果蔬大棚',
		component: guoshudapeng
	}
	,{
		path: '/guoshudapengstat',
		name: '果蔬大棚统计',
		component: guoshudapeng
	}
	,{
		path: '/dapengshenqing',
		name: '大棚申请',
		component: dapengshenqing
	}
	,{
		path: '/dapengshenqingstat',
		name: '大棚申请统计',
		component: dapengshenqing
	}
	,{
		path: '/shujuchakan',
		name: '数据查看',
		component: shujuchakan
	}
	,{
		path: '/zuowuleixing',
		name: '作物类型',
		component: zuowuleixing
	}
	,{
		path: '/guoshuzhongzhi',
		name: '果蔬种植',
		component: guoshuzhongzhi
	}
	,{
		path: '/guoshuzhongzhistat',
		name: '果蔬种植统计',
		component: guoshuzhongzhi
	}
	,{
		path: '/guangaijilu',
		name: '灌溉记录',
		component: guangaijilu
	}
	,{
		path: '/shifeijilu',
		name: '施肥记录',
		component: shifeijilu
	}
	,{
		path: '/guoshushengzhang',
		name: '果蔬生长',
		component: guoshushengzhang
	}
	,{
		path: '/guoshushengzhangstat',
		name: '果蔬生长统计',
		component: guoshushengzhang
	}
	,{
		path: '/chanliangxinxi',
		name: '产量信息',
		component: chanliangxinxi
	}
	,{
		path: '/shebeileixing',
		name: '设备类型',
		component: shebeileixing
	}
	,{
		path: '/shebeixinxi',
		name: '设备信息',
		component: shebeixinxi
	}
	,{
		path: '/shebeicaigou',
		name: '设备采购',
		component: shebeicaigou
	}
	,{
		path: '/shebeicaigoustat',
		name: '设备采购统计',
		component: shebeicaigou
	}
	,{
		path: '/shebeigoumai',
		name: '设备购买',
		component: shebeigoumai
	}
	,{
		path: '/shebeigoumaistat',
		name: '设备购买统计',
		component: shebeigoumai
	}
	,{
		path: '/shebeianzhuang',
		name: '设备安装',
		component: shebeianzhuang
	}
	,{
		path: '/yujingxinxi',
		name: '预警信息',
		component: yujingxinxi
	}
	,{
		path: '/yujingxiezhu',
		name: '预警协助',
		component: yujingxiezhu
	}
	,{
		path: '/dapengxunjian',
		name: '大棚巡检',
		component: dapengxunjian
	}
	,{
		path: '/tixingjianxiu',
		name: '提醒检修',
		component: tixingjianxiu
	}
	,{
		path: '/guzhangbaoxiu',
		name: '故障报修',
		component: guzhangbaoxiu
	}
	,{
		path: '/shebeiweixiu',
		name: '设备维修',
		component: shebeiweixiu
	}
	,{
		path: '/tousujilu',
		name: '投诉记录',
		component: tousujilu
	}
	,{
		path: '/genghuanjilu',
		name: '更换记录',
		component: genghuanjilu
	}
	,{
		path: '/baofeishenqing',
		name: '报废申请',
		component: baofeishenqing
	}
	,{
		path: '/zixunleixing',
		name: '资讯类型',
		component: zixunleixing
	}
	,{
		path: '/zixunneirong',
		name: '资讯内容',
		component: zixunneirong
	}
	,{
		path: '/newstype',
		name: '资讯分类',
		component: newstype
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
	,{
		path: '/forum',
		name: '互动交流',
		component: forum
	}
	,{
		path: '/chatmessage',
		name: '消息表',
		component: chatmessage
	}
	,{
		path: '/friend',
		name: '好友表',
		component: friend
	}
	,{
		path: '/chat',
		name: 'AI种植助手',
		component: chat
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/users',
		name: '管理员',
		component: users
	}
	,{
		path: '/config/:type',
		name: '配置管理',
		component: config
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
