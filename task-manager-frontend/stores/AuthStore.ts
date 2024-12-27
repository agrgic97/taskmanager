import {defineStore} from "pinia";
import {User} from "~/modules/models/User";
import type {ILoginRequest} from "~/modules/interfaces/ILoginRequest";
import {AuthService} from "~/modules/services/AuthService";
import type {IRegisterRequest} from "~/modules/interfaces/IRegisterRequest";
import type {ILoginResponse} from "~/modules/interfaces/ILoginResponse";
import nuxtStorage from "nuxt-storage";

const authService = new AuthService();

const useAuthStore = defineStore('authStore', () => {
  const user: Ref<User> = ref<User>({})

  const login = async (loginRequest: ILoginRequest):Promise<void> => {
    const loginResponse: ILoginResponse | undefined = await authService.login(loginRequest)
    if (loginResponse !== undefined) {
      nuxtStorage.localStorage.setData('token', loginResponse.token, 60 * 24)
    }
  }

  const register = async (registerRequest: IRegisterRequest):Promise<void> => {
    const registerResponse: User | undefined = await authService.register(registerRequest)
    if (registerResponse !== undefined) {
      user.value = registerResponse
    }
  }

  const logout = () => {
    nuxtStorage.localStorage.removeItem('token')
  }

  const isLoggedIn = ():boolean => {
    const tkn = nuxtStorage.localStorage.getData('token')
    return tkn !== null;

  }

  return {
    user,
    login,
    register,
    logout,
    isLoggedIn,
  }
})

export default useAuthStore;