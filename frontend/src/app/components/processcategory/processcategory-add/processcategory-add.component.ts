import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {  ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { processCategory } from 'src/app/models/processCategory';
import { ProcessCategoryService } from 'src/app/services/process-category.service';
import { ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-processcategory-add',
  templateUrl: './processcategory-add.component.html',


  styleUrls: ['./processcategory-add.component.scss']
})
export class ProcesscategoryAddComponent implements OnInit{

 public departments:String[] = [
  "STOLARNIA","MONTAZ",
  ];

  public department?:string="STOLARNIA";
  catForm:FormGroup;
   private staticCat=0;
   private category:processCategory;

  constructor(
    private categoryService:ProcessCategoryService,
    private router:Router,
    private route:ActivatedRoute
  ){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params:ParamMap)=>{

      this.catForm=new FormGroup({
        catName: new FormControl(null,Validators.required),
        catDepartment: new FormControl(null,Validators.required),
        catDescription: new FormControl(null,Validators.required),
      });
      if(params.has("id")){
        this.staticCat = parseInt(params.get('id')!);
      }
      if(this.staticCat>0){

        this.categoryService.getProcessCategory(this.staticCat).subscribe((res:CustomResponse)=>{
          this.category=res.data["processCategory"]
          
          console.log(this.category)


          this.catForm.setValue({

            catName: this.category.name,
            catDepartment: this.category.department,
            catDescription: this.category.description

          })
        })
      }


    })


  }

  onAddTool(){
    let ns:number
    if (this.catForm.valid) {
     
      console.log(this.staticCat)
      if(this.staticCat===0){ns=Math.random() * 1000}else{ns=this.category.id}


      const newCat=new processCategory(
        ns,
        this.catForm.value.catName,
        this.catForm.value.catDepartment,
        this.catForm.value.catDescription,
   
      );
      console.log(newCat)

      if(this.staticCat===0){
        this.categoryService.add(newCat);
      }
      else{
        this.categoryService.set(newCat);
      }
      this.router.navigate(['/', 'processcategory', 'database']);
    }
    else{console.log("f")}

  }

  onBack(){
    this.router.navigate(['/', 'processcategory', 'database']);
  }







}
