import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplyoeeDetailsComponent } from './emplyoee-details.component';

describe('EmplyoeeDetailsComponent', () => {
  let component: EmplyoeeDetailsComponent;
  let fixture: ComponentFixture<EmplyoeeDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmplyoeeDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplyoeeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
