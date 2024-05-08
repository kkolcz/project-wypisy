import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineProgramDatabaseComponent } from './machine-program-database.component';

describe('MachineProgramDatabaseComponent', () => {
  let component: MachineProgramDatabaseComponent;
  let fixture: ComponentFixture<MachineProgramDatabaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MachineProgramDatabaseComponent]
    });
    fixture = TestBed.createComponent(MachineProgramDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
