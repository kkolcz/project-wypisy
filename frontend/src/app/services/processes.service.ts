import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { CustomResponse } from '../models/CustomResponse';

@Injectable({
  providedIn: 'root'
})
export class ProcessesService {

  public baseProcess:Subject<boolean>
  API_URL = 'http://localhost:8080/api/v1';

  constructor(
    private http:HttpClient
  ) { 
    this.baseProcess=new Subject<boolean>();
  }

  setWorking(isWorking: boolean) {
    this.baseProcess.next(isWorking)
  }


  getAll(){return this.http.get<CustomResponse>(`${this.API_URL}/process/all`)}


  delete(id:number):void{
    const params=new HttpParams().append('processId',id)
    this.http.delete<CustomResponse>(`${this.API_URL}/process/`,{params:params}).subscribe((res) => {

      return res;
    });
  }
}
