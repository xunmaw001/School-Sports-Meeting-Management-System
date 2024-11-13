import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import bisaixiangmu from '@/views/modules/bisaixiangmu/list'
    import bisaixiangmuYuyue from '@/views/modules/bisaixiangmuYuyue/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import siachenganpai from '@/views/modules/siachenganpai/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zixun from '@/views/modules/zixun/list'
    import zixunCollection from '@/views/modules/zixunCollection/list'
    import zixunLiuyan from '@/views/modules/zixunLiuyan/list'
    import config from '@/views/modules/config/list'
    import dictionaryBisaixiangmu from '@/views/modules/dictionaryBisaixiangmu/list'
    import dictionaryBisaixiangmuYuyueYesno from '@/views/modules/dictionaryBisaixiangmuYuyueYesno/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionarySiachenganpai from '@/views/modules/dictionarySiachenganpai/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'
    import dictionaryZixun from '@/views/modules/dictionaryZixun/list'
    import dictionaryZixunCollection from '@/views/modules/dictionaryZixunCollection/list'
    import siachenganpaiAdd from '@/views/modules/siachenganpai/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBisaixiangmu',
        name: '项目类型',
        component: dictionaryBisaixiangmu
    }
    ,{
        path: '/dictionaryBisaixiangmuYuyueYesno',
        name: '审核状态',
        component: dictionaryBisaixiangmuYuyueYesno
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
	,{
	    path: '/siachenganpaiAdd',
	    name: '赛程安排',
	    component: siachenganpaiAdd
	}
	
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionarySiachenganpai',
        name: '比赛结果',
        component: dictionarySiachenganpai
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '比赛状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/dictionaryZixun',
        name: '资讯类型',
        component: dictionaryZixun
    }
    ,{
        path: '/dictionaryZixunCollection',
        name: '收藏表类型',
        component: dictionaryZixunCollection
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/bisaixiangmu',
        name: '项目信息',
        component: bisaixiangmu
      }
    ,{
        path: '/bisaixiangmuYuyue',
        name: '项目报名',
        component: bisaixiangmuYuyue
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/news',
        name: '公告资讯',
        component: news
      }
    ,{
        path: '/siachenganpai',
        name: '赛程安排',
        component: siachenganpai
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zixun',
        name: '运动会资讯',
        component: zixun
      }
    ,{
        path: '/zixunCollection',
        name: '资讯收藏',
        component: zixunCollection
      }
    ,{
        path: '/zixunLiuyan',
        name: '资讯留言',
        component: zixunLiuyan
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
