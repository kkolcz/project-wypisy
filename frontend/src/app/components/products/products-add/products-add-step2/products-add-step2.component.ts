import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-products-add-step2',
  templateUrl: './products-add-step2.component.html',
  styleUrls: ['./products-add-step2.component.scss'],
})
export class ProductsAddStep2Component implements OnInit {
  @Input() formStep2Group;

  onChangeForm = (event) => {
    // console.log(this.formStep1Group);
  };

  ngOnInit(): void {
    // console.log(this.formStep1Group);
  }
}
