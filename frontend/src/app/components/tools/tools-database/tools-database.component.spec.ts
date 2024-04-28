import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolsDatabaseComponent } from './tools-database.component';

describe('ToolsDatabaseComponent', () => {
  let component: ToolsDatabaseComponent;
  let fixture: ComponentFixture<ToolsDatabaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ToolsDatabaseComponent]
    });
    fixture = TestBed.createComponent(ToolsDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
