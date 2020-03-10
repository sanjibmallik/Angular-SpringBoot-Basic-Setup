import { TestBed } from '@angular/core/testing';

import { UrlConstructService } from './url-construct.service';

describe('UrlConstructService', () => {
  let service: UrlConstructService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UrlConstructService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
