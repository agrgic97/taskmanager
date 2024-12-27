import nuxtStorage from "nuxt-storage";

export default defineNuxtPlugin((nuxtApp) => {
  nuxtApp.hook('app:mounted', () => {
    setInterval(async () => {
      const token = nuxtStorage.localStorage.getData('token');
      if (token) {
        const payload = JSON.parse(atob(token.split('.')[1]));
        const isExpired = payload.exp * 1000 < Date.now();
        if (isExpired) {
          alert('Your session has expired. Please log in again.');
          nuxtStorage.localStorage.removeItem('token');
          const router = nuxtApp.vueApp.$nuxt.$router
          if (router) {
            await router.push("/login")
          } else {
            console.error("Router instance is not available.");
          }
        }
      }
    }, 60 * 1000); // Check every minute
  });
});
