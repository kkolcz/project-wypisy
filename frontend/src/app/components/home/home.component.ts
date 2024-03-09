import { Component, OnInit } from '@angular/core';
import { HttpApiService } from 'src/app/services/http-api.service';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
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
