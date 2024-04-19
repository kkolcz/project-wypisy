import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  signinForm: FormGroup;

  constructor(private userAuthService: UserAuthService) {}

  ngOnInit(): void {
    this.signinForm = new FormGroup({
      email: new FormControl('admin@gmail.com', Validators.required),
      password: new FormControl('pass123', Validators.required),
    });
  }

  onLogin(): void {
    if (this.signinForm.valid) {
      this.userAuthService.signIn(this.signinForm.value);
    }
  }
}
