import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-products-add-step3',
  templateUrl: './products-add-step3.component.html',
  styleUrls: ['./products-add-step3.component.scss'],
})
export class ProductsAddStep3Component {
  @Input() formStep3Group;
}
