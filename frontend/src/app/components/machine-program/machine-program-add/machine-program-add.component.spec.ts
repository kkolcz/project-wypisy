import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineProgramAddComponent } from './machine-program-add.component';

describe('MachineProgramAddComponent', () => {
  let component: MachineProgramAddComponent;
  let fixture: ComponentFixture<MachineProgramAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MachineProgramAddComponent]
    });
    fixture = TestBed.createComponent(MachineProgramAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
