import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsAddStep2Component } from './products-add-step2.component';

describe('ProductsAddStep2Component', () => {
  let component: ProductsAddStep2Component;
  let fixture: ComponentFixture<ProductsAddStep2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductsAddStep2Component]
    });
    fixture = TestBed.createComponent(ProductsAddStep2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
