import { IResource } from './resource.model';

export interface IProductsRes {
  timeStamp: string;
  statusCode: number;
  status: string;
  message: string;
  data: any;
}

export interface IProductt {
  id: number;
  name: string;
  nrM3: string;
  nameM3: string;
  description: string;
  elementList: IElement[];
}

export interface IElement {
  name: string;
}

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
