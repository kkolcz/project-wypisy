import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject, Subscription } from 'rxjs';

import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { IAuthRequest, IAuthResponse } from '../models/auth.model';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService implements OnInit {
  userIsLoginSubject = new Subject<boolean>();
  userIsLogin: boolean = false;
  token: string = null;

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private router: Router, private http: HttpClient) {}

  isLogin() {
    return this.userIsLogin;
  }

  signIn(loginData) {
    this.userIsLogin = true;
    this.userIsLoginSubject.next(true);
    // console.log(loginData);

    const requestData: IAuthRequest = {
      email: loginData.email,
      password: loginData.password,
    };

    console.log(requestData);
    this.http
      .post<IAuthResponse>(`${this.API_URL}/auth/authenticate`, requestData)
      .subscribe((res) => {
        console.log(res.token);
        this.token = res.token;
        this.router.navigate(['/']);
        localStorage.setItem('token', res.token);
        this.userIsLogin = true;
        this.userIsLoginSubject.next(this.userIsLogin);
      });
  }

  signOut() {
    this.userIsLogin = false;
    this.userIsLoginSubject.next(this.userIsLogin);
  }

  ngOnInit(): void {}
}
