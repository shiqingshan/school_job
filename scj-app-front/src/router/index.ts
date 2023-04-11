import {RouteRecordRaw, createRouter,createWebHistory} from 'vue-router';
const routes:Array<RouteRecordRaw> =[{
    path: '/',
    name: 'index',
    redirect: 'p1',
    component: ()=> import("@/layouts/HomeLayout.vue"),
    children:[
        {
            path: 'p1',
            name: 'p1',
            component: ()=> import("@/components/HelloWorld.vue")
        }
    ]
}
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router