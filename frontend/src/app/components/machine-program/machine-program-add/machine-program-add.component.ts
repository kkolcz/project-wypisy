import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { MachineProgram } from 'src/app/models/machineProgram';
import { MachineProgramService } from 'src/app/services/machine-program.service';

@Component({
  selector: 'app-machine-program-add',
  templateUrl: './machine-program-add.component.html',
  styleUrls: ['./machine-program-add.component.scss']
})
export class MachineProgramAddComponent implements OnInit {

  programForm:FormGroup;
  
  private staticProgram=0;
  private program:MachineProgram;

  constructor(
    private programService:MachineProgramService,
    private router:Router,
    private route:ActivatedRoute
  ){}

  ngOnInit(): void {

    this.route.paramMap.subscribe((params:ParamMap)=>{

      this.programForm=new FormGroup({
        nameMachine:new FormControl(null, Validators.required),
        nrProgram:new FormControl(null, Validators.required),
        description:new FormControl(null, Validators.required),
        qtyForProgram:new FormControl(null, Validators.required),
       

      });
      
      if(params.has("id")){
        this.staticProgram = parseInt(params.get('id')!);
      }

      if(this.staticProgram>0){
        this.programService.getMachineProgram(this.staticProgram).subscribe((res:CustomResponse)=>{

          this.program=res.data["machineProgram"]

          this.programForm.setValue({
            nameMachine:this.program.nameMachine,
            nrProgram:this.program.nrProgram,
            description:this.program.description,
            qtyForProgram:this.program.qtyForProgram
          });
        });
      }
    });
  }

  onAdd(){
    let ns:number
    console.log(1)
    if (this.programForm.valid) {

      if(this.staticProgram===0){ns=Math.random() * 1000}else{ns=this.program.id}


      const newProgram=new MachineProgram(
        ns,
        this.programForm.value.nameMachine,
        this.programForm.value.nrProgram,
        this.programForm.value.description,
        this.programForm.value.qtyForProgram
        
      );
      console.log(newProgram)
      if(this.staticProgram===0){
        this.programService.add(newProgram);
      }
      else{
        this.programService.set(newProgram);
      }
      this.router.navigate(['/', 'program', 'database']);
    }
  
    }

    onBack(){
      this.router.navigate(['/', 'program', 'database']);
    }
    
  }








