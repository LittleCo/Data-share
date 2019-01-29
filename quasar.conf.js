// Configuration for your app

module.exports = function (ctx) {
  return {
    // app plugins (/src/plugins)
    plugins: [
      'axios',
      'vuelidate'
    ],
    css: [
      'app.styl'
    ],
    extras: [
      ctx.theme.mat ? 'roboto-font' : null,
      'material-icons' // optional, you are not bound to it
      // 'ionicons',
      // 'mdi',
      // 'fontawesome'
    ],
    supportIE: false,
    build: {
      scopeHoisting: true,
      vueRouterMode: 'history',
      // vueCompiler: true,
      // gzip: true,
      // analyze: true,
      // extractCSS: false,
      extendWebpack (cfg) {
      }
    },
    devServer: {
      // https: true,
      // port: 8080,
      open: true // opens browser window automatically
    },
    // framework: 'all' --- includes everything; for dev only!
    framework: {
      components: [
        'QBtn',
        'QBtnGroup',
        'QCard',
        'QCardActions',
        'QCardMain',
        'QCardMedia',
        'QCardSeparator',
        'QCarousel',
        'QCarouselSlide',
        'QCarouselControl',
        'QCollapsible',
        'QCardTitle',
        'QCheckbox',
        'QContextMenu',
        'QDialog',
        'QFab',
        'QFabAction',
        'QField',
        'QIcon',
        'QInnerLoading',
        'QInput',
        'QItem',
        'QItemMain',
        'QItemSeparator',
        'QItemSide',
        'QItemTile',
        'QLayout',
        'QLayoutDrawer',
        'QLayoutHeader',
        'QBreadcrumbs',
        'QBreadcrumbsEl',
        'QList',
        'QListHeader',
        'QPage',
        'QPageContainer',
        'QPageSticky',
        'QPopover',
        'QParallax',
        'QProgress',
        'QRouteTab',
        'QSpinnerIos',
        'QSearch',
        'QSelect',
        'QTab',
        'QTable',
        'QTableColumns',
        'QUploader',
        'QModal',
        'QModalLayout',
        'QTabs',
        'QTree',
        'QTd',
        'QTh',
        'QToolbar',
        'QToolbarTitle',
        'QTr'
      ],
      directives: [
        'Ripple'
      ],
      // Quasar plugins
      plugins: [
        'Notify'
      ]
      // iconSet: ctx.theme.mat ? 'material-icons' : 'ionicons'
      // i18n: 'de' // Quasar language
    },
    // animations: 'all' --- includes all animations
    animations: [],
    ssr: {
      pwa: false
    },
    pwa: {
      // workboxPluginMode: 'InjectManifest',
      // workboxOptions: {},
      manifest: {
        // name: 'Quasar App',
        // short_name: 'Quasar-PWA',
        // description: 'Best PWA App in town!',
        display: 'standalone',
        orientation: 'portrait',
        background_color: '#ffffff',
        theme_color: '#027be3',
        icons: []
      }
    },
    cordova: {
      // id: 'org.cordova.quasar.app'
    },
    electron: {
      // bundler: 'builder', // or 'packager'
      extendWebpack (cfg) {
        // do something with Electron process Webpack cfg
      },
      packager: {
        // https://github.com/electron-userland/electron-packager/blob/master/docs/api.md#options

        // OS X / Mac App Store
        // appBundleId: '',
        // appCategoryType: '',
        // osxSign: '',
        // protocol: 'myapp://path',

        // Window only
        // win32metadata: { ... }
      },
      builder: {
        // https://www.electron.build/configuration/configuration

        // appId: 'quasar-app'
      }
    }
  }
}
