import {Task} from '../models/Task';

export class User {

  constructor(
    id: number = 0,
    username: string = '',
    password: string = '',
    tasks: Task[] = [],
    accountNonExpired: boolean = false,
    accountNonLocked: boolean = false,
    credentialsNonExpired: boolean = false,
    enabled: boolean = false,
    authorities: object[] = [],
  ) {}

}