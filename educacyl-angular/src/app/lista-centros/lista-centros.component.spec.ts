import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ListaCentrosComponent} from './lista-centros.component';

describe('ListaCentrosComponent', () => {
  let component: ListaCentrosComponent;
  let fixture: ComponentFixture<ListaCentrosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListaCentrosComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCentrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
