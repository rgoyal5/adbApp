import { TestBed, inject } from '@angular/core/testing';

import { EmplyoeeService } from './emplyoee.service';

describe('EmplyoeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmplyoeeService]
    });
  });

  it('should be created', inject([EmplyoeeService], (service: EmplyoeeService) => {
    expect(service).toBeTruthy();
  }));
});
