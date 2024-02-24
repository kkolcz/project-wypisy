import { Component, OnInit } from '@angular/core';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  isLogin: boolean = this.userAuthService.isLogin();

  constructor(private userAuthService: UserAuthService) {}

  onSignOut() {
    this.userAuthService.signOut();
  }

  ngOnInit(): void {
    this.userAuthService.userIsLoginSubject.subscribe((isLogin) => {
      this.isLogin = isLogin;
    });
  }
}
