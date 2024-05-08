import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-products-add-step1',
  templateUrl: './products-add-step1.component.html',
  styleUrls: ['./products-add-step1.component.scss'],
})
export class ProductsAddStep1Component {
  @Input() formStep1Group;
}
