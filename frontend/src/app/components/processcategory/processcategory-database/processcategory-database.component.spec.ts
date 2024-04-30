import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesscategoryDatabaseComponent } from './processcategory-database.component';

describe('ProcesscategoryDatabaseComponent', () => {
  let component: ProcesscategoryDatabaseComponent;
  let fixture: ComponentFixture<ProcesscategoryDatabaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProcesscategoryDatabaseComponent]
    });
    fixture = TestBed.createComponent(ProcesscategoryDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
