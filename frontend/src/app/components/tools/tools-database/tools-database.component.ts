import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { Tool } from 'src/app/models/tool';
import { ToolsService } from 'src/app/services/tools.service';

@Component({
  selector: 'app-tools-database',
  templateUrl: './tools-database.component.html',
  styleUrls: ['./tools-database.component.scss']
})
export class ToolsDatabaseComponent implements OnInit {
 public toolList:Tool[]=[];

  constructor(
    private toolService:ToolsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.toolService.getTools().subscribe((rs:CustomResponse)=>{ this.toolList=rs.data["Tools"] });
   this.initSub();
  }

  initSub() {
    this.toolService.baseTool.subscribe((data: boolean) => {
      this.toolService.getTools().subscribe((rs:CustomResponse)=>{

        this.toolList=rs.data["Tools"]

      });
    });
  }

  onAddNew() {
    this.router.navigate(['/', 'tools', 'add']);
  }

  onEdit(id:number){
    this.router.navigate(['/', 'tools', 'add',{id:id}]);
  }

  onDelete(toolId:number){
    this.toolService.deleTool(toolId);
  }
  




}
