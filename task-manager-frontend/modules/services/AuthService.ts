import type {ILoginRequest} from "~/modules/interfaces/ILoginRequest";
import type {User} from "~/modules/models/User";
import type {IRegisterRequest} from "~/modules/interfaces/IRegisterRequest";
import type {ILoginResponse} from "~/modules/interfaces/ILoginResponse";

export class AuthService {

  baseUrl: string;

  constructor() {
    this.baseUrl = 'http://localhost:8080';
  }

  login = async (loginRequest: ILoginRequest):Promise<ILoginResponse | undefined> => {
    try {
      return await $fetch(`${this.baseUrl}/auth/login`, {
        method: "POST",
        contentType: "application/json",
        body: JSON.stringify(loginRequest),
      })
    } catch (error) {
      console.error(error);
    }
  }

  register = async (registerRequest: IRegisterRequest):Promise<User | undefined> => {
    try {
      return await $fetch(`${this.baseUrl}/auth/signup`, {
        method: "POST",
        body: JSON.stringify(registerRequest),
      })
    } catch (error) {
      console.error(error);
    }
  }
}