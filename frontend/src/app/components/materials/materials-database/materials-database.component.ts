import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IMaterial, IMaterialRes } from 'src/app/models/material.model';
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
  ) {}

  ngOnInit(): void {
    this.materialsService.fetchMaterials().subscribe((res) => {
      this.materialsList = res.data['Materials'];
    });
    console.log(this.materialsList);
  }

  onAddNew() {
    this.router.navigate(['/', 'materials', 'add']);
  }
}
