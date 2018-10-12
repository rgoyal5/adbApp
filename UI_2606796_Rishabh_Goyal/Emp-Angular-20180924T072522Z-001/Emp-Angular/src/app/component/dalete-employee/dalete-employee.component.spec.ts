import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DaleteEmployeeComponent } from './dalete-employee.component';

describe('DaleteEmployeeComponent', () => {
  let component: DaleteEmployeeComponent;
  let fixture: ComponentFixture<DaleteEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DaleteEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DaleteEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
