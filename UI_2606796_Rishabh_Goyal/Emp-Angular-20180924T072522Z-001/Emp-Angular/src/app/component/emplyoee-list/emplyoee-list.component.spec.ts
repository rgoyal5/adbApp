import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplyoeeListComponent } from './emplyoee-list.component';

describe('EmplyoeeListComponent', () => {
  let component: EmplyoeeListComponent;
  let fixture: ComponentFixture<EmplyoeeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmplyoeeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplyoeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
