import {inject, TestBed} from '@angular/core/testing';

import {ListaCentrosService} from './lista-centros.service';

describe('ListaCentrosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListaCentrosService]
    });
  });

  it('should be created', inject([ListaCentrosService], (service: ListaCentrosService) => {
    expect(service).toBeTruthy();
  }));
});
