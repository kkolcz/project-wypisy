import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { CustomResponse } from '../models/CustomResponse';
import { Location } from '../models/location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

 public baseLoc:Subject<boolean>;
  locList:Location[]=[]

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { 
    this.baseLoc=new Subject<boolean>();
  }

getLocations(){return this.http.get<CustomResponse>(`${this.API_URL}/location/all`)
}
getLocation(locId:number){
  const params=new HttpParams().append('locationId',locId)
  return this.http.get<CustomResponse>(`${this.API_URL}/location/`,{params:params})

}
addLocation(loc:Location):void{
  this.http.post(`${this.API_URL}/location/add`,loc).subscribe((res) => {
    this.baseLoc.next(true);
    return res;
  });
  
}
setLocation(loc:Location):void{
  this.http.put(`${this.API_URL}/location/`,loc).subscribe((res) => {
    this.baseLoc.next(true);
    return res;
  });
  
}
deleLocation(locId:number):void{
  const params=new HttpParams().append('locationId',locId)
  this.http.delete<CustomResponse>(`${this.API_URL}/location/`,{params:params}).subscribe((res) => {
    this.baseLoc.next(true);
    return res;
  });
}








}
