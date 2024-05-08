import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { MachineProgram } from 'src/app/models/machineProgram';
import { Process } from 'src/app/models/process.model';
import { Tool } from 'src/app/models/tool';
import { MachineProgramService } from 'src/app/services/machine-program.service';
import { ProcessesService } from 'src/app/services/processes.service';
import { ToolsService } from 'src/app/services/tools.service';

@Component({
  selector: 'app-processes-add',
  templateUrl: './processes-add.component.html',
  styleUrls: ['./processes-add.component.scss'],
})
export class ProcessesAddComponent implements OnInit {
  
  
  toolList:Tool[]=[];
  programList:MachineProgram[]=[];

  processForm: FormGroup;
   process:Process
  private staticProcess=0;

  constructor(
    private processService:ProcessesService,
    private toolService:ToolsService,
    private programService:MachineProgramService,
    private router:Router,
    private route:ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.toolService.getTools().subscribe((rs:CustomResponse)=>{this.toolList=rs.data["Tools"]});
    this.programService.getMachinePrograms().subscribe((rs:CustomResponse)=>{this.programList=rs.data["MachinePrograms"]});

    


    this.route.paramMap.subscribe((params:ParamMap)=>{
      let toolArray = new FormArray([]);
      let programArray = new FormArray([]);



      this.processForm=new FormGroup({
        name:new FormControl(null, Validators.required),
        categoryName:new FormControl(null, Validators.required),
        time:new FormControl(null, Validators.required),
        nameLocation:new FormControl(null, Validators.required),
        tools:toolArray,
        programs:programArray
       

      });

      if(params.has("id")){
        this.staticProcess = parseInt(params.get('id')!);
      }

      if(this.staticProcess>0){
        this.processService.getId(this.staticProcess).subscribe((res:CustomResponse)=>{

          this.process=res.data["Process"]

       

          this.processForm.setValue({
            name:this.process.name,
            categoryName:this.process.category.name,
            time:this.process.time,
            nameLocation:this.process.location,
            tools:toolArray,
            programs:programArray

          });

        });
      }




 
    });
  }

}
