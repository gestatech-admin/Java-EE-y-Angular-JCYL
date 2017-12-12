import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectorProvinciaComponent } from './selector-provincia.component';

describe('SelectorProvinciaComponent', () => {
  let component: SelectorProvinciaComponent;
  let fixture: ComponentFixture<SelectorProvinciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectorProvinciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectorProvinciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
