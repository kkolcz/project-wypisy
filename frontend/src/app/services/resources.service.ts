import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IResource, Resource, IResourceRes } from '../models/resource.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ResourcesService {
  resourcesList = [];

  API_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  fetchResource(): Observable<IResourceRes> {
    return this.http.get<IResourceRes>(`${this.API_URL}/material/all`);
  }

  getResources(): IResource[] {
    this.fetchResource();
    console.log(this.resourcesList);
    return this.resourcesList.slice();
  }

  getResource(id: number): IResource {
    const resource = this.resourcesList.find((item) => item.id === id);
    return resource;
  }

  setResources() {}

  addResource(resource: IResource): void {
    this.resourcesList.push(resource);

    this.http
      .post(`${this.API_URL}/material/add`, resource)
      .subscribe((res) => {
        console.log(res);
        return res;
      });
  }

  setResource() {}
  removeResource() {}
}
