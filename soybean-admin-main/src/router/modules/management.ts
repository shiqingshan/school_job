const management: AuthRoute.Route = {
  name: 'admin_management',
  path: '/admin/management',
  component: 'basic',
  children: [
    {
      name: 'admin_management_auth',
      path: '/admin/management/auth',
      component: 'self',
      meta: {
        title: '权限管理',
        requiresAuth: true,
        icon: 'ic:baseline-security'
      }
    },
    {
      name: 'admin_management_role',
      path: '/admin/management/role',
      component: 'self',
      meta: {
        title: '角色管理',
        requiresAuth: true,
        icon: 'carbon:user-role'
      }
    },
    {
      name: 'admin_management_user',
      path: '/admin/management/user',
      component: 'self',
      meta: {
        title: '用户管理',
        requiresAuth: true,
        icon: 'ic:round-manage-accounts'
      }
    },
    {
      name: 'admin_management_route',
      path: '/admin/management/route',
      component: 'self',
      meta: {
        title: '路由管理',
        requiresAuth: true,
        icon: 'material-symbols:route'
      }
    }
  ],
  meta: {
    title: '系统管理',
    icon: 'carbon:cloud-service-management',
    order: 9
  }
};

export default management;
