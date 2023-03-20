/* eslint-disable */
import Vue from "vue";
import Router from "vue-router";
import TierCrud from "@/components/TierCrud";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "TierCrud",
      component: TierCrud
    }
  ]
});
