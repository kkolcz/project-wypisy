import { IResource } from './resource.model';

export interface IProduct {
  id: number;
  name: string;
  resources: IResource[];
}

export class Product {
  public id: number;
  public name: string;
  public resources: IResource[];

  constructor(id: number, name: string, resources: IResource[]) {
    this.id = id;
    this.name = name;
    this.resources = resources;
  }
}
