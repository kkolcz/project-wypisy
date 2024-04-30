import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { Tool } from 'src/app/models/tool';
import { ToolsService } from 'src/app/services/tools.service';

@Component({
  selector: 'app-tools-add',
  templateUrl: './tools-add.component.html',
  styleUrls: ['./tools-add.component.scss']
})
export class ToolsAddComponent implements OnInit {

  toolForm: FormGroup;
  private staticTool=0;
  private tool:Tool;

  constructor(
    private toolService:ToolsService,
    private router: Router,
    private route:ActivatedRoute
   ){}


    ngOnInit(): void {

      this.route.paramMap.subscribe((params:ParamMap)=>{

          this.toolForm=new FormGroup({
            toolName: new FormControl(null,Validators.required),
            toolDescription: new FormControl(null,Validators.required),
          });
          
          if(params.has("id")){
            this.staticTool = parseInt(params.get('id')!);
          }

          if(this.staticTool>0){

            this.toolService.getTool(this.staticTool).subscribe((res:CustomResponse)=>{
              this.tool=res.data["Tool"]
              console.log(1)

              this.toolForm.setValue({

                toolName: this.tool.name,
                toolDescription: this.tool.description,

              })
            })
          }
      });      
    }
    
    onAddTool(){
      let ns:number
      if (this.toolForm.valid) {
       
        console.log(this.staticTool)
        if(this.staticTool===0){ns=Math.random() * 1000}else{ns=this.tool.id}
  
  
        const newTool = new Tool(
          ns,
          this.toolForm.value.toolName,
          this.toolForm.value.toolDescription,
     
        );
        if(this.staticTool===0){
          this.toolService.addTool(newTool);
        }
        else{
          this.toolService.setTool(newTool);
        }
        this.router.navigate(['/', 'tools', 'database']);
      }




    }

    onBack(){
      this.router.navigate(['/', 'tools', 'database']);
    }


}
