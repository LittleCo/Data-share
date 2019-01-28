const routes = [
  {
    path: '/',
    redirect: '/user/login',
    component: () => import('layouts/indexLayout.vue'),
    children: [{
        path: 'index',
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
      },
      {
        path: 'pages/upload',
        component: () => import('pages/upload')
      }
    ]
  },
  
  {
    path: '/user',
    redirect: '/user/login',
    component: () => import('layouts/userLayout'),
    children: [
      {
        path: 'login',
        name: 'login',
        component: () => import('pages/user/login')
      },
      {
        path: 'register',
        name: 'register',
        component: () => import('pages/user/register')
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
