export interface IAuthRequest {
  email: string;
  password: string;
}

export interface IAuthResponse {
  token: string;
}
