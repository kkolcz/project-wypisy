import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  isLogin: boolean = this.userAuthService.isLogin();

  constructor(
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  onSignInOut() {
    if (this.isLogin) {
      this.userAuthService.signOut();
      this.router.navigate(['/']);
    } else {
      this.router.navigate(['/', 'login']);
    }
  }

  ngOnInit(): void {
    this.userAuthService.userIsLoginSubject.subscribe((isLogin) => {
      this.isLogin = isLogin;
    });
  }
}
