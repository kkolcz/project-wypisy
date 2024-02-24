import { Component } from '@angular/core';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  user: string = '';
  password: string = '';

  constructor(private userAuthService: UserAuthService) {}

  onLogin(): void {
    if (this.user === 'default' || this.password === '') {
      return;
    }
    this.userAuthService.signIn();
    // alert(`${this.user} ${this.password}`);
  }
}
