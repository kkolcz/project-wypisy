import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';

import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { IAuthRequest, IAuthResponse } from '../models/auth.model';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService implements OnInit {
  user = new BehaviorSubject(null);
  token: string = null;

  // userIsLoginSubject = new Subject<boolean>();
  userIsLogin: boolean = false;

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private router: Router, private http: HttpClient) {}

  isLogin() {
    return this.user;
  }

  signIn(loginData) {
    this.userIsLogin = true;
    // this.userIsLoginSubject.next(true);
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
        this.user.next(new User(loginData.email, res.token));
        this.router.navigate(['/']);
        localStorage.setItem('token', res.token);
        // this.userIsLogin = true;
        // this.userIsLoginSubject.next(this.userIsLogin);
      });
  }

  autoLogin() {
    const saveToken = localStorage.getItem('token');
    if (saveToken) {
      this.user.next(new User('todo@todo.com', saveToken));
    }
  }

  signOut() {
    localStorage.removeItem('token');
    this.user.next(null);
  }

  ngOnInit(): void {}
}
