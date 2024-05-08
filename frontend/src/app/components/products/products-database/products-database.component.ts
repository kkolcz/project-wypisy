import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IProductt, Product } from 'src/app/models/product.model';
import { IProductsRes } from 'src/app/models/product.model';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products-database',
  templateUrl: './products-database.component.html',
  styleUrls: ['./products-database.component.scss'],
})
export class ProductsDatabaseComponent implements OnInit {
  productsList: Product[] = [];
  productsList2: IProductt[] = [];

  constructor(
    private productsService: ProductsService,
    private router: Router
  ) {}

  onEditProductHandler = () => {
    console.log('Edit');
  };

  onDeleteProductHandler = () => {
    console.log('Delete');
  };

  ngOnInit(): void {
    this.productsService.getProducts().subscribe((products: IProductsRes) => {
      this.productsList2 = products.data['Products'];
    });
  }

  onAddNew() {
    this.router.navigate(['/', 'products', 'add']);
  }
}
