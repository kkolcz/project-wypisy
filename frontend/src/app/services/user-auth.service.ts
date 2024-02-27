import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject, Subscription } from 'rxjs';

import { User } from '../models/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService implements OnInit {
  userIsLoginSubject = new Subject<boolean>();
  userIsLogin: boolean = false;

  userLogin: User = {
    id: 1,
    email: 'test@test.pl',
    name: 'Jan',
    surname: 'Kowalski',
    token: 'token:45234234',
  };

  constructor(private router: Router) {}

  isLogin() {
    return this.userIsLogin;
  }

  signIn(loginData) {
    this.userIsLogin = true;
    this.userIsLoginSubject.next(true);
    console.log(loginData);
    if (true) {
      this.router.navigate(['/']);
    }
  }

  signOut() {
    this.userIsLogin = false;
    this.userIsLoginSubject.next(this.userIsLogin);
  }

  ngOnInit(): void {}
}
