import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserAuthService } from 'src/app/services/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  // user: string = '';
  // password: string = '';
  signinForm: FormGroup;

  constructor(private userAuthService: UserAuthService) {}

  ngOnInit(): void {
    this.signinForm = new FormGroup({
      email: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required),
    });
  }

  onLogin(): void {
    // if (this.user === 'default' || this.password === '') {
    //   return;
    // }

    // console.log(this.signinForm.value);

    if (this.signinForm.valid) {
      this.userAuthService.signIn(this.signinForm.value);
    }
    // alert(`${this.user} ${this.password}`);
  }
}
