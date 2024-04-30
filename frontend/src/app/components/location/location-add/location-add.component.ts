import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { Location } from 'src/app/models/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location-add',
  templateUrl: './location-add.component.html',
  styleUrls: ['./location-add.component.scss']
})
export class LocationAddComponent  implements OnInit{

  locationForm:FormGroup;
  private staticLoc=0;
  private location:Location;



  constructor(
    private locService:LocationService,
    private router:Router,
    private route:ActivatedRoute
){}

  ngOnInit(): void {

    this.route.paramMap.subscribe((params:ParamMap)=>{

      this.locationForm=new FormGroup({
        locName: new FormControl(null,Validators.required),
        locDescription: new FormControl(null,Validators.required),
      });
      
      if(params.has("id")){
        this.staticLoc = parseInt(params.get('id')!);
      }

      if(this.staticLoc>0){

        this.locService.getLocation(this.staticLoc).subscribe((res:CustomResponse)=>{
          this.location=res.data["Location"]
          console.log(1)

          this.locationForm.setValue({

            locName: this.location.name,
            locDescription: this.location.description

          })
        })
      }
  });  



  }
  onAddTool(){
    let ns:number
    if (this.locationForm.valid) {
     
      console.log(this.staticLoc)
      if(this.staticLoc===0){ns=Math.random() * 1000}else{ns=this.location.id}


      const newLocation =new Location(
        ns,
        this.locationForm.value.locName,
        this.locationForm.value.locDescription,
   
      );

      if(this.staticLoc===0){
        this.locService.addLocation(newLocation);
      }
      else{
        this.locService.setLocation(newLocation);
      }
      this.router.navigate(['/', 'location', 'database']);
    }

  }


    onBack(){
      this.router.navigate(['/', 'location', 'database']);
    }


}
