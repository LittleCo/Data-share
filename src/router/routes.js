const routes = [
  {
    path: '/',
    component: () => import('layouts/MyLayout.vue'),
    children: [{
        path: '',
        name:'index',
        component: () => import('pages/Index.vue')
      },
      {
        path: 'pages/math',
        component: () => import('pages/math.vue')
      },
      {
        path: 'pages/english',
        component: () => import('pages/english.vue')
      },
      {
        path: 'pages/programc',
        component: () => import('pages/programC.vue')
      },
      {
        path: 'pages/digitallogic',
        component: () => import('pages/digitalLogic.vue')
      },
      {
        path: 'pages/oop',
        component: () => import('pages/OOP.vue')
      }
    ]
  },
  
  {
    path: '/user',
    redirect:'/user/login',
    component: () => import('layouts/userLayout'),
    children: [
      {
        path:'login',
        component: () => import('pages/user/login')
      }
    ]
  }
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
