const scjApp: AuthRoute.Route = {
  name: 'app',
  path: '/app',
  component: 'app',
  children: [
    {
      name: 'app_home',
      path: '/app/home',
      component: 'self',
      meta: {
        title: '首页',
        requiresAuth: false
      }
    }
  ],
  meta: {
    title: 'app',
    requiresAuth: false,
    hide: true
  }
};
export default scjApp;
