import {inject, TestBed} from '@angular/core/testing';

import {CentroService} from './centro.service';

describe('CentroService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CentroService]
    });
  });

  it('should be created', inject([CentroService], (service: CentroService) => {
    expect(service).toBeTruthy();
  }));
});
