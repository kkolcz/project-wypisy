import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomResponse } from 'src/app/models/CustomResponse';
import { Process } from 'src/app/models/process.model';
import { ProcessesService } from 'src/app/services/processes.service';

@Component({
  selector: 'app-processes-database',
  templateUrl: './processes-database.component.html',
  styleUrls: ['./processes-database.component.scss']
})
export class ProcessesDatabaseComponent implements OnInit{

  public processList:Process[]=[]


  constructor(
    private procesService:ProcessesService,
    private router:Router
  ){}
  ngOnInit(): void {
  
  
    this.initSub();
    this.procesService.setWorking(true);
  }
  initSub() {
    this.procesService.baseProcess.subscribe((data: boolean) => {
      console.log(data)
      this.procesService.getAll().subscribe((rs:CustomResponse)=>{this.processList=rs.data["Processes"]});
    });
  }
  onAddNew() {this.router.navigate(['/', 'processes', 'add']);}
  onEdit(id:number){this.router.navigate(['/', 'processes', 'add',{id:id}]);}
  onDelete(id:number){this.procesService.delete(id);}


}
