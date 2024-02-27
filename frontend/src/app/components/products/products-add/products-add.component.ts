import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';

interface Product {
  name: string;
}

@Component({
  selector: 'app-products-add',
  templateUrl: './products-add.component.html',
  styleUrls: ['./products-add.component.scss'],
})
export class ProductsAddComponent implements OnInit {
  productForm: FormGroup;
  newProduct: Product = { name: '' };

  constructor(
    private productsService: ProductsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.productForm = new FormGroup({
      productName: new FormControl(null, Validators.required),
    });
  }

  onAddProduct(): void {
    this.productsService.addProduct({
      id: Math.random() * 1000,
      name: this.productForm.value.productName,
    });

    this.router.navigate(['/', 'products', 'database']);
    // console.log(this.newProduct.name);
  }
}
