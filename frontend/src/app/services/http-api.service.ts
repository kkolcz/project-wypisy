import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProduct } from '../models/product.model';

interface IToken {
  token: string;
}

@Injectable({
  providedIn: 'root',
})
export class HttpApiService {
  // API_URL = 'http://localhost:8080/api/v1';
  API_URL = 'http://localhost:3000';
  constructor(private http: HttpClient) {}

  verifyToken(token: IToken): boolean {
    const data = {};
    this.http.post(`${this.API_URL}/verify`, data).subscribe((res) => {
      console.log(res);
      return res;
    });

    return false;
  }

  getProducts(): any {
    const data = this.http.get(`${this.API_URL}/products`).subscribe((res) => {
      return res;
    });

    return data;
  }
}
