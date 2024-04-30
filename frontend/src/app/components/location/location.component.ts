import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {



  constructor(){}

  ngOnInit(): void {
  }
 
}
