import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  productsList = [
    { id: 0, name: 'product0' },
    { id: 1, name: 'product1' },
    { id: 2, name: 'product2' },
    { id: 3, name: 'product3' },
    { id: 4, name: 'product4' },
  ];

  getProducts(): Product[] {
    return this.productsList.slice();
  }

  getProduct(id: number): Product {
    const product = this.productsList.find((item) => item.id === id);

    return product;
  }

  setProducts() {}

  addProduct(product: Product): void {
    this.productsList.push(product);
  }

  removeProduct() {}

  constructor() {}
}
