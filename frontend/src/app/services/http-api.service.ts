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
  API_URL = 'http://localhost:8080/api/v1';
  constructor(private http: HttpClient) {}

  verifyToken(token: IToken): boolean {
    const data = {};
    this.http.post(`${this.API_URL}/verify`, data).subscribe((res) => {
      console.log(res);
      return res;
    });

    return false;
  }

  getProducts(): IProduct[] {
    this.http.get(this.API_URL).subscribe((res) => {});
  }
}
