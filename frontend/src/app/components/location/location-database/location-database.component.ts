import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { Location } from 'src/app/models/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location-database',
  templateUrl: './location-database.component.html',
  styleUrls: ['./location-database.component.scss']
})
export class LocationDatabaseComponent implements OnInit {



  public locList:Location[]=[];

  constructor(
    private locService:LocationService,
    private router: Router

  ){}

  ngOnInit(): void {
    this.locService.getLocations().subscribe((rs:CustomResponse)=>{this.locList=rs.data["Locations"]});
    this.initSub();
  }
  initSub() {
    this.locService.baseLoc.subscribe((data: boolean) => {
      this.locService.getLocations().subscribe((rs:CustomResponse)=>{
        this.locList=rs.data["Locations"]
      });
    });
  }
  onAddNew() {
    this.router.navigate(['/', 'location', 'add']);
  }

  onEdit(id:number){
    this.router.navigate(['/', 'location', 'add',{id:id}]);
  }

  onDelete(locId:number){
    this.locService.deleLocation(locId);
  }

}
