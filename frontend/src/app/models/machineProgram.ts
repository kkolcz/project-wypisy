export class MachineProgram {
    public id:number;
    public nameMachine: string;
    public nrProgram: string;
    public description: string;
    public qtyForProgram: number;


    constructor(
        id:number,
        nameMachine: string,
        nrProgram: string,
        description: string,
        qtyForProgram: number,

    ){
        this.id=id
        this.nameMachine=nameMachine
        this.nrProgram=nrProgram
        this.description=description
        this.qtyForProgram=qtyForProgram
    }

}