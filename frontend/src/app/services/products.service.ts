import { Injectable, OnInit } from '@angular/core';
import { IProduct } from '../models/product.model';
import { Product } from '../models/product.model';
import { HttpApiService } from './http-api.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductsService implements OnInit {
  // API_URL = 'http://localhost:8080/api/v1';
  API_URL = 'http://localhost:3000';
  constructor(private httpApi: HttpApiService, private http: HttpClient) {}
  // test = new Product(11, '23');

  // productsList = [
  //   { id: 0, name: 'product0' },
  //   { id: 1, name: 'product1' },
  //   { id: 2, name: 'product2' },
  //   { id: 3, name: 'product3' },
  //   { id: 4, name: 'product4' },
  // ];

  productsList = [
    // new Product(0, 'product0'),
    // new Product(1, 'product1'),
    // new Product(2, 'product2'),
    // new Product(3, 'product3'),
    // new Product(4, 'product4'),
  ];

  getProducts(): Observable<IProduct[]> {
    // console.log(this.productsList);
    return this.http.get<IProduct[]>(`${this.API_URL}/products`);
    // this.dlProducts();
    // return this.productsList.slice();
  }

  getProduct(id: number): IProduct {
    const product = this.productsList.find((item) => item.id === id);

    return product;
  }

  setProducts() {}

  addProduct(product: IProduct): void {
    this.productsList.push(product);
    // console.log(this.productsList);
  }

  removeProduct() {}

  ngOnInit(): void {}

  dlProducts(): void {
    let data = [];
    this.httpApi.getProducts().subscribe((res) => {
      data = Array.from(res);
      console.log(res);
    });
    const data2 = Array.from(data);

    data.map((product) => {
      console.log(product);
    });
    console.log(data);
    console.log('product');

    // data.forE((product) => {
    //   this.productsList.push(product);
    // });
  }
}
