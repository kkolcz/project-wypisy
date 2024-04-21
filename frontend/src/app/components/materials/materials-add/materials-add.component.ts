import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IMaterial, Material } from 'src/app/models/material.model';
import { MaterialsService } from 'src/app/services/materials.service';

@Component({
  selector: 'app-materials-add',
  templateUrl: './materials-add.component.html',
  styleUrls: ['./materials-add.component.scss'],
})
export class MaterialsAddComponent implements OnInit {
  materialForm: FormGroup;

  constructor(
    private materialsService: MaterialsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.materialForm = new FormGroup({
      materialName: new FormControl(null, Validators.required),
      materialDescription: new FormControl(null, Validators.required),
      materialLength: new FormControl(null, Validators.required),
      materialWidth: new FormControl(null, Validators.required),
      materialHeight: new FormControl(null, Validators.required),
    });
  }

  onAddMaterial() {
    // console.log(this.materialForm.value);

    if (this.materialForm.valid) {
      const newmaterial = new Material(
        Math.random() * 1000,
        this.materialForm.value.materialName,
        this.materialForm.value.materialDescription,
        this.materialForm.value.materialLength,
        this.materialForm.value.materialWidth,
        this.materialForm.value.materialHeight
      );

      this.materialsService.addMaterial(newmaterial);
      this.router.navigate(['/', 'materials', 'database']);
    }

    // console.log(this.materialForm.value.materialName);
  }
}
