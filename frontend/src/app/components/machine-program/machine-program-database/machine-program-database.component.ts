import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { MachineProgram } from 'src/app/models/machineProgram';
import { MachineProgramService } from 'src/app/services/machine-program.service';

@Component({
  selector: 'app-machine-program-database',
  templateUrl: './machine-program-database.component.html',
  styleUrls: ['./machine-program-database.component.scss']
})
export class MachineProgramDatabaseComponent implements OnInit{


public programList:MachineProgram[]=[];

constructor(
  private programService:MachineProgramService,
  
  private router:Router
){


    
}
ngOnInit(): void {
  
  
  this.initSub();
  this.programService.setWorking(true);
}
initSub() {
  this.programService.baseProgram.subscribe((data: boolean) => {
    console.log(data)
    this.programService.getMachinePrograms().subscribe((rs:CustomResponse)=>{this.programList=rs.data["MachinePrograms"]});
  });
}

onAddNew() {this.router.navigate(['/', 'program', 'add']);}
onEdit(id:number){this.router.navigate(['/', 'program', 'add',{id:id}]);}
onDelete(id:number){this.programService.delete(id);}


}
