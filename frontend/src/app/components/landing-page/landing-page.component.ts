import { Component, OnInit } from '@angular/core';
import { HttpApiService } from 'src/app/services/http-api.service';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss'],
})
export class LandingPageComponent implements OnInit {
  isLogin: boolean = this.userAuthService.isLogin();

  constructor(
    private userAuthService: UserAuthService,
    private httpApi: HttpApiService
  ) {}

  ngOnInit(): void {
    this.httpApi.getProducts();
    this.userAuthService.userIsLoginSubject.subscribe((isLogin) => {
      this.isLogin = isLogin;
    });
  }
}
