import type {Status} from "~/modules/enums/Status";
import type {User} from "~/modules/models/User";

export class Task {

  constructor(
    id: number,
    title: string,
    description: string,
    status: Status,
    created_at: Date,
    updated_at: Date,
    user: User,
  ) {}

}