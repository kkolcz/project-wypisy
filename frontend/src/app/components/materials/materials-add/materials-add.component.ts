import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap,Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { IMaterial, Material } from 'src/app/models/material.model';
import { MaterialsService } from 'src/app/services/materials.service';

@Component({
  selector: 'app-materials-add',
  templateUrl: './materials-add.component.html',
  styleUrls: ['./materials-add.component.scss'],
})
export class MaterialsAddComponent implements OnInit {
  materialForm: FormGroup;
  private staticMateraial=0;
 
  private material:Material;
  constructor(
    
    private materialsService: MaterialsService,
    
    private router: Router,
    private  route:ActivatedRoute
  ) {
   
    
  }

  ngOnInit(): void {this.route.paramMap.subscribe((params:ParamMap)=> {


    this.materialForm = new FormGroup({
      materialName: new FormControl(null, Validators.required),
      materialDescription: new FormControl(null, Validators.required),
      materialLength: new FormControl(null, Validators.required),
      materialWidth: new FormControl(null, Validators.required),
      materialHeight: new FormControl(null, Validators.required),
    });

    if(params.has("id")){
      this.staticMateraial = parseInt(params.get('id')!);
    }
  
    
  
  if(this.staticMateraial>0) {

    this.materialsService.getMaterialNew(this.staticMateraial).subscribe((rs:CustomResponse)=>{

        this.material=rs.data["Material"]

        this.materialForm.setValue({

          materialName: this.material.name,
          materialDescription: this.material.description,
          materialLength: this.material.length,
          materialWidth: this.material.width,
          materialHeight: this.material.height


        })

    })
  } 
  
  
  
  });


  }

  onAddMaterial() {
    // console.log(this.materialForm.value);
   let ns:number
    if (this.materialForm.valid) {
     
      console.log(this.staticMateraial)
      if(this.staticMateraial===0){ns=Math.random() * 1000}else{ns=this.material.id}


      const newMaterial = new Material(
        ns,
        this.materialForm.value.materialName,
        this.materialForm.value.materialDescription,
        this.materialForm.value.materialLength,
        this.materialForm.value.materialWidth,
        this.materialForm.value.materialHeight
      );
      if(this.staticMateraial===0){
        this.materialsService.addMaterial(newMaterial);
      }
      else{
        this.materialsService.setMaterial(newMaterial);
      }








      this.router.navigate(['/', 'materials', 'database']);
    }

    // console.log(this.materialForm.value.materialName);
  }
  onBack(){this.router.navigate(['/', 'materials', 'database']);}
}

