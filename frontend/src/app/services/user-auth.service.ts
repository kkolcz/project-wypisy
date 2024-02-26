import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject, Subscription } from 'rxjs';

import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService implements OnInit {
  userIsLoginSubject = new Subject<boolean>();
  userIsLogin: boolean = true;

  userLogin: User = {
    id: 1,
    email: 'test@test.pl',
    name: 'Jan',
    surname: 'Kowalski',
    token: 'token:45234234',
  };

  isLogin() {
    return this.userIsLogin;
  }

  signIn() {
    this.userIsLogin = true;
    this.userIsLoginSubject.next(this.userIsLogin);
  }

  signOut() {
    this.userIsLogin = false;
    this.userIsLoginSubject.next(this.userIsLogin);
  }

  constructor() {}

  ngOnInit(): void {}
}
