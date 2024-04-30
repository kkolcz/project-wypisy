import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { HttpClient,HttpParams } from '@angular/common/http';
import { CustomResponse } from '../models/CustomResponse';
import { Tool } from '../models/tool';


@Injectable({
  providedIn: 'root'
})
export class ToolsService {

  baseTool: Subject<boolean>;
  toolList:Tool[ ]=[]

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {

    this.baseTool = new Subject<boolean>();
   }


getTools():any{

   return this.http.get<CustomResponse>(`${this.API_URL}/tool/all`)
   
  }

  getTool(toolId:number){
    const params = new HttpParams().append('toolId',toolId );
    return this.http.get<CustomResponse>(`${this.API_URL}/tool/`,{params:params})
  }

  addTool(tool:Tool):void{
    this.http.post(`${this.API_URL}/tool/add`,tool).subscribe((res) => {
      this.baseTool.next(true);
      return res;
    });

  }
  setTool(tool:Tool):void{
    this.http.put(`${this.API_URL}/tool/`,tool).subscribe((res) => {
      this.baseTool.next(true);
      return res;
    });

  }

  deleTool(id:number):void{

    const params = new HttpParams().append('toolId', id );
  
    this.http
    .delete(`${this.API_URL}/tool/`,{params:params} ).subscribe((res) => {
      this.baseTool.next(true);
      return res;
    });
  }




   
}
