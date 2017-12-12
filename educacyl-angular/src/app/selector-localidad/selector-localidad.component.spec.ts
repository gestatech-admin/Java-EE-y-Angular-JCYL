import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectorLocalidadComponent } from './selector-localidad.component';

describe('SelectorLocalidadComponent', () => {
  let component: SelectorLocalidadComponent;
  let fixture: ComponentFixture<SelectorLocalidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectorLocalidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectorLocalidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
