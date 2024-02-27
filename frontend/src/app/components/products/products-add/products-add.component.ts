import { Component } from '@angular/core';
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
export class ProductsAddComponent {
  newProduct: Product = { name: '' };

  constructor(
    private productsService: ProductsService,
    private router: Router
  ) {}

  onAddProduct(): void {
    this.productsService.addProduct({
      id: Math.random() * 1000,
      name: this.newProduct.name,
    });

    this.router.navigate(['/', 'products', 'database']);
    // console.log(this.newProduct.name);
  }
}
