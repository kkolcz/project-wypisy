import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMaterial, Material, IMaterialRes } from '../models/material.model';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MaterialsService {
  materialsList = [];
  materialsListSub = new BehaviorSubject([]);

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  fetchMaterials(): Observable<IMaterialRes> {
    return this.http.get<IMaterialRes>(`${this.API_URL}/material/all`);
  }

  getMaterials(): IMaterial[] {
    this.fetchMaterials();
    console.log(this.materialsList);
    return this.materialsList.slice();
  }

  getMaterial(id: number): IMaterial {
    const material = this.materialsList.find((item) => item.id === id);
    return material;
  }

  setMaterials() {}

  addMaterial(material: IMaterial): void {
    console.log(this.materialsList);
    this.materialsList.push(material);
    this.materialsListSub.next(this.materialsList);
    console.log(this.materialsList);

    // console.log(this.materialsList);

    this.http
      .post(`${this.API_URL}/material/add`, material)
      .subscribe((res) => {
        // console.log(res);
        return res;
      });
  }

  setMaterial() {}
  removeMaterial() {}
}
