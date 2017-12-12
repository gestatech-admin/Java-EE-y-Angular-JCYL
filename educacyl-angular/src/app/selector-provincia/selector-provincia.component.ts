import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProvinciaService} from '../provincia/provincia.service';
import {Provincia} from '../provincia/provincia';

@Component({
  selector: 'app-selector-provincia',
  template: `
    <label for="provincia">Provincia:</label>
    <select (change)="seleccionada($event.target.value)" id="provincia">
      <option></option>
      <option *ngFor="let provincia of provincias$ | async"
              name="provincia" [value]="provincia.id">
        {{provincia.nombre}}
      </option>
    </select>
  `,
})
export class SelectorProvinciaComponent implements OnInit {

  provincias$;

  @Output()
  private provinciaSeleccionada: EventEmitter<Provincia> = new EventEmitter();

  constructor(private provinciaService: ProvinciaService) {
  }

  ngOnInit() {
    this.provincias$ = this.provinciaService.getProvincias();
  }

  seleccionada(provincia) {
    this.provinciaSeleccionada.emit(provincia);
  }

}
