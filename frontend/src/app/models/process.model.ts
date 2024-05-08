export interface IProcess {}

export interface IProcessRes {}

export class Process {
  public name: string;
  public category: string;
  public localization: string;
  public time: string;

  constructor(
    name: string,
    category: string,
    localization: string,
    time: string
  ) {
    this.name = name;
    this.category = category;
    this.localization = localization;
    this.time = time;
  }
}
