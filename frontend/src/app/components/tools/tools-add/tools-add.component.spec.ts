import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolsAddComponent } from './tools-add.component';

describe('ToolsAddComponent', () => {
  let component: ToolsAddComponent;
  let fixture: ComponentFixture<ToolsAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ToolsAddComponent]
    });
    fixture = TestBed.createComponent(ToolsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
