import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject, Subscription } from 'rxjs';

import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService implements OnInit {
  userIsLoginSubject = new Subject<boolean>();
  userIsLogin: boolean = false;
  token: string = null;

  API_URL = 'http://localhost:8080/api/v1';

  userLogin: User = {
    id: 1,
    email: 'test@test.pl',
    name: 'Jan',
    surname: 'Kowalski',
    token: 'token:45234234',
  };

  constructor(private router: Router, private http: HttpClient) {}

  isLogin() {
    return this.userIsLogin;
  }

  signIn(loginData) {
    this.userIsLogin = true;
    this.userIsLoginSubject.next(true);
    // console.log(loginData);

    const data = { email: loginData.email, password: loginData.password };
    console.log(data);
    this.http
      .post(`${this.API_URL}/auth/authenticate`, data)
      .subscribe((res) => {
        console.log(res);
      });

    const tempToken = 'token:45234234';

    if (false) {
      this.router.navigate(['/']);
      this.token = tempToken;
      localStorage.setItem('token', tempToken);
    }
  }

  signOut() {
    this.userIsLogin = false;
    this.userIsLoginSubject.next(this.userIsLogin);
  }

  ngOnInit(): void {}
}
