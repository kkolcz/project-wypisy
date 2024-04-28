import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IMaterial, IMaterialRes,Material } from 'src/app/models/material.model';
import { MaterialsService } from 'src/app/services/materials.service';


@Component({
  selector: 'app-materials-database',
  templateUrl: './materials-database.component.html',
  styleUrls: ['./materials-database.component.scss'],
})
export class MaterialsDatabaseComponent implements OnInit {
  materialsList: IMaterial[] = [];

  constructor(
    private materialsService: MaterialsService,
    private router: Router
  ) {



  }

  ngOnInit(): void {
    this.materialsService.fetchMaterials().subscribe((res) => {
      this.materialsList = res.data['Materials'];
    });

    this.initGetMaterialsSub();
  }

  // Inicjalize subsribe for materialAdded
  initGetMaterialsSub() {
    this.materialsService.materialAdded.subscribe((data: boolean) => {
      this.materialsService.fetchMaterials().subscribe((res) => {
        this.materialsList = res.data['Materials'];
      });
    });
  }

  onAddNew() {
    this.router.navigate(['/', 'materials', 'add']);
  }

  onEdit(id:number){
    this.router.navigate(['/', 'materials', 'add',{id:id}]);
  }

  onDelete(materaialId:number){
    this.materialsService.delMaterial(materaialId);
  }


}
