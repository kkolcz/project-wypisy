import { IMaterial } from './material.model';

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
  resources: IMaterial[];
}

export class Product {
  public id: number;
  public name: string;
  public resources: IMaterial[];

  constructor(id: number, name: string, resources: IMaterial[]) {
    this.id = id;
    this.name = name;
    this.resources = resources;
  }
}
