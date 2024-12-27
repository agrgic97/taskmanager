<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
      <h2 class="text-2xl font-bold mb-6 text-center text-blue-600">Login</h2>
      <form @submit.prevent="handleLogin">
        <div class="mb-4">
          <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
          <input
              v-model="state.username"
              type="text"
              id="username"
              placeholder="Enter your username"
              class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500"
              required
          />
        </div>
        <div class="mb-4">
          <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
          <input
              v-model="state.password"
              type="password"
              id="password"
              placeholder="Enter your password"
              class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500"
              required
          />
        </div>
        <button
            type="submit"
            class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition"
        >
          Login
        </button>
        <span class="text-red-500">{{ state.error }}</span>
      </form>
      <p class="mt-4 text-center text-sm text-gray-600">
        Don't have an account?
        <NuxtLink to="/register" class="text-blue-500 hover:underline">Register</NuxtLink>
      </p>
    </div>
  </div>
</template>

<script setup lang="ts">
import useAuthStore from "~/stores/AuthStore";
import {useRouter} from "#vue-router";

const authStore = useAuthStore()
const router = useRouter()

const state = reactive({
  username: '',
  password: '',
  error: ''
})

const handleLogin = async () => {
  await authStore.login({username: state.username, password: state.password});
  if (authStore.isLoggedIn()) {
    await router.push('/');
  } else {
    state.error = 'Wrong username or password';
  }
}
</script>
