import { Injectable } from '@angular/core';
import { IResource, Resource } from '../models/resource.model';

@Injectable({
  providedIn: 'root',
})
export class ResourcesService {
  resourcesList = [
    new Resource(0, 'Resource 0'),
    new Resource(1, 'Resource 1'),
    new Resource(2, 'Resource 2'),
  ];

  getResources(): IResource[] {
    // console.log(this.resourcesList);
    return this.resourcesList.slice();
  }

  getResource(id: number): IResource {
    const resource = this.resourcesList.find((item) => item.id === id);
    return resource;
  }

  setResources() {}

  addResource(resource: IResource): void {
    this.resourcesList.push(resource);
  }

  setResource() {}
  removeResource() {}

  constructor() {}
}
