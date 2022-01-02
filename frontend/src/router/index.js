import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
  },
  {
    path: '/kakaologin',
    name: 'klogin',
    component: () => import('../views/kakaoLogin.vue'),
  },
  {
    path: '/signUp',
    name: 'signUp',
    component: () => import('../views/signUp.vue'),
  },
];

const router = new VueRouter({
  routes,
  mode: 'history',
});

export default router;
