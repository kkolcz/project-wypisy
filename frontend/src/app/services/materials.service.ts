import { HttpClient,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMaterial, Material, IMaterialRes } from '../models/material.model';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import {CustomResponse} from "../models/CustomResponse";

@Injectable({
  providedIn: 'root',
})
export class MaterialsService {
  materialsList = [];
  materialsListSub = new BehaviorSubject([]);
  materialAdded: Subject<boolean>;

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {
    this.materialAdded = new Subject<boolean>();
  }

  fetchMaterials(): Observable<IMaterialRes> {
    return this.http.get<IMaterialRes>(`${this.API_URL}/material/all`);
  }

  // getMaterials(): IMaterial[] {
  //   // this.fetchMaterials();
  //   return this.materialsList.slice();
  // }

  getMaterial(id: number): IMaterial {
    const material = this.materialsList.find((item) => item.id === id);
    return material;
  }

  setMaterials() {}

  addMaterial(material: IMaterial): void {
    this.materialsListSub.next(this.materialsList);

    this.http
      .post(`${this.API_URL}/material/add`, material)
      .subscribe((res) => {
        this.materialAdded.next(true);
        return res;
      });
  }




  delMaterial(id:number):void{

    const params = new HttpParams().append('materialId', id );
  
    this.http
    .delete(`${this.API_URL}/material/`,{params:params} ).subscribe((res) => {
      this.materialAdded.next(true);
      return res;
    });
  }

  getMaterialNew(materialId:number): Observable<CustomResponse>{
    const params = new HttpParams().append('materialId', materialId);
    return this.http.get<CustomResponse>(`${this.API_URL}/material/`,{params:params});
  }


  setMaterial(material:Material) {
    this.http.put(`${this.API_URL}/material/`, material)
    .subscribe((res) => {
      this.materialAdded.next(true);
      return res;
    });
  }





  removeMaterial() {}
}
