import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { processCategory } from 'src/app/models/processCategory';
import { ProcessCategoryService } from 'src/app/services/process-category.service';

@Component({
  selector: 'app-processcategory-database',
  templateUrl: './processcategory-database.component.html',
  styleUrls: ['./processcategory-database.component.scss']
})
export class ProcesscategoryDatabaseComponent implements OnInit{

public categoryList:processCategory[]=[]

  constructor(
    private categoryService:ProcessCategoryService,
    private router:Router
  ){}

  




  ngOnInit(): void {
    this.categoryService.getProcessCategories().subscribe((rs:CustomResponse)=>{this.categoryList=rs.data["Categories"]});
    this.initSub();
  }
  initSub() {
    this.categoryService.baseCategory.subscribe((data: boolean) => {
      this.categoryService.getProcessCategories().subscribe((rs:CustomResponse)=>{this.categoryList=rs.data["Categories"]});
    });
  }

  onAddNew() {
    this.router.navigate(['/', 'processcategory', 'add']);
  }

  onEdit(id:number){this.router.navigate(['/', 'processcategory', 'add',{id:id}]);}

  onDelete(id:number){this.categoryService.delete(id);}}
