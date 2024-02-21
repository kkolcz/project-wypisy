import { Component } from '@angular/core';

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

  onAddProduct(): void {
    console.log(this.newProduct.name);
  }
}
