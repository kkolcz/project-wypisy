import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineProgramComponent } from './machine-program.component';

describe('MachineProgramComponent', () => {
  let component: MachineProgramComponent;
  let fixture: ComponentFixture<MachineProgramComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MachineProgramComponent]
    });
    fixture = TestBed.createComponent(MachineProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
