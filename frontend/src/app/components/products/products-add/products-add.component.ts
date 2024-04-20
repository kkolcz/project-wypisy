import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IProduct, Product } from 'src/app/models/product.model';
import { IResource, Resource } from 'src/app/models/resource.model';
import { ProductsService } from 'src/app/services/products.service';
import { ResourcesService } from 'src/app/services/resources.service';

@Component({
  selector: 'app-products-add',
  templateUrl: './products-add.component.html',
  styleUrls: ['./products-add.component.scss'],
})
export class ProductsAddComponent implements OnInit {
  productForm: FormGroup;
  resourcesList: IResource[] = [];

  constructor(
    private productsService: ProductsService,
    private resourcesService: ResourcesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.resourcesList = this.resourcesService.getResources();

    this.productForm = new FormGroup({
      productName: new FormControl(null, Validators.required),
      resourcesForm: new FormArray([]),
    });
  }

  onAddProduct(): void {
    const resources: IResource[] = [
      // new Resource(0, 'sdf'),
      // new Resource(1, 'fgf'),
      // new Resource(2, 'dfgdfg'),
    ];

    this.productForm.value.resourcesForm.map((resource) => {
      // resources.push(new Resource(Math.random() * 1000, resource));
    });
    // console.log(resources);
    // console.log(this.productForm.value.resourcesForm);

    const newProduct = new Product(
      Math.random() * 1000,
      this.productForm.value.productName,
      resources
      // this.productForm.value.resource
    );

    // console.log(newProduct);

    if (this.productForm.valid) {
      this.productsService.addProduct(newProduct);
      this.router.navigate(['/', 'products', 'database']);
    }

    // console.log(this.newProduct.name);
  }

  onAddResource() {
    const control = new FormControl(null);
    (<FormArray>this.productForm.get('resourcesForm')).push(control);
  }

  getControls() {
    return (<FormArray>this.productForm.get('resourcesForm')).controls;
  }
}
