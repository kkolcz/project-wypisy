import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsAddStep3Component } from './products-add-step3.component';

describe('ProductsAddStep3Component', () => {
  let component: ProductsAddStep3Component;
  let fixture: ComponentFixture<ProductsAddStep3Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductsAddStep3Component]
    });
    fixture = TestBed.createComponent(ProductsAddStep3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
