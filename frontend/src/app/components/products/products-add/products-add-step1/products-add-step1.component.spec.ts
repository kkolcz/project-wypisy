import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsAddStep1Component } from './products-add-step1.component';

describe('ProductsAddStep1Component', () => {
  let component: ProductsAddStep1Component;
  let fixture: ComponentFixture<ProductsAddStep1Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductsAddStep1Component]
    });
    fixture = TestBed.createComponent(ProductsAddStep1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
