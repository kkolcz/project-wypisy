import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MachineProgram } from '../models/machineProgram';
import { Subject } from 'rxjs';
import { CustomResponse } from '../models/CustomResponse';

@Injectable({
  providedIn: 'root'
})
export class MachineProgramService {

  machineProgram:MachineProgram[]=[];
  public baseProgram:Subject<boolean>;
  
  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http:HttpClient) { this.baseProgram= new Subject<boolean>(); }

  getMachinePrograms(){return this.http.get<CustomResponse>(`${this.API_URL}/program/all`)}

  getMachineProgram(programId:number){
    const params=new HttpParams().append('programId',programId)
    return this.http.get<CustomResponse>(`${this.API_URL}/program/`,{params:params})
  }
  add(program:MachineProgram):void{
    this.http.post(`${this.API_URL}/program/add`,program).subscribe((res) => {
      //this.baseProgram.next(true);
      return res;
    });
  }
  set(program:MachineProgram):void{
    this.http.put(`${this.API_URL}/program/`,program).subscribe((res) => {
      //this.baseProgram.next(true);
      return res;
    });
  }
  delete(programId:number):void{
    const params=new HttpParams().append('programId',programId)
    this.http.delete<CustomResponse>(`${this.API_URL}/program/`,{params:params}).subscribe((res) => {
      //this.baseProgram.next(true);
      return res;
    });
  }
  setWorking(isWorking: boolean) {
    this.baseProgram.next(isWorking)
  }



}
