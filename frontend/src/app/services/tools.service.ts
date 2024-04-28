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
   this.baseTool.next(true);
  
  }

   
}
