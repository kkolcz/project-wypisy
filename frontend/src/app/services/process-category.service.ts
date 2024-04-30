import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { processCategory } from '../models/processCategory';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CustomResponse } from '../models/CustomResponse';

@Injectable({
  providedIn: 'root'
})
export class ProcessCategoryService {

  public baseCategory:Subject<boolean>;
  categoryList:processCategory[]=[]

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http:HttpClient) {  this.baseCategory=new Subject<boolean>(); }


  getProcessCategories(){return this.http.get<CustomResponse>(`${this.API_URL}/process-category/all`)}

  getProcessCategory(categoryId:number){
    const params=new HttpParams().append('pcategoryId',categoryId)
    return this.http.get<CustomResponse>(`${this.API_URL}/process-category/`,{params:params})
  }
  add(category:processCategory):void{
    this.http.post(`${this.API_URL}/process-category/add`,category).subscribe((res) => {
      this.baseCategory.next(true);
      return res;
    });
  }
  set(category:processCategory):void{
    this.http.put(`${this.API_URL}/process-category/`,category).subscribe((res) => {
      this.baseCategory.next(true);
      return res;
    });
    
  }
  delete(categoryId:number):void{
    const params=new HttpParams().append('pcategoryId',categoryId)
    this.http.delete<CustomResponse>(`${this.API_URL}/process-category/`,{params:params}).subscribe((res) => {
      this.baseCategory.next(true);
      return res;
    });
  }








}
