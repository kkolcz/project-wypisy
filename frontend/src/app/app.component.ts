import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    const savedToken: string = localStorage.getItem('token');
    if (savedToken) {
      console.log(savedToken);
    } else {
      console.log('Nie zalogowano');
    }
  }
}
