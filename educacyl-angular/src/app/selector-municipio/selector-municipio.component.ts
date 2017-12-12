import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MunicipioService} from '../municipio/municipio.service';

@Component({
  selector: 'app-selector-municipio',
  template: `
    <label for="municipio">Municipio:</label>
    <select id="municipio" (change)="seleccionado($event.target.value)">
      <option></option>
      <option *ngFor="let municipio of municipios$ | async"
              name="municipio" [value]="municipio.municipioId.municipioId">
        {{municipio.nombre}}
      </option>
    </select>
  `,
})
export class SelectorMunicipioComponent implements OnInit {

  municipios$;

  @Input() set provinciaId(provinciaId) {
    if (provinciaId) {
      this.municipios$ = this.municipioService.getMunicipiosConProvincia(provinciaId);
    }
  }

  @Output()
  private municipioSeleccionado: EventEmitter<any> = new EventEmitter();

  constructor(private municipioService: MunicipioService) {
  }

  ngOnInit() {
  }

  seleccionado(municipio) {
    this.municipioSeleccionado.emit(municipio);
  }

}
