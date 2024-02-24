import { Component, OnInit } from '@angular/core';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  isLogin: boolean = this.userAuthService.isLogin();

  constructor(private userAuthService: UserAuthService) {}

  ngOnInit(): void {
    this.userAuthService.userIsLoginSubject.subscribe((isLogin) => {
      this.isLogin = isLogin;
    });
  }
}
