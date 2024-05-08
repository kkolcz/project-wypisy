import { Location } from "./location";
import { MachineProgram } from "./machineProgram";
import { processCategory } from "./processCategory";
import { Tool } from "./tool";

export interface IProcess {}

export interface IProcessRes {}

export class Process {
  public id:number
  public name: string;
  public category?: processCategory;
  public time: string;
  public toolList?:Tool[]=[]
  public programList?:MachineProgram[]=[]
  public location?:Location

  constructor(
    id:number,
    name: string,
    category: processCategory,
    time: string,
    toolList: Tool[],
    programList:MachineProgram[],
    location:Location
  ) {
     this.id=id
    this.name = name;
    this.category = category;
    this.time = time;
    this.toolList=toolList;
    this.programList=programList;
    this.location=location

  }
}
