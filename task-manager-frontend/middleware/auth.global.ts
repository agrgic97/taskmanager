import useAuthStore from "~/stores/AuthStore";

export default defineNuxtRouteMiddleware(async (to, from) => {
  const authStore = useAuthStore();
  const unprotectedEndpoints = ["/login", "/register"];

  if (!authStore.isLoggedIn() && to.path === "/") {
    return navigateTo("/login");
  }

  if (authStore.isLoggedIn() && unprotectedEndpoints.includes(to.path)) {
    return navigateTo("/");
  }
});