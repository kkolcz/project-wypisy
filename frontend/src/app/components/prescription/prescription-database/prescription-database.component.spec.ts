import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptionDatabaseComponent } from './prescription-database.component';

describe('PrescriptionDatabaseComponent', () => {
  let component: PrescriptionDatabaseComponent;
  let fixture: ComponentFixture<PrescriptionDatabaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrescriptionDatabaseComponent]
    });
    fixture = TestBed.createComponent(PrescriptionDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
