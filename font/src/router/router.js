import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import payList from '../pages/pay'

import nonghuList from '../pages/nonghu/list'
import nonghuDetail from '../pages/nonghu/detail'
import nonghuAdd from '../pages/nonghu/add'
import jishurenyuanList from '../pages/jishurenyuan/list'
import jishurenyuanDetail from '../pages/jishurenyuan/detail'
import jishurenyuanAdd from '../pages/jishurenyuan/add'
import hezuosheList from '../pages/hezuoshe/list'
import hezuosheDetail from '../pages/hezuoshe/detail'
import hezuosheAdd from '../pages/hezuoshe/add'
import guoshudapengList from '../pages/guoshudapeng/list'
import guoshudapengDetail from '../pages/guoshudapeng/detail'
import guoshudapengAdd from '../pages/guoshudapeng/add'
import dapengshenqingList from '../pages/dapengshenqing/list'
import dapengshenqingDetail from '../pages/dapengshenqing/detail'
import dapengshenqingAdd from '../pages/dapengshenqing/add'
import shujuchakanList from '../pages/shujuchakan/list'
import shujuchakanDetail from '../pages/shujuchakan/detail'
import shujuchakanAdd from '../pages/shujuchakan/add'
import zuowuleixingList from '../pages/zuowuleixing/list'
import zuowuleixingDetail from '../pages/zuowuleixing/detail'
import zuowuleixingAdd from '../pages/zuowuleixing/add'
import guoshuzhongzhiList from '../pages/guoshuzhongzhi/list'
import guoshuzhongzhiDetail from '../pages/guoshuzhongzhi/detail'
import guoshuzhongzhiAdd from '../pages/guoshuzhongzhi/add'
import guangaijiluList from '../pages/guangaijilu/list'
import guangaijiluDetail from '../pages/guangaijilu/detail'
import guangaijiluAdd from '../pages/guangaijilu/add'
import shifeijiluList from '../pages/shifeijilu/list'
import shifeijiluDetail from '../pages/shifeijilu/detail'
import shifeijiluAdd from '../pages/shifeijilu/add'
import guoshushengzhangList from '../pages/guoshushengzhang/list'
import guoshushengzhangDetail from '../pages/guoshushengzhang/detail'
import guoshushengzhangAdd from '../pages/guoshushengzhang/add'
import chanliangxinxiList from '../pages/chanliangxinxi/list'
import chanliangxinxiDetail from '../pages/chanliangxinxi/detail'
import chanliangxinxiAdd from '../pages/chanliangxinxi/add'
import shebeileixingList from '../pages/shebeileixing/list'
import shebeileixingDetail from '../pages/shebeileixing/detail'
import shebeileixingAdd from '../pages/shebeileixing/add'
import shebeixinxiList from '../pages/shebeixinxi/list'
import shebeixinxiDetail from '../pages/shebeixinxi/detail'
import shebeixinxiAdd from '../pages/shebeixinxi/add'
import shebeicaigouList from '../pages/shebeicaigou/list'
import shebeicaigouDetail from '../pages/shebeicaigou/detail'
import shebeicaigouAdd from '../pages/shebeicaigou/add'
import shebeigoumaiList from '../pages/shebeigoumai/list'
import shebeigoumaiDetail from '../pages/shebeigoumai/detail'
import shebeigoumaiAdd from '../pages/shebeigoumai/add'
import shebeianzhuangList from '../pages/shebeianzhuang/list'
import shebeianzhuangDetail from '../pages/shebeianzhuang/detail'
import shebeianzhuangAdd from '../pages/shebeianzhuang/add'
import yujingxinxiList from '../pages/yujingxinxi/list'
import yujingxinxiDetail from '../pages/yujingxinxi/detail'
import yujingxinxiAdd from '../pages/yujingxinxi/add'
import yujingxiezhuList from '../pages/yujingxiezhu/list'
import yujingxiezhuDetail from '../pages/yujingxiezhu/detail'
import yujingxiezhuAdd from '../pages/yujingxiezhu/add'
import dapengxunjianList from '../pages/dapengxunjian/list'
import dapengxunjianDetail from '../pages/dapengxunjian/detail'
import dapengxunjianAdd from '../pages/dapengxunjian/add'
import tixingjianxiuList from '../pages/tixingjianxiu/list'
import tixingjianxiuDetail from '../pages/tixingjianxiu/detail'
import tixingjianxiuAdd from '../pages/tixingjianxiu/add'
import guzhangbaoxiuList from '../pages/guzhangbaoxiu/list'
import guzhangbaoxiuDetail from '../pages/guzhangbaoxiu/detail'
import guzhangbaoxiuAdd from '../pages/guzhangbaoxiu/add'
import shebeiweixiuList from '../pages/shebeiweixiu/list'
import shebeiweixiuDetail from '../pages/shebeiweixiu/detail'
import shebeiweixiuAdd from '../pages/shebeiweixiu/add'
import tousujiluList from '../pages/tousujilu/list'
import tousujiluDetail from '../pages/tousujilu/detail'
import tousujiluAdd from '../pages/tousujilu/add'
import genghuanjiluList from '../pages/genghuanjilu/list'
import genghuanjiluDetail from '../pages/genghuanjilu/detail'
import genghuanjiluAdd from '../pages/genghuanjilu/add'
import baofeishenqingList from '../pages/baofeishenqing/list'
import baofeishenqingDetail from '../pages/baofeishenqing/detail'
import baofeishenqingAdd from '../pages/baofeishenqing/add'
import zixunleixingList from '../pages/zixunleixing/list'
import zixunleixingDetail from '../pages/zixunleixing/detail'
import zixunleixingAdd from '../pages/zixunleixing/add'
import zixunneirongList from '../pages/zixunneirong/list'
import zixunneirongDetail from '../pages/zixunneirong/detail'
import zixunneirongAdd from '../pages/zixunneirong/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'nonghu',
					component: nonghuList
				},
				{
					path: 'nonghuDetail',
					component: nonghuDetail
				},
				{
					path: 'nonghuAdd',
					component: nonghuAdd
				},
				{
					path: 'jishurenyuan',
					component: jishurenyuanList
				},
				{
					path: 'jishurenyuanDetail',
					component: jishurenyuanDetail
				},
				{
					path: 'jishurenyuanAdd',
					component: jishurenyuanAdd
				},
				{
					path: 'hezuoshe',
					component: hezuosheList
				},
				{
					path: 'hezuosheDetail',
					component: hezuosheDetail
				},
				{
					path: 'hezuosheAdd',
					component: hezuosheAdd
				},
				{
					path: 'guoshudapeng',
					component: guoshudapengList
				},
				{
					path: 'guoshudapengDetail',
					component: guoshudapengDetail
				},
				{
					path: 'guoshudapengAdd',
					component: guoshudapengAdd
				},
				{
					path: 'dapengshenqing',
					component: dapengshenqingList
				},
				{
					path: 'dapengshenqingDetail',
					component: dapengshenqingDetail
				},
				{
					path: 'dapengshenqingAdd',
					component: dapengshenqingAdd
				},
				{
					path: 'shujuchakan',
					component: shujuchakanList
				},
				{
					path: 'shujuchakanDetail',
					component: shujuchakanDetail
				},
				{
					path: 'shujuchakanAdd',
					component: shujuchakanAdd
				},
				{
					path: 'zuowuleixing',
					component: zuowuleixingList
				},
				{
					path: 'zuowuleixingDetail',
					component: zuowuleixingDetail
				},
				{
					path: 'zuowuleixingAdd',
					component: zuowuleixingAdd
				},
				{
					path: 'guoshuzhongzhi',
					component: guoshuzhongzhiList
				},
				{
					path: 'guoshuzhongzhiDetail',
					component: guoshuzhongzhiDetail
				},
				{
					path: 'guoshuzhongzhiAdd',
					component: guoshuzhongzhiAdd
				},
				{
					path: 'guangaijilu',
					component: guangaijiluList
				},
				{
					path: 'guangaijiluDetail',
					component: guangaijiluDetail
				},
				{
					path: 'guangaijiluAdd',
					component: guangaijiluAdd
				},
				{
					path: 'shifeijilu',
					component: shifeijiluList
				},
				{
					path: 'shifeijiluDetail',
					component: shifeijiluDetail
				},
				{
					path: 'shifeijiluAdd',
					component: shifeijiluAdd
				},
				{
					path: 'guoshushengzhang',
					component: guoshushengzhangList
				},
				{
					path: 'guoshushengzhangDetail',
					component: guoshushengzhangDetail
				},
				{
					path: 'guoshushengzhangAdd',
					component: guoshushengzhangAdd
				},
				{
					path: 'chanliangxinxi',
					component: chanliangxinxiList
				},
				{
					path: 'chanliangxinxiDetail',
					component: chanliangxinxiDetail
				},
				{
					path: 'chanliangxinxiAdd',
					component: chanliangxinxiAdd
				},
				{
					path: 'shebeileixing',
					component: shebeileixingList
				},
				{
					path: 'shebeileixingDetail',
					component: shebeileixingDetail
				},
				{
					path: 'shebeileixingAdd',
					component: shebeileixingAdd
				},
				{
					path: 'shebeixinxi',
					component: shebeixinxiList
				},
				{
					path: 'shebeixinxiDetail',
					component: shebeixinxiDetail
				},
				{
					path: 'shebeixinxiAdd',
					component: shebeixinxiAdd
				},
				{
					path: 'shebeicaigou',
					component: shebeicaigouList
				},
				{
					path: 'shebeicaigouDetail',
					component: shebeicaigouDetail
				},
				{
					path: 'shebeicaigouAdd',
					component: shebeicaigouAdd
				},
				{
					path: 'shebeigoumai',
					component: shebeigoumaiList
				},
				{
					path: 'shebeigoumaiDetail',
					component: shebeigoumaiDetail
				},
				{
					path: 'shebeigoumaiAdd',
					component: shebeigoumaiAdd
				},
				{
					path: 'shebeianzhuang',
					component: shebeianzhuangList
				},
				{
					path: 'shebeianzhuangDetail',
					component: shebeianzhuangDetail
				},
				{
					path: 'shebeianzhuangAdd',
					component: shebeianzhuangAdd
				},
				{
					path: 'yujingxinxi',
					component: yujingxinxiList
				},
				{
					path: 'yujingxinxiDetail',
					component: yujingxinxiDetail
				},
				{
					path: 'yujingxinxiAdd',
					component: yujingxinxiAdd
				},
				{
					path: 'yujingxiezhu',
					component: yujingxiezhuList
				},
				{
					path: 'yujingxiezhuDetail',
					component: yujingxiezhuDetail
				},
				{
					path: 'yujingxiezhuAdd',
					component: yujingxiezhuAdd
				},
				{
					path: 'dapengxunjian',
					component: dapengxunjianList
				},
				{
					path: 'dapengxunjianDetail',
					component: dapengxunjianDetail
				},
				{
					path: 'dapengxunjianAdd',
					component: dapengxunjianAdd
				},
				{
					path: 'tixingjianxiu',
					component: tixingjianxiuList
				},
				{
					path: 'tixingjianxiuDetail',
					component: tixingjianxiuDetail
				},
				{
					path: 'tixingjianxiuAdd',
					component: tixingjianxiuAdd
				},
				{
					path: 'guzhangbaoxiu',
					component: guzhangbaoxiuList
				},
				{
					path: 'guzhangbaoxiuDetail',
					component: guzhangbaoxiuDetail
				},
				{
					path: 'guzhangbaoxiuAdd',
					component: guzhangbaoxiuAdd
				},
				{
					path: 'shebeiweixiu',
					component: shebeiweixiuList
				},
				{
					path: 'shebeiweixiuDetail',
					component: shebeiweixiuDetail
				},
				{
					path: 'shebeiweixiuAdd',
					component: shebeiweixiuAdd
				},
				{
					path: 'tousujilu',
					component: tousujiluList
				},
				{
					path: 'tousujiluDetail',
					component: tousujiluDetail
				},
				{
					path: 'tousujiluAdd',
					component: tousujiluAdd
				},
				{
					path: 'genghuanjilu',
					component: genghuanjiluList
				},
				{
					path: 'genghuanjiluDetail',
					component: genghuanjiluDetail
				},
				{
					path: 'genghuanjiluAdd',
					component: genghuanjiluAdd
				},
				{
					path: 'baofeishenqing',
					component: baofeishenqingList
				},
				{
					path: 'baofeishenqingDetail',
					component: baofeishenqingDetail
				},
				{
					path: 'baofeishenqingAdd',
					component: baofeishenqingAdd
				},
				{
					path: 'zixunleixing',
					component: zixunleixingList
				},
				{
					path: 'zixunleixingDetail',
					component: zixunleixingDetail
				},
				{
					path: 'zixunleixingAdd',
					component: zixunleixingAdd
				},
				{
					path: 'zixunneirong',
					component: zixunneirongList
				},
				{
					path: 'zixunneirongDetail',
					component: zixunneirongDetail
				},
				{
					path: 'zixunneirongAdd',
					component: zixunneirongAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
