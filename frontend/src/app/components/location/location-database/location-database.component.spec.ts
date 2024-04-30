import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocationDatabaseComponent } from './location-database.component';

describe('LocationDatabaseComponent', () => {
  let component: LocationDatabaseComponent;
  let fixture: ComponentFixture<LocationDatabaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LocationDatabaseComponent]
    });
    fixture = TestBed.createComponent(LocationDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
