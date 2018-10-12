import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplyoeeFormComponent } from './emplyoee-form.component';

describe('EmplyoeeFormComponent', () => {
  let component: EmplyoeeFormComponent;
  let fixture: ComponentFixture<EmplyoeeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmplyoeeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplyoeeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
