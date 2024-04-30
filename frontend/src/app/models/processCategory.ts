import { DEPARTMENT } from "../ENUMS/DEPARTMENT";

export class processCategory {
    public id:number;
    public name: string;
    public department:string;
    public description: string;


    constructor(
        id:number,
        name: string,
        department:string,
        description: string

    ){
        this.id=id;
        this.name=name;
        this.department=department;
        this.description=description;
    }



}  
