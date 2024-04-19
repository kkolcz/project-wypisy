import { Component, OnInit } from '@angular/core';
import { UserAuthService } from './services/user-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  constructor(private userAuthService: UserAuthService) {}

  ngOnInit(): void {
    this.userAuthService.autoLogin();
  }
}
