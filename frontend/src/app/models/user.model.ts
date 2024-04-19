// export interface IUser {
//   id: number;
//   email: string;
//   name: string;
//   surname: string;
//   token: string;
// }

export interface IUser {
  email: string;
  token: string;
}

export class User {
  constructor(public email: string, private _token: string) {}

  get token() {
    return this._token;
  }
}
