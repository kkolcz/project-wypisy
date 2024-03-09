import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products-database',
  templateUrl: './products-database.component.html',
  styleUrls: ['./products-database.component.scss'],
})
export class ProductsDatabaseComponent implements OnInit {
  productsList: Product[] = [];

  constructor(
    private productsService: ProductsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // const newProduct: Product = { id: 25, name: 'Produkt numer 25' };
    // this.productsService.addProduct(newProduct);

    // this.productsList = this.productsService.getProducts();
    this.productsService.getProducts().subscribe((products) => {
      this.productsList = products;
    });

    // console.log(this.productsService.getProduct(1));
  }

  onAddNew() {
    this.router.navigate(['/', 'products', 'add']);
  }
}
