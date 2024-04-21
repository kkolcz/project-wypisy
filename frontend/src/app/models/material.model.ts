export interface IMaterial {
  id: number;
  name: string;
  description: string;
  length: number;
  width: number;
  height: number;
}

export interface IMaterialRes {
  timeStamp: string;
  statusCode: number;
  status: string;
  message: string;
  data: any;
}

export class Material {
  public id: number;
  public name: string;
  public description: string;
  public length: number;
  public width: number;
  public height: number;

  constructor(
    id: number,
    name: string,
    description: string,
    length: number,
    width: number,
    height: number
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.length = length;
    this.width = width;
    this.height = height;
  }
}
