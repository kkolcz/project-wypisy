import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesscategoryAddComponent } from './processcategory-add.component';

describe('ProcesscategoryAddComponent', () => {
  let component: ProcesscategoryAddComponent;
  let fixture: ComponentFixture<ProcesscategoryAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProcesscategoryAddComponent]
    });
    fixture = TestBed.createComponent(ProcesscategoryAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
