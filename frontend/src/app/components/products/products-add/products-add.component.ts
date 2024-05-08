import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IProduct, Product } from 'src/app/models/product.model';
import { IMaterial, Material } from 'src/app/models/material.model';
import { ProductsService } from 'src/app/services/products.service';
import { MaterialsService } from 'src/app/services/materials.service';

@Component({
  selector: 'app-products-add',
  templateUrl: './products-add.component.html',
  styleUrls: ['./products-add.component.scss'],
})
export class ProductsAddComponent implements OnInit {
  productForm: FormGroup;
  materialsList: IMaterial[] = [];
  formStep = 1;
  isFinish = null;

  formStep1Group: FormGroup;
  formStep2Group: FormGroup;
  formStep3Group: FormGroup;

  onNextStepHandler = () => {
    if (this.formStep < 3) {
      this.formStep++;
    } else {
      this.submitForm();
    }
  };
  onPrevStepHandler = () => {
    if (this.formStep > 1) {
      this.formStep--;
    }
  };

  submitForm = () => {
    this.isFinish = {
      '1': this.formStep1Group.value,
      '2': this.formStep2Group.value,
      '3': this.formStep3Group.value,
    };
    console.log(this.formStep1Group.value);
    console.log(this.formStep2Group.value);
    console.log(this.formStep3Group.value);

    this.router.navigate(['/', 'products', 'database']);
  };

  constructor(
    private productsService: ProductsService,
    private materialService: MaterialsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.formStep1Group = new FormGroup({
      name: new FormControl('pierwszy'),
      count: new FormControl(5),
    });

    this.formStep2Group = new FormGroup({
      name: new FormControl('drugi'),
      count: new FormControl(10),
    });

    this.formStep3Group = new FormGroup({
      name: new FormControl('trzeci'),
      count: new FormControl(15),
    });
  }

  // ngOnInit(): void {
  //   // this.materialsList = this.materialService.getMaterials();

  //   this.productForm = new FormGroup({
  //     productName: new FormControl(null, Validators.required),
  //     materialsForm: new FormArray([]),
  //   });
  // }

  // onAddProduct(): void {
  //   const resources: IMaterial[] = [
  //     // new Resource(0, 'Resource 1'),
  //   ];

  //   this.productForm.value.resourcesForm.map((material) => {
  //     // resources.push(new Resource(Math.random() * 1000, resource));
  //   });

  //   const newProduct = new Product(
  //     Math.random() * 1000,
  //     this.productForm.value.productName,
  //     this.materialsList
  //     // this.productForm.value.resource
  //   );

  //   if (this.productForm.valid) {
  //     this.productsService.addProduct(newProduct);
  //     this.router.navigate(['/', 'products', 'database']);
  //   }
  // }

  // onAddResource() {
  //   const control = new FormControl(null);
  //   (<FormArray>this.productForm.get('resourcesForm')).push(control);
  // }

  // getControls() {
  //   return (<FormArray>this.productForm.get('resourcesForm')).controls;
  // }
}
