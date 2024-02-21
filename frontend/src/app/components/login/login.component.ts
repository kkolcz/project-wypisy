import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  user: string = '';
  password: string = '';

  onLogin(): void {
    if (this.user === 'default' || this.password === '') {
      return;
    }
    alert(`${this.user} ${this.password}`);
  }
}
