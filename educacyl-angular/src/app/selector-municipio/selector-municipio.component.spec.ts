import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectorMunicipioComponent } from './selector-municipio.component';

describe('SelectorMunicipioComponent', () => {
  let component: SelectorMunicipioComponent;
  let fixture: ComponentFixture<SelectorMunicipioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectorMunicipioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectorMunicipioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
